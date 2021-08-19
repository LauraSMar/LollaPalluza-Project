package LollapallozaProject.Lollapalloza.dtos;

import LollapallozaProject.Lollapalloza.models.Invoice;
import LollapallozaProject.Lollapalloza.models.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

public class UserDto {

    private Long Id;
    private String firstName;
    private String lastName;
    private String documentId;
    private String email;
    private String password;


    public UserDto(User user) {
        this.Id= user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.documentId = user.getDocumentId();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
