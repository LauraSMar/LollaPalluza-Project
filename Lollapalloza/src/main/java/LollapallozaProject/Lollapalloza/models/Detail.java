package LollapallozaProject.Lollapalloza.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long Id;
    private Category category;
    private Integer quantity;
    private String description;
    private double subtotal;
    private double priceUnitary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;
    public Detail(Category category, Integer quantity, String description, double subtotal, double priceUnitary) {
        this.category = category;
        this.quantity = quantity;
        this.description = description;
        this.subtotal = subtotal;
        //this.invoice = invoice;
        this.priceUnitary = priceUnitary;
    }





}
