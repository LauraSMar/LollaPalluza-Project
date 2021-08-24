package LollapallozaProject.Lollapalloza.services;

import LollapallozaProject.Lollapalloza.dtos.CommentDto;
import LollapallozaProject.Lollapalloza.models.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

public interface CommentService {

    Set<CommentDto> getCommentsByImageId(Long imageId);

    ResponseEntity<?> createComment(Long imageId, Authentication authentication, String text);

    ResponseEntity<?> editComment(Authentication authentication, Long commentId, String newText);
}
