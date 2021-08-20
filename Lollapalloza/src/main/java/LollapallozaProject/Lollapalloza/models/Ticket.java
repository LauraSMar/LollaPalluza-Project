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
        private Long id;

     //   private Category category;
       private String description;
     //   private double price;

        /*@ElementCollection
        @Column(name="days")
        private List<Integer> days = new ArrayList<>();*/

        @OneToOne(mappedBy = "ticket")
        private Detail detail;

        @OneToMany(mappedBy = "ticket",fetch = FetchType.EAGER)
        private Set<Event> events = new HashSet<>();

        public Ticket(String description, Detail detail,Set<Event> events){
          //  this.category=category;
            this.description=description;
         //   this.price=price;
            this.detail = detail;
            this.events = events;
        }


    }
