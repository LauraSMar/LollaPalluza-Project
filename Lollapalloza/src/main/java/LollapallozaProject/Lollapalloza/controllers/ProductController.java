package LollapallozaProject.Lollapalloza.controllers;

import LollapallozaProject.Lollapalloza.dtos.ProductDTO;
import LollapallozaProject.Lollapalloza.repositories.ProductRepositiry;
import LollapallozaProject.Lollapalloza.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepositiry productRepositiry;

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> getProducts(){
      //  return productRepositiry.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());
        return productService.getProductsDtos();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable Long id){
        return productService.getProductDto(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    @PostMapping("/products/price")
    public ResponseEntity<Object> updatePrice(@RequestParam Long id, @RequestParam double price){
        return productService.updatePrice(id, price);
    }

    @PostMapping("/products/stock")
    public ResponseEntity<Object> updateStock(@RequestParam Long id, @RequestParam Integer stock){
        return productService.updateStock(id, stock);
    }


}

