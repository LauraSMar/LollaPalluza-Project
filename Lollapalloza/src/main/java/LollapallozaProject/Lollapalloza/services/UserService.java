package LollapallozaProject.Lollapalloza.services;

import LollapallozaProject.Lollapalloza.dtos.ProductDTO;
import LollapallozaProject.Lollapalloza.dtos.UserDto;
import LollapallozaProject.Lollapalloza.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    // Estos metodos sin su cuerpo solo declaracion//


    boolean SaveUser(User user);
    List<User> getUsers();
    User getUser(Long idUser);
    User findByEmail(String email);
    List<UserDto> checkDelete();
    ResponseEntity<Object> eraseUser(Long idUser);
}
