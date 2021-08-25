package LollapallozaProject.Lollapalloza.controllers;

import LollapallozaProject.Lollapalloza.dtos.CommentDto;
import LollapallozaProject.Lollapalloza.models.Comment;
import LollapallozaProject.Lollapalloza.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CommentController {

    @Autowired
    CommentService commentService;

    // para tener todos los comments de una imagen con su id
    @GetMapping("/images/{id}/comments")
    public Set<CommentDto> getComments(@PathVariable Long id){
        return commentService.getCommentsByImageId(id);
    }

    // para obtener un solo comentario por su id
    @GetMapping("/comments/{id}")
    public CommentDto getComment(@PathVariable Long id) {
        return commentService.getCommentDto(id);
    }

    // para crear un nuevo comment para esa imagen
    @PostMapping("/images/{id}/comments")
    public ResponseEntity<?> createComment(@PathVariable Long id, Authentication authentication,@RequestParam String text){
        return commentService.createComment(id, authentication, text);
    }

    // para editar un comentario
    @PostMapping("/comments/{id}")
    public ResponseEntity<?> editComment(Authentication authentication, @PathVariable Long id, @RequestBody String newText){
        return commentService.editComment(authentication, id, newText);
    }

    // para borrar un comment
    @DeleteMapping("/comments/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id, Authentication authentication){
        return commentService.deleteComment(id, authentication);
    }

}
