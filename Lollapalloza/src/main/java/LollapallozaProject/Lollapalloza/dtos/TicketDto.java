package LollapallozaProject.Lollapalloza.dtos;

import LollapallozaProject.Lollapalloza.models.Category;
import LollapallozaProject.Lollapalloza.models.Event;
import LollapallozaProject.Lollapalloza.models.Ticket;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class TicketDto {
    private Set<Long> idEvents =new HashSet<>();

    public TicketDto(Set<Long> idEvents) {
        this.idEvents = idEvents;
    }
}
