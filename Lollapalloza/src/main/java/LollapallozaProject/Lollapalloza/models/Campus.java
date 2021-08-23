package LollapallozaProject.Lollapalloza.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


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

        public Long getId() {
                return Id;
        }

        public void setId(Long id) {
                Id = id;
        }

        public String getLocation() {
                return location;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        public Integer getCapacity() {
                return capacity;
        }

        public void setCapacity(Integer capacity) {
                this.capacity = capacity;
        }

        public Event getEvent() {
                return event;
        }

        public void setEvent(Event event) {
                this.event = event;
        }

        public Set<Band> getBands() {
                return bands;
        }

        public void setBands(Set<Band> bands) {
                this.bands = bands;
        }
}

