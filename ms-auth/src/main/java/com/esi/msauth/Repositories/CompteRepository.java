package com.esi.msauth.Repositories;


import com.esi.msauth.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Long> {
    Optional<Compte> findByUsername(String username);
    boolean existsCompteByUsername(String username);
    Compte findByIdCompte(Long id);
    boolean existsCompteByUsernameAndType(String username,String type);
    Compte findCompteByUsername(String username);

}
