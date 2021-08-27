package LollapallozaProject.Lollapalloza.dtos;

import LollapallozaProject.Lollapalloza.models.Event;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class EventDto {
        private Long id;
        private LocalDate date;
        private LocalTime start;
        private LocalTime end;
        private String img;
        private String campus;
        // lugares disponibles
        private Integer available;

        public EventDto(Event event) {
            this.id = event.getId();
            this.date = event.getDate();
            this.start= event.getStart();
            this.end= event.getEnd();
            this.campus= event.getCampus().getLocation();
            this.img = event.getImg();
            this.available = event.getCampus().getCapacity();
        }

}
