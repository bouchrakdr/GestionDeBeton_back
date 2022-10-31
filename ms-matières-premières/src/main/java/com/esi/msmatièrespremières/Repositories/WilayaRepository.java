package com.esi.msmatièrespremières.Repositories;


import com.esi.msmatièrespremières.entities.Wilaya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WilayaRepository extends JpaRepository<Wilaya,Long> {
    Wilaya findWilayaByNom(String nom);

}
