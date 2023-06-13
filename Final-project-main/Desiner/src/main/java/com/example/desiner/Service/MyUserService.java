package com.example.desiner.Service;

import com.example.desiner.ApiException.ApiException;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MyUserService {
private final MyUserRepository myUserRepository;

  public List<MyUser> getAllUsers(){
      return myUserRepository.findAll();
  }

public void addUser(MyUser myUser){
      myUserRepository.save(myUser);
}

public void updateUser(MyUser myUser,Integer id) {
    MyUser old = myUserRepository.findMyUserById(id);
    if (old == null) {
        throw new ApiException("there is no user to update");
    }
    old.setId(old.getId());
    old.setUsername(old.getUsername());
    old.setPassword(old.getPassword());
    old.setRole(old.getRole());
    myUserRepository.save(old);
}
public void deleteUser(Integer id){
      MyUser user1=myUserRepository.findMyUserById(id);
      if (user1==null){
          throw new ApiException("there is no user to delete");
      }
      myUserRepository.delete(user1);
  }

}
