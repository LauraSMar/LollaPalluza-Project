package LollapallozaProject.Lollapalloza.controllers;

import LollapallozaProject.Lollapalloza.models.Image;
import LollapallozaProject.Lollapalloza.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @GetMapping("/images")
    public List<Image> getImages(){
        return imageRepository.findAll();
    }

    @GetMapping("/images/{id}")
    public Image getImage(@PathVariable Long id){
        return imageRepository.getById(id);
    }

}
