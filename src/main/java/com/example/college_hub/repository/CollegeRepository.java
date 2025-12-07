package com.example.college_hub.repository;

import com.example.college_hub.model.College;
import com.example.college_hub.model.comp_key.CollegeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, CollegeId> {
}
