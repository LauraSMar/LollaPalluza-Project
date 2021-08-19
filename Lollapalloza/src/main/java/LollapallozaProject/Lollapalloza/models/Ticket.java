package LollapallozaProject.Lollapalloza.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

        @ElementCollection
        @Column(name="days")
        private List<Integer> days = new ArrayList<>();

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "ticketId")
        private Detail detail;

        @OneToMany(fetch = FetchType.EAGER)
        @JoinColumn(name="eventId")
        private Set<Event> events =new HashSet<>();

        public Ticket(Category category,String description,double price, List<Integer> days, Detail detail,Event event){
            this.category=category;
            this.description=description;
            this.price=price;
            this.days=days;




        }

    }
