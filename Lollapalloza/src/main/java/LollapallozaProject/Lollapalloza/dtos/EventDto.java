package LollapallozaProject.Lollapalloza.dtos;

import LollapallozaProject.Lollapalloza.models.Event;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class EventDto {
        private Long id;
        private String date;
        private LocalTime start;
        private LocalTime end;
        private String img;
        private String campus;
        // lugares disponibles
        private Integer available;

        public EventDto(Event event) {
            this.id = event.getId();
            this.date = formatterDate(event.getDate());
            this.start= event.getStart();
            this.end= event.getEnd();
            this.campus= event.getCampus().getLocation();
            this.img = event.getImg();
            this.available = event.getCampus().getCapacity();
        }

        public String formatterDate(LocalDate date){
            DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd MMM");
            return date.format(myFormatter);
        }

}
