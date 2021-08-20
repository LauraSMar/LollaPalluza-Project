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
    private String img;

    public Product(Category category, String description, Integer stock, double price, String img) {
        this.category = category;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.img = img;
    }
}
