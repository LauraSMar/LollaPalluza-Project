package LollapallozaProject.Lollapalloza.dtos;

import LollapallozaProject.Lollapalloza.models.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cartdto {

    private Long idItem;
    private Category category;
    private Integer quantity;

    public Cartdto(Long idItem, Category category, Integer quantity) {
        this.idItem = idItem;
        this.category = category;
        this.quantity = quantity;
    }
}
