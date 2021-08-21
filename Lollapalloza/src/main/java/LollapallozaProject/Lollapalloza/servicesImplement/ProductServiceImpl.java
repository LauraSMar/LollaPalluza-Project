package LollapallozaProject.Lollapalloza.servicesImplement;

import LollapallozaProject.Lollapalloza.dtos.ProductDTO;
import LollapallozaProject.Lollapalloza.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import LollapallozaProject.Lollapalloza.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;


import LollapallozaProject.Lollapalloza.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

   @Autowired
   ProductRepository productRepository;

    @Override
    public List<ProductDTO> getProductsDtos() {
        return productRepository.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductDto(Long id){
        return new ProductDTO(productRepository.getById(id));
    }

    @Override
    public ResponseEntity<Object> createProduct(ProductDTO productDTO) {
       if (productDTO.getCategory() == null || productDTO.getDescription().isEmpty() || productDTO.getImg().isEmpty() ||   productDTO.getPrice() <= 0 || productDTO.getStock() < 0){
           return new ResponseEntity<>("missing data", HttpStatus.FORBIDDEN);
       }
        Product product = new Product(productDTO.getCategory(), productDTO.getDescription(), productDTO.getStock(), productDTO.getPrice(), productDTO.getImg());
        productRepository.save(product);
        return new ResponseEntity<>("product created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updatePrice(Long id, double price) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null){
            return new ResponseEntity<>("product does not exist",HttpStatus.FORBIDDEN);
        }
        if (price <= 0){
            return new ResponseEntity<>("price cannot be less than or equal to zero",HttpStatus.FORBIDDEN);
        }
        product.setPrice(price);
        productRepository.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> updateStock(Long id, Integer stock) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null){
            return new ResponseEntity<>("product does not exist",HttpStatus.FORBIDDEN);
        }
        if (stock < 0){
            return new ResponseEntity<>("stock cannot be less than zero",HttpStatus.FORBIDDEN);
        }
        product.setStock(stock);
        productRepository.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
