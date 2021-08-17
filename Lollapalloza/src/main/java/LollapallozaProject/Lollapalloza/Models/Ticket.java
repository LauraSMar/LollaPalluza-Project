package LollapallozaProject.Lollapalloza.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long Id;

    private Integer daysExt;
    private Integer payment;
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    private User user;

    public Ticket(Integer daysExt, Integer payment, double price) {
        this.daysExt = daysExt;
        this.payment = payment;
        this.price = price;
    }
}
