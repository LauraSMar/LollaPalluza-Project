package LollapallozaProject.Lollapalloza.servicesImplement;

import LollapallozaProject.Lollapalloza.dtos.CommentDto;
import LollapallozaProject.Lollapalloza.models.Comment;
import LollapallozaProject.Lollapalloza.models.Image;
import LollapallozaProject.Lollapalloza.models.User;
import LollapallozaProject.Lollapalloza.repositories.CommentRepository;
import LollapallozaProject.Lollapalloza.repositories.ImageRepository;
import LollapallozaProject.Lollapalloza.repositories.UserRepository;
import LollapallozaProject.Lollapalloza.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Set<CommentDto> getCommentsByImageId(Long imageId) {
        return commentRepository.findByImageId(imageId).stream().map(CommentDto::new).collect(Collectors.toSet());
    }
    @Override
    public CommentDto getCommentDto(Long id) {
       return this.commentRepository.findById(id).map(CommentDto::new).orElse(null);
    }

    @Override
    public ResponseEntity<?> createComment(Long imageId, Authentication authentication, String text) {
        if (!authentication.isAuthenticated()){
            return new ResponseEntity<>("authentication required", HttpStatus.FORBIDDEN);
        }
        User user = userRepository.findByEmail(authentication.getName());
        if (user == null){
            return new ResponseEntity<>("user does not exist", HttpStatus.FORBIDDEN);
        }
        if (text.isEmpty() || imageId == null){
            return new ResponseEntity<>("missing data", HttpStatus.FORBIDDEN);
        }
        Image image = imageRepository.findById(imageId).orElse(null);
        if (image == null){
            return new ResponseEntity<>("image does not exist", HttpStatus.FORBIDDEN);
        }
        Comment comment = new Comment(text, user, image);
        commentRepository.save(comment);
        return new ResponseEntity<>("comment created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> editComment(Authentication authentication, Long commentId, String newText) {
        if (!authentication.isAuthenticated()){
            return new ResponseEntity<>("authentication required", HttpStatus.FORBIDDEN);
        }
        User user = userRepository.findByEmail(authentication.getName());
        if (user == null){
            return new ResponseEntity<>("user does not exist", HttpStatus.FORBIDDEN);
        }
        if (newText.isEmpty() || commentId == null){
            return new ResponseEntity<>("missing data", HttpStatus.FORBIDDEN);
        }
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (comment == null){
            return new ResponseEntity<>("comment does not exist", HttpStatus.FORBIDDEN);
        }
        comment.setText(newText);
        comment.setUpdatedAt(LocalDateTime.now());
        commentRepository.save(comment);
        return new ResponseEntity<>("comment edited", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteComment(Long id, Authentication authentication) {
        if (!authentication.isAuthenticated()){
            return new ResponseEntity<>("authentication required", HttpStatus.FORBIDDEN);
        }
        User user = userRepository.findByEmail(authentication.getName());
        if (user == null){
            return new ResponseEntity<>("user does not exist", HttpStatus.FORBIDDEN);
        }
        Comment  comment = commentRepository.findById(id).orElse(null);
        if (comment == null){
            return new ResponseEntity<>("comment does not exist", HttpStatus.FORBIDDEN);
        }
        if (comment.getUser() != user){
            return new ResponseEntity<>("comment does not belong to user", HttpStatus.FORBIDDEN);
        }
        commentRepository.delete(comment);
        return new ResponseEntity<>("comment deleted", HttpStatus.OK);
    }


}
