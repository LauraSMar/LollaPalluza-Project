package LollapallozaProject.Lollapalloza.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String url;
    private LocalDateTime postedAt;

    @OneToMany(mappedBy = "image", fetch = FetchType.EAGER)
    private Set<Comment> comments = new HashSet<>();

    public Image(String url){
        this.url = url;
        this.postedAt = LocalDateTime.now();
    }

}
