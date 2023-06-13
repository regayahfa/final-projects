package com.example.desiner.Service;

import com.example.desiner.ApiException.ApiException;
import com.example.desiner.Model.Designer;
import com.example.desiner.Model.Services;
import com.example.desiner.Repository.DesignerRepository;
import com.example.desiner.Repository.ServicesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesService {
private final ServicesRepository servicesRepository;
private final DesignerRepository designerRepository;


public List<Services> getAllServices(){
    return servicesRepository.findAll();
}

   public void addServices(Integer designerId,Services services){
    Designer designer=designerRepository.findDesignerById(designerId);
        services.setDesigner(designer);
        servicesRepository.save(services);
    }

    public void updateServices(Integer id, Services services,Integer designerId){
    Services old=servicesRepository.findServicesById(id);
    Designer designer1=designerRepository.findDesignerById(designerId);

    if (old==null){
        throw new ApiException("Services not found");
    }else if (old.getDesigner().getId()!=designerId){
        throw new ApiException("Sorry , You do not have thing to update this Services!");
    }
    services.setId(id);
    services.setDesigner(designer1);

    servicesRepository.save(services);
   }
    public void deleteServices(Integer id, Integer designerId){
    Services services=servicesRepository.findServicesById(id);
    if (services.getDesigner().getId()!=designerId){
        throw  new ApiException("not found");
    }
    servicesRepository.delete(services);
}

}
