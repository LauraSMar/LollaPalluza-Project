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

    @GetMapping("image/{id}/comments")
    public Set<CommentDto> getComments(@PathVariable Long imageId){
        return commentService.getCommentsByImageId(imageId);
    }

    @PostMapping("/image/{id}/comments")
    public ResponseEntity<?> createComment(@PathVariable Long imageId, Authentication authentication,@RequestBody String text){
        return commentService.createComment(imageId, authentication, text);
    }

    @PostMapping("comments/{id}")
    public ResponseEntity<?> editComment(Authentication authentication, @PathVariable Long commentId, @RequestBody String newText){
        return commentService.editComment(authentication, commentId, newText);
    }
}
