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
public class Campus {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
        @GenericGenerator(name = "native", strategy = "native")
        private Long Id;
        private String location;
        private Integer capacity;

        @OneToOne(mappedBy = "campus")
        private Event event;

        @OneToMany(mappedBy = "campus", fetch = FetchType.EAGER)
        private Set<Band> bands = new HashSet<>();

        public Campus(String location, Integer capacity) {
                this.location=location;
                this.capacity=capacity;
        }
}

