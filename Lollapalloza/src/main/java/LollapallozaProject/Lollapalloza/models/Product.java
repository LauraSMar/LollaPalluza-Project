package LollapallozaProject.Lollapalloza.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long Id;

    private Category category;
    private String description;
    private Integer stock;
    private double price;
    private Set<String> imgs = new HashSet<>();

    public Product(Category category, String description, Integer stock, double price, Set<String> imgs) {
        this.category = category;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.imgs = imgs;
    }
}
