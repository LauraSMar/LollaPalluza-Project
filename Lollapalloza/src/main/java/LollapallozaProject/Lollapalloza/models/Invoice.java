package LollapallozaProject.Lollapalloza.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long Id;
    private String cuit;
    private String address;
    private String business_name;
    private double total;
    private double discount;
    private String payment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
    private Set<Detail> details = new HashSet<>();

    public Invoice(String cuit,String address,String business_name,double total, String payment, double discount, User user, Detail detail) {
        this.cuit=cuit;
        this.address=address;
        this.business_name=business_name;
        this.total=total;
        this.discount=discount;
        this.payment=payment;



    }

}
