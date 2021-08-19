package LollapallozaProject.Lollapalloza;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import LollapallozaProject.Lollapalloza.repositories.UserRepository;
import LollapallozaProject.Lollapalloza.models.User;
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
			User testUser = new User("Lola","Perez","12341234","lola@gmail.com",passwordEncoder.encode("1234"));
			userRepository.save(testUser);
		};
	}


}
