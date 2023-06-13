package com.example.desiner.Controller;

import com.example.desiner.Model.Designer;
import com.example.desiner.Model.Services;
import com.example.desiner.Service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/services")
@RequiredArgsConstructor
public class ServicesController {

    private final ServicesService servicesService;

    @GetMapping("/get")
    public ResponseEntity getAllServices(){
        List<Services>services=  servicesService.getAllServices();
        return ResponseEntity.status(200).body(services);
    }

    @PostMapping("/add")
    public ResponseEntity addServices(Designer designer, @RequestBody Services services){
        servicesService.addServices(designer.getId(),services);
        return ResponseEntity.status(200).body("Done added");
    }
    @PutMapping("/update/{servicesId}")
    public ResponseEntity updateServices(Designer designer, @RequestBody Services services,@PathVariable Integer servicesId){
        servicesService.updateServices(designer.getId(),services,servicesId);
        return ResponseEntity.status(200).body("Done updated");
    }

    @DeleteMapping("/delete/{servicesId}")
    public ResponseEntity deleteServices(Designer designer,@PathVariable Integer servicesId){
        servicesService.deleteServices(designer.getId(),servicesId);
        return ResponseEntity.status(200).body("Done deleted");
    }
}
