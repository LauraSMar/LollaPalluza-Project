package LollapallozaProject.Lollapalloza.servicesImplement;

import LollapallozaProject.Lollapalloza.models.*;
import LollapallozaProject.Lollapalloza.services.DetailService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;
@Service
public class DetailServiceImpl implements DetailService {
    @Override
    public boolean createDetailP(Product product, Integer quantity, String description) {
        double subtotal= product.getPrice() * quantity;
        Detail detail =new Detail(Category.PRO,quantity,description,subtotal, product.getPrice());

        return false;
    }

    @Override
    public boolean createDetailT(Ticket ticket, Integer quantity, String description) {
        double subtotal=ticket.getPrice()*quantity;
        Detail detail=new Detail(Category.TKT,quantity,description,subtotal,ticket.getPrice());

        return false;
    }



   /* @Override
    public boolean createInvoice(Set<Detail> details, User user) {
        double total=0;
        for (Detail e:details) {
            total+=e.getSubtotal();
        }
        Invoice invoice=new Invoice(LocalDate.now(), user.getFullName(), total,"Tarjeta",0,user);
        return true;

    }*/

}
