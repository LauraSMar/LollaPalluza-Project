package LollapallozaProject.Lollapalloza.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @ElementCollection
    @Column(name="imgs")
    private Set<String> img = new HashSet<>();
    @ElementCollection
    @Column(name="sizes")
    private List<Size> sizeList= new ArrayList<>();

    public Product(Category category, String description, Integer stock, double price, Set<String> img, List<Size> sizeList) {
        this.category = category;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.img =img;
        this.sizeList=sizeList;
    }
}
