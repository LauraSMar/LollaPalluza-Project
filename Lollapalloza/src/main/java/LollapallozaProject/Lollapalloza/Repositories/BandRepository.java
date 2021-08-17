package LollapallozaProject.Lollapalloza.Repositories;

import LollapallozaProject.Lollapalloza.Models.Band;
import LollapallozaProject.Lollapalloza.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band, Long> {
}
