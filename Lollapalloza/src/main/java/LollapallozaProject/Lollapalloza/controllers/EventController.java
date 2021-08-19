package LollapallozaProject.Lollapalloza.controllers;

import LollapallozaProject.Lollapalloza.dtos.EventDto;
import LollapallozaProject.Lollapalloza.models.Event;
import LollapallozaProject.Lollapalloza.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
