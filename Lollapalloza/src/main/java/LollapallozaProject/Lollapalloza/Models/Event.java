package LollapallozaProject.Lollapalloza.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long Id;
    private LocalDateTime date;
    private String location;
    private Integer capacity;

    @ElementCollection
    @Column(name="bands")
    private List<String> bands = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    private User user;

    public Event(LocalDateTime date, String location,Integer capacity) {
        this.date = date;
        this.location=location;
        this.capacity=capacity;

    }
}