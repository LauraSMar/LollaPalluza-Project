package LollapallozaProject.Lollapalloza.Models;

import LollapallozaProject.Lollapalloza.Models.Event;
import LollapallozaProject.Lollapalloza.Models.Ticket;
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

    @OneToMany(mappedBy="user", fetch=FetchType.EAGER)
    Set<Ticket> tickets = new HashSet<>();

    // relacion one to Many con los tkts //

    @OneToMany(mappedBy="user", fetch=FetchType.EAGER)
    Set<Event> events = new HashSet<>();

    public User(String firstName, String lastName, String documentId, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentId = documentId;
        this.email = email;
        this.password = password;
    }
}
