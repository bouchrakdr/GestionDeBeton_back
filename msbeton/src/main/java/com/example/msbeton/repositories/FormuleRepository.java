package com.example.msbeton.repositories;


import com.example.msbeton.entities.Formule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormuleRepository extends JpaRepository<Formule,Long> {
    Formule findFormuleById(Long id);

    boolean existsFormuleById(Long id);
    boolean existsFormuleByNom(String nom);
    void deleteFormuleById(Long id);
}
