package LollapallozaProject.Lollapalloza.services;

import LollapallozaProject.Lollapalloza.dtos.DetailDto;
import LollapallozaProject.Lollapalloza.models.Detail;
import LollapallozaProject.Lollapalloza.models.Invoice;
import LollapallozaProject.Lollapalloza.models.Product;
import LollapallozaProject.Lollapalloza.models.Ticket;
import org.apache.catalina.User;

import java.util.Set;

public interface DetailService {

    Detail createDetailProduct(Product product, Integer quantity, String description, Invoice invoice);

    Detail createDetailTicket(Ticket ticket,String description, Invoice invoice);

//   boolean createInvoice(Set<Detail> details, User myUser);
}
