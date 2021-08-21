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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long Id;

    private String firstName;
    private String lastName;
    private String documentId;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Invoice> invoices = new HashSet<>();

    public User(String firstName, String lastName, String documentId, String email,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentId = documentId;
        this.email = email;
        this.password = password;
    }

    public void setInvoice(Set<Invoice> invoices) {
        this.invoices =invoices;
    }


    public void addInvoice(Invoice invoice) {
        invoice.setUser(this);
        invoices.add(invoice);
    }
}
