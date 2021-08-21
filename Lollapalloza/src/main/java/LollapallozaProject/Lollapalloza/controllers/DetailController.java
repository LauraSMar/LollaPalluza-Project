package LollapallozaProject.Lollapalloza.controllers;

import LollapallozaProject.Lollapalloza.dtos.Cartdto;
import LollapallozaProject.Lollapalloza.dtos.DetailDto;
import LollapallozaProject.Lollapalloza.dtos.TicketDto;
import LollapallozaProject.Lollapalloza.models.*;
import LollapallozaProject.Lollapalloza.repositories.ProductRepository;
import LollapallozaProject.Lollapalloza.repositories.TicketRepository;
import LollapallozaProject.Lollapalloza.services.DetailService;
import LollapallozaProject.Lollapalloza.services.TicketService;
import LollapallozaProject.Lollapalloza.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DetailController {
    @Autowired
    UserService userService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    TicketService ticketService;
    @Autowired
    DetailService detailService;

    @PostMapping(path = "/users/current/payment")
    public ResponseEntity<?> payCart(Authentication authentication, @RequestBody List<Cartdto> cartProd, @RequestBody Set<TicketDto> carTkt){

            User myuser = userService.findByEmail(authentication.getName());

            if(cartProd.size()==0 && carTkt.size()==0){
                return new ResponseEntity<>("Carrito Vacío", HttpStatus.FORBIDDEN);

            }
            if(cartProd.size()>0){

                for (Cartdto e : cartProd) {
                 Optional<Product> productFind=productRepository.findById(e.getIdItem());

                 if(productFind.isPresent() && productFind.get().getStock() >e.getQuantity()){


                       int modifStock= productFind.get().getStock()-e.getQuantity();
                       productFind.get().setStock(modifStock);
                       detailService.createDetailP(productFind.get(),e.getQuantity(),productFind.get().getDescription());
                 }

            }
            if(carTkt.size()>0){

            for (TicketDto e : carTkt) {
                ticketService.createTicket(e);
                Ticket ticketFound= ticketService.findById(e.getId()).orElse(null);

                detailService.createDetailT(ticketFound, e.getQuantity(), ticketFound.getDescription());

            }
        }



    }

        return new ResponseEntity<>("Pago ok", HttpStatus.OK);

    }




}
