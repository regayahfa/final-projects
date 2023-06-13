package com.example.desiner.Controller;

import com.example.desiner.Model.MyUser;
import com.example.desiner.Repository.MyUserRepository;
import com.example.desiner.Service.MyUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class MyUserController {
    private final MyUserService myUserService;

    @GetMapping("/get")
    private ResponseEntity getAll(){
        List<MyUser> myUsers=myUserService.getAllUsers();
        return ResponseEntity.status(200).body(myUsers);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody MyUser myUser){
        myUserService.addUser(myUser);
        return ResponseEntity.status(200).body("Added Done");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody MyUser myUser, @PathVariable Integer id){
    myUserService.updateUser(myUser,id);
    return ResponseEntity.status(200).body("Updated Done");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        myUserService.deleteUser(id);
        return ResponseEntity.status(200).body("Deleted Done");
    }
}
