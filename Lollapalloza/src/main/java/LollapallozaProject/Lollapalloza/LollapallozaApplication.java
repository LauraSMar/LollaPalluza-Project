package LollapallozaProject.Lollapalloza;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import LollapallozaProject.Lollapalloza.Repositories.UserRepository;
import LollapallozaProject.Lollapalloza.Models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;



@SpringBootApplication
public class LollapallozaApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {

		SpringApplication.run(LollapallozaApplication.class, args);
		System.out.println("Welcome Lollapalooza");
	}

	@Bean
	public CommandLineRunner initData(UserRepository userRepository){
		return (args) ->{
			User testUser = new User("nombre", "apellido", "1231212", "ejemplo@email",passwordEncoder.encode("contraseña"));
			userRepository.save(testUser);
		};
	}


}
