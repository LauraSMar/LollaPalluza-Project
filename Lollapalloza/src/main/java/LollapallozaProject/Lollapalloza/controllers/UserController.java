package LollapallozaProject.Lollapalloza.controllers;

import LollapallozaProject.Lollapalloza.dtos.UserDto;
import LollapallozaProject.Lollapalloza.models.User;
import LollapallozaProject.Lollapalloza.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public List<UserDto> getUser() {
        return userService.getUsers().stream().map(UserDto::new).collect(Collectors.toList());
    }

    @RequestMapping("users/{id}")
    public User getUser(@PathVariable Long idUser) {
        return userService.getUser(idUser);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> register(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String documentId,@RequestParam String email, @RequestParam String password) {

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }
        if (userService.findByEmail(email) != null) {
            return new ResponseEntity<>("Name already in use", HttpStatus.FORBIDDEN);
        }
        userService.SaveUser(new User(firstName,lastName,documentId,email,passwordEncoder.encode(password)));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping("/users/current")
    public UserDto getUserCurrent(Authentication authentication){
        User user=userService.findByEmail((authentication.getName()));
        if(user.isDeleted()){
            return  new UserDto();
        }

        return new UserDto(user);
    }
}
