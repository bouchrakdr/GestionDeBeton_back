package com.esi.msauth.Repositories;
import com.esi.msauth.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {
    boolean existsEmployeByNomAndPrenom(String nom, String prenom);
    Employe findEmployeByCompte_IdCompte(Long id);
    Employe findEmployeByNomAndPrenom(String nom, String prenom);
    Employe findEmployeByIdEmploye(Long id);
     void deleteEmployeByIdEmploye(Long id);
    //ChefService findChefServiceByN(long id);


}
