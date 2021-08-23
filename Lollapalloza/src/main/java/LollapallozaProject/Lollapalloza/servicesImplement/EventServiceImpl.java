package LollapallozaProject.Lollapalloza.servicesImplement;

import LollapallozaProject.Lollapalloza.dtos.EventDto;
import LollapallozaProject.Lollapalloza.models.Event;
import LollapallozaProject.Lollapalloza.repositories.EventRepository;
import LollapallozaProject.Lollapalloza.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

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

}
