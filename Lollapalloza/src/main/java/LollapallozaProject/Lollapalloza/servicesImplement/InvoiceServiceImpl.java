package LollapallozaProject.Lollapalloza.servicesImplement;

import LollapallozaProject.Lollapalloza.models.Category;
import LollapallozaProject.Lollapalloza.models.Detail;
import LollapallozaProject.Lollapalloza.models.Invoice;
import LollapallozaProject.Lollapalloza.services.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Override
    public void totalCalcu(Invoice invoice){
        double total = 0;
        for (Detail detail: invoice.getDetails()) {
            total += detail.getSubtotal();
        }
        invoice.setTotal(total);
    }

    @Override
    public void discountCalcu(Invoice invoice){
        List<Detail> details = invoice.getDetails().stream().filter(detail -> detail.getCategory().equals(Category.TKT)).collect(Collectors.toList());
        double discount = 0;
        for (Detail detail: details) {
            discount += detail.getPriceUnitary() - detail.getSubtotal();
        }
        invoice.setDiscount(discount);
    }

    @Override
    public void createNumberInvoice(Invoice invoice){
        invoice.setNumberInvoice("0001-" +String.format("%06d", invoice.getId()));
    }


}
