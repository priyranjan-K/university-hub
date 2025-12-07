package com.example.college_hub.repository;

import com.example.college_hub.model.Branch;
import com.example.college_hub.model.comp_key.BranchId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, BranchId> {
}
