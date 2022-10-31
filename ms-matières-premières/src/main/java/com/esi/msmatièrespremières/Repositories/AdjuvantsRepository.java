package com.esi.msmatièrespremières.Repositories;


import com.esi.msmatièrespremières.entities.Adjuvants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdjuvantsRepository  extends JpaRepository<Adjuvants,Long> {
        Adjuvants findAdjuvantsByIdAdjuvants(Long id);
        boolean existsAdjuvantsByNom(String nom);
        void deleteAdjuvantsByIdAdjuvants(Long id);

    }
