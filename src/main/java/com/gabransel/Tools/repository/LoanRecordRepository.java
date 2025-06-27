package com.gabransel.Tools.repository;

import com.gabransel.Tools.entites.LoanRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRecordRepository extends JpaRepository<LoanRecord, Long> {
    List<LoanRecord> findByReturnDateIsNull();
    List<LoanRecord> findByPersonId(Long personId);
    List<LoanRecord> findByToolId(Long toolId);
}
