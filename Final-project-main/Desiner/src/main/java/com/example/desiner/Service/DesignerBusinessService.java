package com.example.desiner.Service;

import com.example.desiner.ApiException.ApiException;
import com.example.desiner.Model.DesignerBusiness;
import com.example.desiner.Repository.DesignerBusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesignerBusinessService {

    private final DesignerBusinessRepository designerBusinessRepository;

    public List<DesignerBusiness> getAll(){

        return designerBusinessRepository.findAll();
    }
    public void addDB(DesignerBusiness designerBusiness){

        designerBusinessRepository.save(designerBusiness);
    }
    public void updateDB(DesignerBusiness designerBusiness,Integer id){
        DesignerBusiness oldDB=designerBusinessRepository.findDesignerBusinessById(id);
        if(oldDB==null){
            throw new ApiException(" designerBusiness not found");
        }
        oldDB.setDesigner(designerBusiness.getDesigner());
        oldDB.setAchievement(designerBusiness.getAchievement());
        oldDB.setImage(designerBusiness.getImage());
        oldDB.setBody(designerBusiness.getBody());

        designerBusinessRepository.save(oldDB);
    }
    public void deleteDB(Integer id){
        DesignerBusiness DB=designerBusinessRepository.findDesignerBusinessById(id);

        if(DB==null){
            throw new ApiException("designerBusiness not found");
        }

        designerBusinessRepository.delete(DB);
    }
}
