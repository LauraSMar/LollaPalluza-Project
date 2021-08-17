package LollapallozaProject.Lollapalloza.Repositories;

import LollapallozaProject.Lollapalloza.Models.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DetailRepository extends JpaRepository<Detail, Long> {
}
