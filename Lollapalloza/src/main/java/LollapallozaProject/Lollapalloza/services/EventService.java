package LollapallozaProject.Lollapalloza.services;

import LollapallozaProject.Lollapalloza.dtos.EventDto;
import LollapallozaProject.Lollapalloza.models.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    Integer getCapacity(Long id);

    List<EventDto> getAllEvents();

    Optional<Event> getById(Long idEvent);


}
