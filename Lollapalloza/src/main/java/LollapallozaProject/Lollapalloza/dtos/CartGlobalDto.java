package LollapallozaProject.Lollapalloza.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartGlobalDto {
    private List<Cartdto> cartdtos = new ArrayList<>();
    private List<TicketDto> ticketDtos = new ArrayList<>();

}
