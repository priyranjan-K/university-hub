package com.example.college_hub.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.college_hub.util.EnityModelConstants.DEPARTMENT_TABLE_NAME;

@Entity
@Table(name = DEPARTMENT_TABLE_NAME)
public class Department implements Serializable {
    private static final long serialVersionUID = -729241559328644647L;
    @Id
    @Column(name = "department_id")
    private Long departmentId;


    private List<Branch> branchList;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;
}
