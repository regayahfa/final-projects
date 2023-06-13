package com.example.desiner.Controller;

import com.example.desiner.ApiResponse.ApiResponse;
import com.example.desiner.Model.DesignerBusiness;
import com.example.desiner.Service.DesignerBusinessService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class DesignerBusinessController {

    private final DesignerBusinessService designerBusinessService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        List<DesignerBusiness> DBList=designerBusinessService.getAll();
        return ResponseEntity.status(200).body(DBList);
    }
    @PostMapping("/add")
    public ResponseEntity addDB(@Valid @RequestBody DesignerBusiness designerBusiness){
        designerBusinessService.addDB(designerBusiness);
        return ResponseEntity.status(200).body(new ApiResponse("designerBusiness added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateDB(@Valid @RequestBody DesignerBusiness designerBusiness, @PathVariable Integer id){
        designerBusinessService.updateDB(designerBusiness, id);
        return ResponseEntity.status(200).body("designer Business Updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDB(@PathVariable Integer id){
        designerBusinessService.deleteDB(id);
        return ResponseEntity.status(200).body("designer Business deleted");

    }
}
