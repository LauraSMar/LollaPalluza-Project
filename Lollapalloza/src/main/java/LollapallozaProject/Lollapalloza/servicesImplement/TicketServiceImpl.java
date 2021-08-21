package LollapallozaProject.Lollapalloza.servicesImplement;


import LollapallozaProject.Lollapalloza.dtos.TicketDto;
import LollapallozaProject.Lollapalloza.models.Event;
import LollapallozaProject.Lollapalloza.models.Ticket;
import LollapallozaProject.Lollapalloza.repositories.EventRepository;
import LollapallozaProject.Lollapalloza.repositories.TicketRepository;
import LollapallozaProject.Lollapalloza.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    EventRepository eventRepository;

    @Override
    public Optional<Ticket> findById(Long idTicket) {
       return ticketRepository.findById(idTicket);
    }

    @Override
    public ResponseEntity<?> createTicket(TicketDto ticketDto) {

            Set<Event> eventList = ticketDto.getIdEvents().stream().map(e->eventRepository.findById(e).get()).collect(Collectors.toSet());
            String description="Ticket para  ";

            for (Event e: eventList) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL");
                description.concat(e.getDate().format(formatter));
                e.setAvailable(e.getAvailable() - ticketDto.getQuantity());
            }

            Ticket ticket=new Ticket(description,eventList);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
