package com.esi.msauth.Repositories;

import com.esi.msauth.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    boolean existsAdminByNomAndPrenom(String nom, String prenom);
    Admin findAdminByCompte_IdCompte(Long id);
    Admin findAdminByIdAdmin(Long id);
    Admin findAdminByNomAndPrenom(String nom,String prenom);
    //Optional<Admin> findByCompte(Optional<Compte> compte);

}