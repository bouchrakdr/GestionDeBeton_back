package com.example.msbeton.repositories;

import com.example.msbeton.entities.TestBetondb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestBetondbRepository  extends JpaRepository<TestBetondb,Long> {
   Boolean existsTestBetondbByCode(String code);
    TestBetondb findTestBetondbById(Long id);
    Boolean existsTestBetondbById(Long id);

}
