package LollapallozaProject.Lollapalloza.dtos;


import LollapallozaProject.Lollapalloza.models.Image;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ImageDto {

    private Long id;
    private String url;
    private String description;
    private LocalDateTime postedAt;
    private Boolean hasComments;

    public ImageDto(Image image){
        this.id = image.getId();
        this.url = image.getUrl();
        this.description = image.getDescription();
        this.postedAt = image.getPostedAt();
        this.hasComments = image.getComments().size() > 0;
    }
}
