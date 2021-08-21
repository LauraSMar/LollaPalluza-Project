package LollapallozaProject.Lollapalloza.controllers;

import LollapallozaProject.Lollapalloza.dtos.ProductDTO;

import LollapallozaProject.Lollapalloza.services.ProductService;
import LollapallozaProject.Lollapalloza.services.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> getProducts(){
       return productService.getProductsDtos();
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

