package LollapallozaProject.Lollapalloza;

import LollapallozaProject.Lollapalloza.models.*;

import LollapallozaProject.Lollapalloza.repositories.ProductRepositiry;

import LollapallozaProject.Lollapalloza.repositories.CampusRespository;
import LollapallozaProject.Lollapalloza.repositories.EventRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import LollapallozaProject.Lollapalloza.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootApplication
public class LollapallozaApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {

		SpringApplication.run(LollapallozaApplication.class, args);
		System.out.println("Welcome Lollapalooza");
	}

	@Bean
	public CommandLineRunner initData(UserRepository userRepository, EventRepository eventRepository,ProductRepositiry productRepositiry, CampusRespository campusRespository){
		return (args) ->{
			User testUser = new User("Lola","Perez","12341234","lola@gmail.com",passwordEncoder.encode("1234"));
			userRepository.save(testUser);

			productRepositiry.save(new Product(Category.PRO, "REMERA UNISEX LOLLA MODE ON ROSA", 10, 1050));
			productRepositiry.save(new Product(Category.PRO, "REMERA H SLIM LOLLA AZUL", 10, 1100));
			productRepositiry.save(new Product(Category.PRO, "REMERA H SLIM ROCK BLANCO", 5, 800));
			productRepositiry.save(new Product(Category.PRO, "REMERA TEEN SMILE NEGRO", 4, 9502));
			productRepositiry.save(new Product(Category.PRO, "MUSCULOSA MUJER LOLLA BOLT BLANCO", 8, 750));
			productRepositiry.save(new Product(Category.PRO, "REMERA UNISEX LOLLA FULL BOLT", 15, 1350));
			productRepositiry.save(new Product(Category.PRO, "Remera Lolla Music", 15, 820));
			productRepositiry.save(new Product(Category.PRO, "Remera Lolla Band", 20, 550));
			productRepositiry.save(new Product(Category.PRO, "Buzo Lolla Holo Niños", 20, 3750));
			productRepositiry.save(new Product(Category.PRO, "Campera Lolla Mix Negra", 11, 4500));

			Campus campus1 = new Campus("Plaza de Mayo", 6000);
			Campus campus2 = new Campus("Hipodromo de Palermo", 16500);
			Campus campus3 = new Campus("Velez Alfield", 49500);
			Campus campus4 = new Campus("Luna Park", 9200);
			campusRespository.save(campus1);
			campusRespository.save(campus2);
			campusRespository.save(campus3);
			campusRespository.save(campus4);

			LocalDate date1 = LocalDate.of(2021, 11, 27);
			LocalDate date2 = LocalDate.of(2021, 11, 28);
			LocalDate date3 = LocalDate.of(2021, 11, 29);
			LocalDate date4 = LocalDate.of(2021, 11, 30);

			Event event1 = new Event(date1, LocalTime.of(18, 0), LocalTime.of(23, 30), campus1);
			Event event2 = new Event(date2, LocalTime.of(18, 0), LocalTime.of(23, 30), campus2);
			Event event3 = new Event(date3, LocalTime.of(18, 0), LocalTime.of(23, 30), campus3);
			Event event4 = new Event(date4, LocalTime.of(18, 0), LocalTime.of(23, 30), campus4);
			eventRepository.save(event1);
			eventRepository.save(event2);
			eventRepository.save(event3);
			eventRepository.save(event4);

			Ticket ticket1 = new Ticket("hola");

		};
	}


}
