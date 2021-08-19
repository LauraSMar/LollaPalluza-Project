package LollapallozaProject.Lollapalloza;

import LollapallozaProject.Lollapalloza.models.*;
import LollapallozaProject.Lollapalloza.repositories.ProductRepositiry;
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
	public CommandLineRunner initData(UserRepository userRepository, ProductRepositiry productRepositiry){
		return (args) ->{
			User testUser = new User("Lola","Perez","12341234","lola@gmail.com",passwordEncoder.encode("1234"));
			userRepository.save(testUser);

			productRepositiry.save(new Product(Category.PRO, "REMERA UNISEX LOLLA MODE ON ROSA", 10, 1050, Set.of("https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/remera-mujer-lolla-rosa_a11-08db4434d187a0018f15210474730620-640-0.jpg","https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/remera-mujer-lolla-rosa_b11-0c676825b898fab37915210474739432-640-0.jpg")));
			productRepositiry.save(new Product(Category.PRO, "REMERA H SLIM LOLLA AZUL", 10, 1100, Set.of("https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/remera-hombre-slim-lolla-azul_a11-c8b46abd750ec1237815210466322555-640-0.jpg", "https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/remera-hombre-slim-lolla-azul_b11-da77cf33e4b3dd576c15210466332882-640-0.jpg")));
			productRepositiry.save(new Product(Category.PRO, "REMERA H SLIM ROCK BLANCO", 5, 800, Set.of("https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/remera-hombre-slim-rock-blanco_a31-67c04170b9980aef7c15210466704854-640-0.jpg", "https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/remera-hombre-slim-lolla-azul_b11-da77cf33e4b3dd576c15210466332882-640-0.jpg")));
			productRepositiry.save(new Product(Category.PRO, "REMERA TEEN SMILE NEGRO", 4, 950, Set.of("https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/remera-teen-smile_a1-941a21d66198993d8c15210482046255-640-0.jpg", "https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/remera-teen-smile_b1-021688db136c02e0d015210482076575-640-0.jpg")));
			productRepositiry.save(new Product(Category.PRO, "MUSCULOSA MUJER LOLLA BOLT BLANCO", 8, 750,Set.of("https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/remera-m-lolla-bolt1-d29ca89e587793e48d15538610193905-640-0.png")));
			productRepositiry.save(new Product(Category.PRO, "REMERA UNISEX LOLLA FULL BOLT", 15, 1350, Set.of("https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/lolla-2118321-2519d31283a1f5ebe415538615237885-640-0.png")));
			productRepositiry.save(new Product(Category.PRO, "Remera Lolla Music", 15, 820, Set.of("https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/sesion-sin-titulo135671-c35bab1e9a71720ecd15959872334113-640-0.jpg", "https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/sesion-sin-titulo135681-1c675f07d475a77cf515959872334950-640-0.jpg")));
			productRepositiry.save(new Product(Category.PRO, "Remera Lolla Band", 20, 550, Set.of("https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/sesion-sin-titulo135291-cd90a76a58b259cf1215959873728285-640-0.jpg", "https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/sesion-sin-titulo135301-0a7761cd8fa77e01b515959873728674-640-0.jpg")));
			productRepositiry.save(new Product(Category.PRO, "Buzo Lolla Holo Niños", 20, 3750, Set.of("https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/sesion-sin-titulo1358611-8f966341225749b03b15960408639273-640-0.jpg", "https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/sesion-sin-titulo1358911-e3ae790ba4fec9628915960408642418-640-0.jpg")));
			productRepositiry.save(new Product(Category.PRO, "Campera Lolla Mix Negra", 11, 4500, Set.of("https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/sesion-sin-titulo135751-d69de559e62e762b1a15960303656441-640-0.jpg", "https://d2r9epyceweg5n.cloudfront.net/stores/698/172/products/sesion-sin-titulo135771-4771b81039582454aa15960303657034-640-0.jpg")));


			Campus campus1 = new Campus("Plaza de Mayo", 6000);
			Campus campus2 = new Campus("Hipodromo de Palermo", 16500);
			Campus campus3 = new Campus("Velez Alfield", 49500);
			Campus campus4 = new Campus("Luna Park", 9200);

			LocalDate date1 = LocalDate.of(2021, 11, 27);
			LocalDate date2 = LocalDate.of(2021, 11, 28);
			LocalDate date3 = LocalDate.of(2021, 11, 29);
			LocalDate date4 = LocalDate.of(2021, 11, 30);

			Event event1 = new Event(date1, LocalTime.of(18, 0), LocalTime.of(23, 30), campus1);
			Event event2 = new Event(date2, LocalTime.of(18, 0), LocalTime.of(23, 30), campus2);
			Event event3 = new Event(date3, LocalTime.of(18, 0), LocalTime.of(23, 30), campus3);
			Event event4 = new Event(date4, LocalTime.of(18, 0), LocalTime.of(23, 30), campus4);



		};
	}


}
