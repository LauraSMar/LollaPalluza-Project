package LollapallozaProject.Lollapalloza.servicesImplement;

import LollapallozaProject.Lollapalloza.dtos.ProductDTO;
import LollapallozaProject.Lollapalloza.dtos.UserDto;
import LollapallozaProject.Lollapalloza.models.Product;
import LollapallozaProject.Lollapalloza.models.User;
import LollapallozaProject.Lollapalloza.repositories.UserRepository;
import LollapallozaProject.Lollapalloza.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long idUser) {
        return userRepository.getById(idUser);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> checkDelete(){
        return  userRepository.findAll().stream().filter(e-> !e.isDeleted()).map(UserDto::new).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Object> eraseUser(Long idUser) {
        User user= userRepository.getById(idUser);
       user.setDeleted(true);
        userRepository.save(user);
        return new ResponseEntity<>("Usuerio Borrado", HttpStatus.OK);

    }
}
