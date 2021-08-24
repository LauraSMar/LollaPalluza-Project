package LollapallozaProject.Lollapalloza.services;

import LollapallozaProject.Lollapalloza.models.Invoice;

public interface InvoiceService {

    void totalCalcu(Invoice invoice);

    void discountCalcu(Invoice invoice);

    void createNumberInvoice(Invoice invoice);

}
