package com.example.transitmanagement.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime reportedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getReportedAt() {
		return reportedAt;
	}
	public void setReportedAt(LocalDateTime reportedAt) {
		this.reportedAt = reportedAt;
	}

}
