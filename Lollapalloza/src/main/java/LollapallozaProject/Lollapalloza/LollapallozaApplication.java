package LollapallozaProject.Lollapalloza;

import LollapallozaProject.Lollapalloza.models.*;

import LollapallozaProject.Lollapalloza.repositories.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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
	public CommandLineRunner initData(UserRepository userRepository, EventRepository eventRepository, ProductRepository productRepository, CampusRespository campusRespository, InvoiceRepository invoiceRepository, DetailRepository detailRepository, TicketRepository ticketRepository, BandRepository bandRepository){
		return (args) ->{
			User testUser = new User("Lola","Perez","12341234","lola@gmail.com",passwordEncoder.encode("1234"));
			userRepository.save(testUser);

			List<Size> list1=List.of(Size.S,Size.M,Size.XL);
			List<Size> list2=List.of(Size.S,Size.M,Size.XL);
			List<Size> list3=List.of(Size.S,Size.M,Size.XL);
			List<Size> list4=List.of(Size.S,Size.M,Size.XL);
			List<Size> list5=List.of(Size.S,Size.M,Size.XL);
			List<Size> list6=List.of(Size.S,Size.M,Size.XL);
			List<Size> list7=List.of(Size.S,Size.M,Size.XL);
			List<Size> list8=List.of(Size.S,Size.M,Size.XL);
			List<Size> list9=List.of(Size.S,Size.M,Size.XL);
			List<Size> list10=List.of(Size.S,Size.M,Size.XL);
			List<Size> list11=List.of(Size.S,Size.M,Size.XL);
			List<Size> list12=List.of(Size.UNICO);

			Set<String> img1=Set.of("https://tinyurl.com/ygo3kkzt","https://tinyurl.com/983apxyc","https://tinyurl.com/3895u97v");
			Set<String> img2=Set.of("https://tinyurl.com/yhp4p6h4","https://tinyurl.com/2fv6c85h","https://tinyurl.com/9u5y74jm");
			Set<String> img3=Set.of("https://tinyurl.com/yjz8984w","https://tinyurl.com/2rr2vx3r","https://tinyurl.com/npvuncnu");
			Set<String> img4=Set.of("https://tinyurl.com/yhkbgayn","https://tinyurl.com/3nw9ju4x");
			Set<String> img5=Set.of("https://tinyurl.com/yk4tcrw6","https://tinyurl.com/xzptnzb8","https://tinyurl.com/yvndhmd5");
			Set<String> img6=Set.of("https://tinyurl.com/yhjathkz","https://tinyurl.com/ufpsb36n","https://tinyurl.com/tb9amv2n");
			Set<String> img7=Set.of("https://tinyurl.com/yhqxgg3k","https://tinyurl.com/xnavp4du");
			Set<String> img8=Set.of("https://tinyurl.com/ye2m9vc8","https://tinyurl.com/2454b5yv");
			Set<String> img9=Set.of("https://tinyurl.com/yewq475a","https://tinyurl.com/ypa44227");
			Set<String> img10=Set.of("https://tinyurl.com/ydl2druo","https://tinyurl.com/kkx36saw");
			Set<String> img11=Set.of("https://tinyurl.com/4frrmv2n","https://tinyurl.com/wbxcddf9");
			Set<String> img12=Set.of("https://tinyurl.com/dneyuj5a","https://tinyurl.com/yv6u8d7z");
			Set<String> img13=Set.of("https://tinyurl.com/t3b5hnhh","https://tinyurl.com/2badn8r7");
			Set<String> img14=Set.of("https://tinyurl.com/2jbabbwz","https://tinyurl.com/5chk7mnv");
			Set<String> img15=Set.of("https://tinyurl.com/44ph6ach","https://tinyurl.com/jh3v7426");
			Set<String> img16=Set.of("https://tinyurl.com/b58hzh9d");
			Set<String> img17=Set.of("https://tinyurl.com/u7cs3fxh","https://tinyurl.com/227p7kpu","https://tinyurl.com/2ebd2mb6");
			Set<String> img18=Set.of("https://tinyurl.com/5cyswffz");
			Set<String> img19=Set.of("https://tinyurl.com/ery7thbs","https://tinyurl.com/497xt9xs");
			Set<String> img20=Set.of("https://tinyurl.com/ypb2c2ae","https://tinyurl.com/8nkvx4dt");
			Set<String> img21=Set.of("https://tinyurl.com/v2cd9m7p","https://tinyurl.com/46959k4u");
			Set<String> img22=Set.of("https://tinyurl.com/cswvx99s","https://tinyurl.com/b96h5suw");
			Set<String> img23=Set.of("https://tinyurl.com/75ssvt7a","https://tinyurl.com/4rt6yjtp");
			Set<String> img24=Set.of("https://tinyurl.com/c3923zn6","https://tinyurl.com/2tn2sfkk");


			productRepository.save(new Product(Category.PRO, "REMERA UNISEX LOLLA MODE ON ROSA", 1550, 1050,img1,list1));
			productRepository.save(new Product(Category.PRO, "REMERA H SLIM LOLLA AZUL", 1500, 1100, img2,list2));
			productRepository.save(new Product(Category.PRO, "REMERA H SLIM ROCK BLANCO", 1500, 1320,img3,list3));
			productRepository.save(new Product(Category.PRO, "REMERA TEEN SMILE NEGRO", 1500, 1390, img4,list4));
			productRepository.save(new Product(Category.PRO, "MUSCULOSA MUJER LOLLA BOLT BLANCO", 1500, 1390, img5,list5));
			productRepository.save(new Product(Category.PRO, "REMERA UNISEX LOLLA FULL BOLT", 1500, 1350,img6,list6 ));
			productRepository.save(new Product(Category.PRO, "Remera Lolla Music", 1500, 1390,img7,list7 ));
			productRepository.save(new Product(Category.PRO, "Remera Lolla Band", 1500, 1390,img8,list8));
			productRepository.save(new Product(Category.PRO, "Buzo Lolla Holo Niños", 500, 2550, img9,list9));
			productRepository.save(new Product(Category.PRO, "Campera Lolla Mix Negra", 350, 4500, img10,list10));
			productRepository.save(new Product(Category.PRO, "Campera Lolla Mix Blanca", 350, 4500, img11,list11));
			productRepository.save(new Product(Category.PRO, "Gorra Lolla Logo G9", 1550, 1590, img12,list12));
			productRepository.save(new Product(Category.PRO, "Gorra Lolla Rose", 1550, 1590, img13,list12));
			productRepository.save(new Product(Category.PRO, "Piluso Lolla Mix Verde", 1550, 1590, img14,list12));
			productRepository.save(new Product(Category.PRO, "Gorra Fest G9", 1550, 1590, img15,list12));
			productRepository.save(new Product(Category.PRO, "Cuarderno Lolla Face", 1550, 1590, img16,list12));
			productRepository.save(new Product(Category.PRO, "Mochila Adulto Multicolor y Accesorio", 1550, 1590, img17,list12));
			productRepository.save(new Product(Category.PRO, "Vaso Lolla Plastico", 1550, 85, img18,list12));
			productRepository.save(new Product(Category.PRO, "Bandana Lolla Electric", 1550, 590, img19,list12));
			productRepository.save(new Product(Category.PRO, "Bandana Lolla Pride", 1550, 590, img20,list12));
			productRepository.save(new Product(Category.PRO, "Lolla Mask Tie Dye", 1550, 590, img21,list12));
			productRepository.save(new Product(Category.PRO, "Bandolera Lolla Mix", 1550, 1890, img22,list12));
			productRepository.save(new Product(Category.PRO, "Bandolera Lolla Amarilla", 1550, 1890, img23,list12));
			productRepository.save(new Product(Category.PRO, "Bandolera Lolla Negra", 1550, 1890, img24,list12));

			Campus campus1 = new Campus("Casa Rosada", 6000);
			Campus campus2 = new Campus("Hipodromo de Palermo", 16500);
			Campus campus3 = new Campus("Velez Sarsfield", 49500);
			Campus campus4 = new Campus("Luna Park", 9200);

			campusRespository.saveAll(List.of(campus1, campus2, campus3, campus4));

			bandRepository.save(new Band("Lana del Rey", LocalTime.of(17, 0), LocalTime.of(18, 0), campus1));
			bandRepository.save(new Band("La Berriso", LocalTime.of(18, 30), LocalTime.of(19, 30), campus1));
			bandRepository.save(new Band("MÖtley Creü", LocalTime.of(20, 0), LocalTime.of(21, 30), campus1));
			bandRepository.save(new Band("Steve Aoki", LocalTime.of(22, 0), LocalTime.of(23, 45), campus1));
			bandRepository.save(new Band("NTVG", LocalTime.of(17, 0), LocalTime.of(18, 0), campus2));
			bandRepository.save(new Band("21 pilots", LocalTime.of(18, 30), LocalTime.of(19, 30), campus2));
			bandRepository.save(new Band("Paulo Londra", LocalTime.of(20, 0), LocalTime.of(21, 30), campus2));
			bandRepository.save(new Band("Red Hot Chilli Peppers", LocalTime.of(22, 0), LocalTime.of(23, 45), campus2));
			bandRepository.save(new Band("Duki", LocalTime.of(17, 0), LocalTime.of(18, 0), campus4));
			bandRepository.save(new Band("Imagine Dragon", LocalTime.of(18, 30), LocalTime.of(19, 30), campus4));
			bandRepository.save(new Band("Martin Garrix", LocalTime.of(20, 0), LocalTime.of(21, 30), campus4));
			bandRepository.save(new Band("The Weeknd", LocalTime.of(22, 0), LocalTime.of(23, 45), campus4));
			bandRepository.save(new Band("Ed Sheeran", LocalTime.of(17, 0), LocalTime.of(18, 0), campus3));
			bandRepository.save(new Band("Keane", LocalTime.of(18, 30), LocalTime.of(19, 30), campus3));
			bandRepository.save(new Band("Gun´s & Roses", LocalTime.of(20, 0), LocalTime.of(21, 30), campus3));
			bandRepository.save(new Band("Metallica", LocalTime.of(22, 0), LocalTime.of(23, 45), campus3));


			LocalDate date1 = LocalDate.of(2021, 11, 27);
			LocalDate date2 = LocalDate.of(2021, 11, 28);
			LocalDate date3 = LocalDate.of(2021, 11, 29);
			LocalDate date4 = LocalDate.of(2021, 11, 30);

			Event event1 = new Event(date1, LocalTime.of(18, 0), LocalTime.of(23, 30), campus1);
			Event event2 = new Event(date2, LocalTime.of(18, 0), LocalTime.of(23, 30), campus2);
			Event event3 = new Event(date3, LocalTime.of(18, 0), LocalTime.of(23, 30), campus3);
			Event event4 = new Event(date4, LocalTime.of(18, 0), LocalTime.of(23, 30), campus4);
			eventRepository.saveAll(List.of(event1, event2, event3, event4));

			//creacion de factura

			Invoice invoice1 = new Invoice(LocalDate.now(),  "Lola Perez",1500,150,"0001-000000" ,testUser);
			invoiceRepository.save(invoice1);

			Detail detail1 = new Detail(Category.TKT, 1, "Entrada para los eventos 1 y 2", 900, 1000, invoice1);
			detailRepository.save(detail1);

			Ticket ticket1 = new Ticket("Entrada para los eventos 1 y 2",Set.of(event1, event2));
			ticketRepository.save(ticket1);

		};
	}


}
