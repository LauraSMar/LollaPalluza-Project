package LollapallozaProject.Lollapalloza.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


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


        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "ticketId")
        private Ticket ticket;

        public Campus(String location, Integer capacity, Ticket ticket) {
            this.location = location;
            this.capacity = capacity;


        }
}

