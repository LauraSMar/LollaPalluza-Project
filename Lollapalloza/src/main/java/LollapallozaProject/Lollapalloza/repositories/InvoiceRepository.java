package LollapallozaProject.Lollapalloza.repositories;

import LollapallozaProject.Lollapalloza.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
