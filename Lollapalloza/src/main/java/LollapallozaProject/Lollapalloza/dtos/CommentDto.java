package LollapallozaProject.Lollapalloza.dtos;

import LollapallozaProject.Lollapalloza.models.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CommentDto {
    private Long id;

    private String text;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String userName;

    public CommentDto(Comment comment){
        this.id = comment.getId();
        this.text = comment.getText();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
        this.userName = comment.getUser().getFirstName() + " " + comment.getUser().getLastName().substring(0,1);
    }
}
