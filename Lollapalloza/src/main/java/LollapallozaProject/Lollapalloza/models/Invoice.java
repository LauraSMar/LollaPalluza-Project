package LollapallozaProject.Lollapalloza.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private LocalDate date;
    private String businessName;
    private double total;
    private double discount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
    private Set<Detail> details = new HashSet<>();

    public Invoice(LocalDate date,String businessName, User user) {
        this.date=date;
        this.businessName= businessName;
        this.total= totalCalcu();
        this.discount= discountCalcu();
        this.user = user;
    }

    public double totalCalcu(){
        double total = 0;
        for (Detail detail: this.getDetails()) {
            total += detail.getSubtotal();
        }
        return total;
    }

    public double discountCalcu(){
        List<Detail> details = this.getDetails().stream().filter(detail -> detail.getCategory().equals(Category.TKT)).collect(Collectors.toList());
        double discount = 0;
        for (Detail detail: details) {
            discount += detail.getPriceUnitary() - detail.getSubtotal();
        }
        return discount;
    }



}
