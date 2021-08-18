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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private Product product;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "ticketId")
    private Ticket ticket;



    public Detail(Category category, Integer quantity, String description, double subtotal, Invoice invoice, Product product, Ticket ticket) {
        this.category= category;
        this.quantity=quantity;
        this.description=description;
        this.subtotal=subtotal;
        this.invoice = invoice;
        this.product = product;
    }
}
