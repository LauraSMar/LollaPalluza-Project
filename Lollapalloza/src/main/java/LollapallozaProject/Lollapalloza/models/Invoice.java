package LollapallozaProject.Lollapalloza.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private LocalDate date;
    private String cuit;
    private String address;
    private String businessName;
    private double total;
    private double discount;
    private String payment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
    private Set<Detail> details = new HashSet<>();

    public Invoice(LocalDate date,String cuit,String address,String businessName,double total, String payment, double discount, User user, Detail detail) {
        this.date=date;
        this.cuit=cuit;
        this.address=address;
        this.businessName=businessName;
        this.total=total;
        this.discount=discount;
        this.payment=payment;

    }

}
