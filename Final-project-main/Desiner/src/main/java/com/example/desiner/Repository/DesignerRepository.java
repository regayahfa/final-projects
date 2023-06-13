package com.example.desiner.Repository;

import com.example.desiner.Model.Designer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignerRepository extends JpaRepository<Designer,Integer> {
    Designer findDesignerById(Integer id);

}
