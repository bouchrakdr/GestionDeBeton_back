package com.example.msbeton.repositories;

import com.example.msbeton.entities.TestBetonfin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestBetonfinRepository extends JpaRepository<TestBetonfin,Long> {
}
