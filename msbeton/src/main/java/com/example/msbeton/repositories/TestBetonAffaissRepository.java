package com.example.msbeton.repositories;


import com.example.msbeton.entities.TestBetonaffaiss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestBetonAffaissRepository  extends JpaRepository<TestBetonaffaiss,Long> {
}
