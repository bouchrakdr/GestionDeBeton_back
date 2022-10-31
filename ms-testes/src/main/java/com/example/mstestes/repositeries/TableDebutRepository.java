package com.example.mstestes.repositeries;

import com.example.mstestes.entities.TableDebut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableDebutRepository extends JpaRepository<TableDebut,Long> {
    TableDebut findTableDebutById(Long id);
    TableDebut findTableDebutByIdCiment(Long idCiment);
    Boolean existsTableDebutByIdCiment(Long id);
    Boolean existsTableDebutById(Long id);
}




