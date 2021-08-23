package LollapallozaProject.Lollapalloza.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalTime;


@Data
@NoArgsConstructor
@Entity
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long Id;
    private String name;
    private LocalTime star;
    private LocalTime end;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "campusId")
    private Campus campus;

    public Band(String name, LocalTime star, LocalTime end, Campus campus) {
        this.name = name;
        this.star = star;
        this.end = end;
        this.campus = campus;
    }
}