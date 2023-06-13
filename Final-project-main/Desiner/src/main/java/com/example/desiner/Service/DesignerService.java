package com.example.desiner.Service;

import com.example.desiner.ApiException.ApiException;
import com.example.desiner.DTO.CustomerDTO;
import com.example.desiner.DTO.DesignerDTO;
import com.example.desiner.Model.Customer;
import com.example.desiner.Model.Designer;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Repository.DesignerRepository;
import com.example.desiner.Repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesignerService {
    private final DesignerRepository designerRepository;
    private final MyUserRepository myUserRepository;

    public List<Designer> findAll() {
        return designerRepository.findAll();
    }

    public void addDesigner(DesignerDTO dto){
        MyUser myUser =myUserRepository.findMyUserById(dto.getUser_id());

        if (myUser==null){
            throw new ApiException("Can't add Customer, Not found");
        }
        Designer designer=new Designer(null, dto.getName(), dto.getEmail(), dto.getLocation(), null,null,myUser,null);
    }

    public void updateDesigner(Designer designer,Integer id){
        Designer designer1=designerRepository.findDesignerById(id);
        if (designer1==null){
            throw new ApiException("Not Found");
        }
        designer1.setName(designer1.getName());
        designer1.setEmail(designer1.getEmail());
        designer1.setLocation(designer1.getLocation());
        designerRepository.save(designer1);
    }

    public void deleteDesigner(Integer id){
        Designer designer=designerRepository.findDesignerById(id);
        if (designer==null){
            throw new ApiException("Not Found");
        }
        designerRepository.delete(designer);
    }


}
