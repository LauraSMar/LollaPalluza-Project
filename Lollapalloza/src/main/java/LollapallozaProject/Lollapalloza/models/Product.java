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
    private Size size;
    private double price;

    @OneToOne(mappedBy = "product")
    private Detail detail;

    public Product(Category category,String description,Integer stock,Integer payment,double price, Detail detail){
        this.category=category;
        this.description=description;
        this.stock=stock;
        this.price=price;
    }
}
