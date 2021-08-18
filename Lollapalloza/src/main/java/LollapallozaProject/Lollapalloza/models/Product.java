package LollapallozaProject.Lollapalloza.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Product {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long Id;

    @OneToMany(mappedBy = "product")
    private Set<Detail> details = new HashSet<>();
}
