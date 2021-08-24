package LollapallozaProject.Lollapalloza;

import LollapallozaProject.Lollapalloza.models.Campus;
import LollapallozaProject.Lollapalloza.models.Event;
import LollapallozaProject.Lollapalloza.models.Product;
import LollapallozaProject.Lollapalloza.repositories.CampusRespository;
import LollapallozaProject.Lollapalloza.repositories.EventRepository;
import LollapallozaProject.Lollapalloza.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

@SpringBootTest
public class RepositoriesTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    CampusRespository campusRespository;

    @Test
    public void existEvent(){
        List<Event> events = eventRepository.findAll();
        assertThat(events, is(not(empty())));
    }

    @Test
    public void existProduct(){
        List<Product> products = productRepository.findAll();
        assertThat(products, is(not(empty())));
    }

    @Test
    public void existCampus(){
        List<Campus> campuses = campusRespository.findAll();
        assertThat(campuses, hasSize(greaterThan(1)));
    }
}
