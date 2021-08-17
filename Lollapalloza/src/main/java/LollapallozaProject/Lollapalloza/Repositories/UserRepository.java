package LollapallozaProject.Lollapalloza.Repositories;

import LollapallozaProject.Lollapalloza.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository <User, Long> {
    public findByEmail(String email);
}
