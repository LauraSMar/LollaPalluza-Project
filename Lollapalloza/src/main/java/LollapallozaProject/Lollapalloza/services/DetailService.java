package LollapallozaProject.Lollapalloza.services;

import LollapallozaProject.Lollapalloza.dtos.DetailDto;
import LollapallozaProject.Lollapalloza.models.Detail;
import LollapallozaProject.Lollapalloza.models.Product;
import LollapallozaProject.Lollapalloza.models.Ticket;
import org.apache.catalina.User;

import java.util.Set;

public interface DetailService {

    boolean createDetailP(Product product, Integer quantity, String description);
    boolean createDetailT(Ticket ticket, Integer quantity,String description);

//   boolean createInvoice(Set<Detail> details, User myUser);
}
