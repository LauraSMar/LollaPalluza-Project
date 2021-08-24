package LollapallozaProject.Lollapalloza.dtos;

import LollapallozaProject.Lollapalloza.models.Detail;
import LollapallozaProject.Lollapalloza.models.Invoice;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class InvoiceDto {

    private LocalDate date;
    private String businessName;
    private double total;
    private double discount;
    private String payments;
    private UserDto userDto;
    private Set<DetailDto> details=new HashSet<>();


    public InvoiceDto(Invoice invoice) {
        this.date = invoice.getDate();
        this.businessName = invoice.getBusinessName();
        this.total = invoice.getTotal();
        this.discount = invoice.getDiscount();
        this.details=invoice.getDetails().stream().map(DetailDto::new).collect(Collectors.toSet());

    }





}
