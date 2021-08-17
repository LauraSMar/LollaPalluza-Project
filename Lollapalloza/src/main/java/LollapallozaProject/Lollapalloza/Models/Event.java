package LollapallozaProject.Lollapalloza.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long Id;
    private LocalDateTime date;

    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn(name = "ticketId")
    Set<Ticket> tickets = new HashSet<>();

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "campusId")
    private Campus campus;

    public Event(LocalDateTime date) {
        this.date = date;


    }
}
