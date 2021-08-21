package LollapallozaProject.Lollapalloza.dtos;

import LollapallozaProject.Lollapalloza.models.Category;
import LollapallozaProject.Lollapalloza.models.Detail;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailDto {

    private Long Id;
    private Category category;
    private Integer quantity;
    private String description;
    private double subtotal;
    private double priceUnitary;
    private InvoiceDto invoiceDto;

    public DetailDto(Detail detail){

        this.Id= detail.getId();
        this.category=detail.getCategory();
        this.quantity=detail.getQuantity();
        this.description= detail.getDescription();
        this.subtotal=detail.getSubtotal();
        this.priceUnitary=detail.getPriceUnitary();
        
    }
}
