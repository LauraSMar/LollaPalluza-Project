package LollapallozaProject.Lollapalloza.repositories;

import LollapallozaProject.Lollapalloza.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepositiry extends JpaRepository<Product, Long> {
}
