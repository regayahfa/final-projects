package com.example.desiner.Controller;

import com.example.desiner.Model.Image;
import com.example.desiner.Service.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class ImageController {
private final ImageService imageService;

    @GetMapping("/get")
    public ResponseEntity getAll()
    {return ResponseEntity.status(200).body(imageService.getAll());}

    @PostMapping("/add")
    public ResponseEntity addImage(@Valid @RequestBody Image image){
        imageService.addImage(image);
        return ResponseEntity.status(200).body("image added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateImage(@Valid @RequestBody Image image, @PathVariable Integer id){
        imageService.updateImage(id, image);
        return ResponseEntity.status(200).body("image updated");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteImage(@PathVariable Integer id){
       imageService.deleteImage(id);
        return ResponseEntity.status(200).body("image deleted");
    }

}
