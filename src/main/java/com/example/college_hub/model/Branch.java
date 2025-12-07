package com.example.college_hub.model;

import com.example.college_hub.model.comp_key.BranchId;
import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import static com.example.college_hub.util.EnityTableName.BRANCH_TABLE_NAME;

@Entity
@Table(name = BRANCH_TABLE_NAME)
@IdClass(BranchId.class)
@Builder
public class Branch implements Serializable {

    @Serial
    private static final long serialVersionUID = 441266545066309431L;

    @Id
    private String branchName;

    @Id
    private String branchCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Section> sections;

    @CreationTimestamp
    @Column(updatable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate lastModifiedDate;
}
