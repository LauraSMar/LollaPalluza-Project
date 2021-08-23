package LollapallozaProject.Lollapalloza.servicesImplement;

import LollapallozaProject.Lollapalloza.models.*;
import LollapallozaProject.Lollapalloza.repositories.DetailRepository;
import LollapallozaProject.Lollapalloza.services.DetailService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;
@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    DetailRepository detailRepository;

    @Override
    public Detail createDetailProduct(Product product, Integer quantity, String description, Invoice invoice) {
        double subtotal= product.getPrice() * quantity;

        Detail detail = new Detail(Category.PRO, quantity, description, subtotal , product.getPrice(), invoice);

        detailRepository.save(detail);

        return detail;
    }
    @Override
    public Detail createDetailTicket(Ticket ticket, String description, Invoice invoice) {

        double subtotal = 0;

        if (ticket.getEvents().size() == 2){
            subtotal = ticket.getPrice() * 0.9;
        }
        if (ticket.getEvents().size() > 2){
            subtotal = ticket.getPrice() * 0.8;
        }

        Detail detail = new Detail(Category.TKT, ticket.getEvents().size(), description, subtotal, ticket.getPrice(), invoice);

        detailRepository.save(detail);

        return detail;
    }

}
