package com.example.demo.college_hub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

import static com.example.demo.college_hub.util.EnityModelConstants.BRANCH_TABLE_NAME;

@Entity
@Table(name = BRANCH_TABLE_NAME)
public class Branch implements Serializable {
    private static final long serialVersionUID = 441266545066309431L;
    private Long branchId;
    private String branchName;
    private String branchCode;
    private Section section;


}
