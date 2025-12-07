package com.example.college_hub.repository;

import com.example.college_hub.model.ReportCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportCardRepository extends JpaRepository<ReportCard, Long> {
}
