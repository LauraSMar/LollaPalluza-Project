package LollapallozaProject.Lollapalloza.services;

import LollapallozaProject.Lollapalloza.dtos.EventDto;
import LollapallozaProject.Lollapalloza.dtos.NewEventDto;
import LollapallozaProject.Lollapalloza.models.Band;
import LollapallozaProject.Lollapalloza.models.Event;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EventService {

    Integer getCapacity(Long id);

    List<EventDto> getAllEvents();

    Optional<Event> getById(Long idEvent);

    ResponseEntity<?> createEvent(NewEventDto dto);

    // modficar los eventos
    ResponseEntity<?> editEvent(Long idEvent, Optional<LocalDate> date, Optional<LocalTime> start, Optional<LocalTime> end);

    ResponseEntity<?> updateBands(Long idEvent, Set<Band> bands);

    ResponseEntity<?> updateCampus(Long eventId, String location, Integer capacity);
}
