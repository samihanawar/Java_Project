package com.crimeRepo.crs.repository;
import com.crimeRepo.crs.entities.CrimeReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrimeReportRepository extends JpaRepository<CrimeReport, Long> {

    List<CrimeReport> findByUserId(Long userId);



}

