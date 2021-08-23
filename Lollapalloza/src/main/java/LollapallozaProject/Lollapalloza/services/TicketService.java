package LollapallozaProject.Lollapalloza.services;

import LollapallozaProject.Lollapalloza.dtos.TicketDto;
import LollapallozaProject.Lollapalloza.models.Ticket;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.Set;

public interface TicketService{

    Ticket createTicket(TicketDto ticketDto);
}
