package LollapallozaProject.Lollapalloza.services;

import LollapallozaProject.Lollapalloza.dtos.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProductsDtos();

    ProductDTO getProductDto(Long id);

    ResponseEntity<Object> createProduct(ProductDTO productDTO);

    ResponseEntity<Object> updatePrice(Long id, double price);

    ResponseEntity<Object> updateStock(Long id, Integer stock);
}


