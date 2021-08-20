package LollapallozaProject.Lollapalloza.dtos;

import LollapallozaProject.Lollapalloza.models.Category;
import LollapallozaProject.Lollapalloza.models.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private Category category;
    private String description;
    private Integer stock;
    private double price;
    private String img;

    public ProductDTO(Product product) {
        this.id= product.getId();
        this.category = product.getCategory();
        this.description = product.getDescription();
        this.stock = product.getStock();
        this.price = product.getPrice();
        this.img = product.getImg();
    }
}
