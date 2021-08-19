package LollapallozaProject.Lollapalloza.services;

import LollapallozaProject.Lollapalloza.models.User;

import java.util.List;

public interface UserService {

    // Estos metodos sin su cuerpo solo declaracion//


    boolean SaveUser(User user);
    List<User> getUsers();
    User getUser(Long idUser);
    User findByEmail(String email);
}
