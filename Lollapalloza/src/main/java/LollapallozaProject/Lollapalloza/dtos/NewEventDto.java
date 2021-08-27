package LollapallozaProject.Lollapalloza.dtos;


import LollapallozaProject.Lollapalloza.models.Band;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
@NoArgsConstructor
public class NewEventDto {
    // campus
    private String location;
    private Integer capacity;
    // band
    private Set<Band> bands;
    // event
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private String img;

    public NewEventDto(String location,  Integer capacity,  LocalDate date, LocalTime start, LocalTime end){
        this.location = location;
        this.capacity = capacity;
        this.date = date;
        this.start = start;
        this.end = end;
    }
}
