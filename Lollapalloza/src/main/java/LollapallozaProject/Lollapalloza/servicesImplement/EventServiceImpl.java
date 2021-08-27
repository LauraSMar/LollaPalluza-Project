package LollapallozaProject.Lollapalloza.servicesImplement;

import LollapallozaProject.Lollapalloza.dtos.EventDto;
import LollapallozaProject.Lollapalloza.dtos.NewEventDto;
import LollapallozaProject.Lollapalloza.models.Band;
import LollapallozaProject.Lollapalloza.models.Campus;
import LollapallozaProject.Lollapalloza.models.Event;
import LollapallozaProject.Lollapalloza.repositories.BandRepository;
import LollapallozaProject.Lollapalloza.repositories.CampusRespository;
import LollapallozaProject.Lollapalloza.repositories.EventRepository;
import LollapallozaProject.Lollapalloza.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    CampusRespository campusRespository;
    @Autowired
    BandRepository bandRepository;

    @Override
    public Integer getCapacity(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isEmpty()){
            return 0;
        }
        return event.get().getCampus().getCapacity();

    }

    @Override
    public List<EventDto> getAllEvents(){
        return eventRepository.findAll().stream().map(event-> new EventDto(event)).collect(Collectors.toList());
    }

    @Override
    public Optional<Event> getById(Long idEvent) {
        return   eventRepository.findById(idEvent);
    }

    @Override
    public ResponseEntity<?> createEvent(NewEventDto dto) {
        if (dto.getLocation().isEmpty() || dto.getCapacity() <= 0){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        try{
            Campus campus = new Campus(dto.getLocation(), dto.getCapacity());
            campusRespository.save(campus);
            for (Band band: dto.getBands()) {
                Band newBand = new Band(band.getName(), band.getStar(), band.getEnd(), campus);
                bandRepository.save(newBand);
            }
            Event event = new Event(dto.getDate(), dto.getStart(), dto.getEnd(), campus);
            eventRepository.save(event);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error", HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public ResponseEntity<?> editEvent(Long idEvent, Optional<LocalDate> date, Optional<LocalTime> start, Optional<LocalTime> end) {
        if (date.isEmpty() && start.isEmpty() && end.isEmpty()){
            return new ResponseEntity<>("missing data", HttpStatus.FORBIDDEN);
        }
        Event event = eventRepository.findById(idEvent).orElse(null);
        if (event == null){
            return new ResponseEntity<>("event does not exist", HttpStatus.FORBIDDEN);
        }
        if (date.isPresent()){
            event.setDate(date.get());
        }
        start.ifPresent(event::setStart);
        end.ifPresent(event::setEnd);
        eventRepository.save(event);
        return new ResponseEntity<>("event updated",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateBands(Long idEvent, Set<Band> bands) {
        if (bands.isEmpty()){
            return new ResponseEntity<>("missing data", HttpStatus.FORBIDDEN);
        }
        Event event = eventRepository.findById(idEvent).orElse(null);
        if (event == null){
            return new ResponseEntity<>("event does not exist", HttpStatus.FORBIDDEN);
        }
        event.getCampus().getBands().forEach(band -> {bandRepository.delete(band);});
        for (Band band: bands) {
            Band newBand = new Band(band.getName(), band.getStar(), band.getEnd(), event.getCampus());
            bandRepository.save(newBand);
        }
        return new ResponseEntity<>("event updated", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateCampus(Long eventId, String location, Integer capacity) {
        if (location.isEmpty() || capacity <= 0){
            return new ResponseEntity<>("missing parameters", HttpStatus.FORBIDDEN);
        }
       Event event = eventRepository.findById(eventId).orElse(null);
       if (event == null){
           return new ResponseEntity<>("event does not exist", HttpStatus.FORBIDDEN);
       }
       Integer soldTickets = event.getCampus().getCapacity() - event.getAvailable();
       event.setAvailable(capacity - soldTickets);
       Campus campus = new Campus(location, capacity);
       campusRespository.save(campus);
       event.getCampus().getBands().forEach(band -> {
           band.setCampus(campus);
           bandRepository.save(band);
       });
       event.setCampus(campus);
       eventRepository.save(event);
       return new ResponseEntity<>("event updated", HttpStatus.OK);
    }




}
