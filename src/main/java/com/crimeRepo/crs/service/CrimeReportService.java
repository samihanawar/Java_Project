package com.crimeRepo.crs.service;
import com.crimeRepo.crs.entities.CrimeReport;
import com.crimeRepo.crs.repository.CrimeReportRepository;
import org.springframework.stereotype.Service;
import  java.util.List;
@Service
public class CrimeReportService {

    private final CrimeReportRepository reportRepository;

    public CrimeReportService(CrimeReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public CrimeReport saveReport(CrimeReport report) {
        return reportRepository.save(report);
    }
    public List<CrimeReport> getAllReports() {
        return reportRepository.findAll();
    }

    public List<CrimeReport> getReportsByUserId(Long userId) {
        return reportRepository.findByUserId(userId);
    }

    public CrimeReport getReportById(Long id) {

        return reportRepository.findById(id).orElse(null);
    }
}


