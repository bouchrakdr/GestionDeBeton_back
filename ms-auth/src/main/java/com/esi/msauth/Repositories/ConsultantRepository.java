package com.esi.msauth.Repositories;


import com.esi.msauth.entities.Consultant;
import com.esi.msauth.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant,Long> {
    boolean existsConsultantByNomAndPrenom(String nom, String prenom);
    Consultant  findConsultantByCompte_IdCompte(Long id);
   Consultant findConsultantByIdConsultant(Long id);



}
