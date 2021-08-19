package LollapallozaProject.Lollapalloza.servicesImplement;

import LollapallozaProject.Lollapalloza.models.User;
import LollapallozaProject.Lollapalloza.repositories.UserRepository;
import LollapallozaProject.Lollapalloza.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

// agregar anotacion de Servicio//
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;



    @Override
    public boolean SaveUser(User user) {
        userRepository.save(user);
        return false;
    }

    @Override
    public List<User> getUsers() {
       List<User> listUser=userRepository.findAll();
       return listUser;
    }

    @Override
    public User getUser(Long idUser) {
        return userRepository.getById(idUser);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
