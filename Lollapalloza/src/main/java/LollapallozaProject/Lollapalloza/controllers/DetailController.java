package LollapallozaProject.Lollapalloza.controllers;

import LollapallozaProject.Lollapalloza.dtos.CartGlobalDto;
import LollapallozaProject.Lollapalloza.dtos.Cartdto;
import LollapallozaProject.Lollapalloza.dtos.DetailDto;
import LollapallozaProject.Lollapalloza.dtos.TicketDto;
import LollapallozaProject.Lollapalloza.models.*;
import LollapallozaProject.Lollapalloza.repositories.InvoiceRepository;
import LollapallozaProject.Lollapalloza.repositories.ProductRepository;
import LollapallozaProject.Lollapalloza.repositories.TicketRepository;
import LollapallozaProject.Lollapalloza.services.DetailService;
import LollapallozaProject.Lollapalloza.services.InvoiceService;
import LollapallozaProject.Lollapalloza.services.TicketService;
import LollapallozaProject.Lollapalloza.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DetailController {
    @Autowired
    InvoiceService invoiceService;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TicketService ticketService;

    @Autowired
    DetailService detailService;

    @Transactional
    @PostMapping("/users/current/payment")
    public ResponseEntity<?> payCart(Authentication authentication, @RequestBody CartGlobalDto cartGlobalDto) {
        List<Cartdto> cartProd = cartGlobalDto.getCartdtos();
        List<TicketDto> carTkt = cartGlobalDto.getTicketDtos();
        User myuser = userService.findByEmail(authentication.getName());

        if (cartProd.size() == 0 && carTkt.size() == 0) {//vericamos que ambos dto que contienen los tiket y product no esten vacios al mismo tiempo.
            return new ResponseEntity<>("Carrito Vacío", HttpStatus.FORBIDDEN);
        }
        if (myuser == null){//verificamos el user este login.
            return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }

        Invoice invoice = new Invoice(LocalDate.now(), myuser.getFirstName() + " " +myuser.getLastName(), 0, 0,"0000", myuser);
        invoiceRepository.save(invoice);//creamos la factura, de manera parcial,para despues setearle los datos.

        if (cartProd.size() > 0) {//vericamos si el cartDto tenga productos cargados
            for (Cartdto e : cartProd) {
                Product product = productRepository.findById(e.getIdItem()).orElse(null);//buscamos los productos por id en repository.
                if (product != null && product.getStock() > e.getQuantity()) {//vericamos si el producto existe y que si la cantidad de producto a compra no sea superior al stock.
                    int modifStock = product.getStock() - e.getQuantity();
                    product.setStock(modifStock);//actualizamos el stock.
                    detailService.createDetailProduct(product, e.getQuantity(), invoice);//metodo para crear el detail por cada product.
                }
            }
        }
        if (carTkt.size() > 0) {//vericamos si el cartTkt tenga tikets cargados.
            for (TicketDto ticketDto: carTkt) {
                Ticket ticket = ticketService.createTicket(ticketDto);//creamos el tiket.
                detailService.createDetailTicket(ticket, ticket.getDescription(), invoice);//creamos el detail para cada tiket.
            }
        }

        invoiceService.createNumberInvoice(invoice);//creamos el number de la factura.
        return new ResponseEntity<>("Pago ok", HttpStatus.OK);
    }
}
