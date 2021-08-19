package LollapallozaProject.Lollapalloza.services;

import LollapallozaProject.Lollapalloza.dtos.EventDto;

import java.util.List;

public interface EventService {

    Integer getCapacity(Long id);

    List<EventDto> getAllEvents();



}
