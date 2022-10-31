package com.esi.msmatièrespremières.Repositories;


import com.esi.msmatièrespremières.entities.Ciment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CimentRepository extends JpaRepository<Ciment,Long> {
    Ciment findCimentByIdCiment(Long id);
    //boolean existsByIdHopital(Long id);
    boolean existsCimentByIdCiment(Long id);
    boolean existsCimentByNomAndWilaya_Nom(String nom,String wilaya);
    void deleteCimentByIdCiment(Long id);


}
