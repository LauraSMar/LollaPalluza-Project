package LollapallozaProject.Lollapalloza.repositories;

import LollapallozaProject.Lollapalloza.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public interface CommentRepository extends JpaRepository<Comment, Long> {

   // Set<Comment> findByImageIdAndCreatedAtBetween(Long imageId, LocalDateTime from, LocalDateTime to);

    Set<Comment> findByImageId(Long imageId);
}
