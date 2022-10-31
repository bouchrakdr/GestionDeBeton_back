package com.esi.msmatièrespremières.Repositories;

import com.esi.msmatièrespremières.entities.Gravier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GravierRepository extends JpaRepository<Gravier,Long> {
    Boolean existsGravierByNom(String nom);
    Gravier findGravierByNom(String nom);
    Gravier findGravierByIdGravier(Long id);
    void deleteGravierByIdGravier(Long id);
    ;
}
