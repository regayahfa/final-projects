package com.example.desiner.Controller;

import com.example.desiner.DTO.DesignerDTO;
import com.example.desiner.Model.Designer;
import com.example.desiner.Service.DesignerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/designer")
@RequiredArgsConstructor
public class DesignerController {
    private final DesignerService designerService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        List<Designer> designers=designerService.findAll();
        return ResponseEntity.status(200).body(designers);
    }
    @PostMapping("/add")
    public ResponseEntity addDesigner(@RequestBody @Valid DesignerDTO designerDTO){
        designerService.addDesigner(designerDTO);
        return ResponseEntity.status(200).body("Added Done");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDesigner(@RequestBody @Valid Designer designer,@PathVariable Integer id){
        designerService.updateDesigner(designer, id);
        return ResponseEntity.status(200).body("Updated Done");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDesigner(@PathVariable Integer id) {
        designerService.deleteDesigner(id);
        return ResponseEntity.status(200).body("Deleted Done");
    }
}
