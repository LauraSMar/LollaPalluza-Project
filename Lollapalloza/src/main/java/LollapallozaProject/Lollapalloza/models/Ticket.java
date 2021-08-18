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
public class Ticket {



        @Id
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
        @GenericGenerator(name = "native", strategy = "native")
        private Long Id;
        private Category category;
        private String description;
        private double price;

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "ticketId")
        private Detail detail;

        @OneToMany(fetch = FetchType.EAGER)
        @JoinColumn(name="eventId")
        private Set<Event> events =new HashSet<>();

        public Ticket(Category category,String description,double price, Detail detail){
            this.category=category;
            this.description=description;
            this.price=price;



        }

    }
