package com.crimeRepo.crs.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "crime_reports")
public class CrimeReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String category;
    private String description;
    private String location;
    private String status;
    private String remarks;

    private LocalDateTime reportDate;

    @ManyToOne
    @JoinColumn(name = "user_id" /*,nullable = false*/)
    private User user;
    public CrimeReport() {
        this.reportDate = LocalDateTime.now();
    }
    public CrimeReport(String title, String category, String description, String location, User user) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.location = location;
        this.reportDate = LocalDateTime.now();
        this.user = user;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getReportDate() {
        return reportDate;
    }
    public void setReportDate(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }



}
