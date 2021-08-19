package LollapallozaProject.Lollapalloza.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticked_Id")
    private Ticket ticket;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "campusId")
    private Campus campus;

    public Event(LocalDate date, LocalTime start, LocalTime end,Campus campus) {
        this.date = date;
        this.start=start;
        this.end=end;
    }
}
