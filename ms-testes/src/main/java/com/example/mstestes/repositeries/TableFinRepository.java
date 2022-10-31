package com.example.mstestes.repositeries;

import com.example.mstestes.DTO.TableFinRequest;
import com.example.mstestes.entities.TableDebut;
import com.example.mstestes.entities.TableFin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableFinRepository extends JpaRepository<TableFin,Long> {
    TableFin findTableFinById(Long id);
    TableFin findTableFinByIdCiment(Long idCiment);
    Boolean existsTableFinByIdCiment(Long id);
}