package com.example.mstestes.repositeries;

import com.example.mstestes.entities.TableEtape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TableEtapeRepository extends JpaRepository<TableEtape,Long> {
   /* TableEtape findTableEtapeByIdCiment(Long idCiment);
   */
    List<TableEtape> findTableEtapeByIdCiment(Long idCiment);

    TableEtape findTableEtap2eById(Long id);
   Boolean existsTableEtap2eByEtape(TableEtape.Etape etape);
    Boolean existsTableEtapeByIdCiment(Long id);

}