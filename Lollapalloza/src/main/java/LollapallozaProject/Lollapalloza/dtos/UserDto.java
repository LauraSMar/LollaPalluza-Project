package LollapallozaProject.Lollapalloza.dtos;

import LollapallozaProject.Lollapalloza.models.Invoice;
import LollapallozaProject.Lollapalloza.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class UserDto {

    private Long Id;
    private String firstName;
    private String lastName;
    private String documentId;
    private String email;
    private String password;
    private Set<InvoiceDto> invoices =new HashSet<>();


    public UserDto(User user) {
        this.Id= user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.documentId = user.getDocumentId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.invoices=user.getInvoices().stream().map(InvoiceDto::new).collect(Collectors.toSet());

    }
}
