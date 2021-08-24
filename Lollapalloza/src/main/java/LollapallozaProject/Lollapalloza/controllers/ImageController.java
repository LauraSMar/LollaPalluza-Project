package LollapallozaProject.Lollapalloza.controllers;

import LollapallozaProject.Lollapalloza.dtos.ImageDto;
import LollapallozaProject.Lollapalloza.models.Image;
import LollapallozaProject.Lollapalloza.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @GetMapping("/images")
    public Set<ImageDto> getImages(){
        return imageRepository.findAll().stream().map(ImageDto::new).collect(Collectors.toSet());
    }

    @GetMapping("/images/{id}")
    public ImageDto getImage(@PathVariable Long id){
        return new ImageDto(imageRepository.getById(id));
    }

}
