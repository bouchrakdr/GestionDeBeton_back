package com.example.msbeton.repositories;

import com.example.msbeton.entities.TestBeton3_7j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestBetonEtapeRepository extends JpaRepository<TestBeton3_7j,Long> {
}
