package LollapallozaProject.Lollapalloza.controllers;

import LollapallozaProject.Lollapalloza.dtos.EventDto;
import LollapallozaProject.Lollapalloza.dtos.NewEventDto;
import LollapallozaProject.Lollapalloza.models.Band;
import LollapallozaProject.Lollapalloza.models.Campus;
import LollapallozaProject.Lollapalloza.models.Event;
import LollapallozaProject.Lollapalloza.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/events")
    public List<EventDto> getAllEventsDto(){
         return eventService.getAllEvents();
     }


    @PostMapping("/events")
    public ResponseEntity<?> createEvent(@RequestBody NewEventDto dto){
        return eventService.createEvent(dto);
    }

    @PostMapping("/events/update")
    public ResponseEntity<?> editEvent(@RequestParam Long idEvent, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> date, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) Optional<LocalTime> start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) Optional<LocalTime> end){
        return eventService.editEvent(idEvent, date, start, end);
    }

    @PostMapping("/events/bands")
    public ResponseEntity<?> updateBands(@RequestParam Long idEvent,@RequestBody Set<Band> bands){
        return eventService.updateBands(idEvent, bands);
    }

    @PostMapping("/events/campus")
    public ResponseEntity<?> updateCampus(@RequestParam Long eventId, @RequestParam String location, @RequestParam Integer capacity){
        return eventService.updateCampus(eventId, location, capacity);
    }

}
