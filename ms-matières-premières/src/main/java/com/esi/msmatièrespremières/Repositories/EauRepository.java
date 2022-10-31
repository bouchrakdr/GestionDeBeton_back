package com.esi.msmatièrespremières.Repositories;

import com.esi.msmatièrespremières.entities.Eau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EauRepository extends JpaRepository<Eau,Long> {
    Eau findEauByIdEau(Long id);
    boolean existsEauByNom(String nom);
    void deleteEauByIdEau(Long id);


}
