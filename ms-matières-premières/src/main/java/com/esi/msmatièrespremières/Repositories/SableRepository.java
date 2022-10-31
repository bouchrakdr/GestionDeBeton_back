package com.esi.msmatièrespremières.Repositories;


import com.esi.msmatièrespremières.entities.Sable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SableRepository extends JpaRepository<Sable,Long> {
    Boolean existsSableByNom(String nom);
    Sable findSableByNom(String nom);
    Sable findSableByIdSable(Long id);
    void deleteSableByIdSable(Long id);

}
