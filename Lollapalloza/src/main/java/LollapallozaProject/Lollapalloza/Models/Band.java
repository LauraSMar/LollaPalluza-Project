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
    public class Band {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
        @GenericGenerator(name = "native", strategy = "native")
        private Long Id;
        private String name;
        private Integer persons;
        private String gender;


        @ManyToOne (fetch = FetchType.EAGER)
        @JoinColumn(name="campusId")
        private Campus campus;

        public Band(String name,Integer persons,String gender, Campus campus) {
            this.name=name;
            this.persons=persons;
            this.gender=gender;


        }
}
