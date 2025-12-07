package com.example.college_hub.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.college_hub.util.EnityModelConstants.COllEGE_TABLE_NAME;

@Entity
@Table(name = COllEGE_TABLE_NAME)
@Builder
public class College implements Serializable {
    private static final long serialVersionUID = -6347149431888959492L;
    @Id
    @Column(name = "college_id")
    private Long collegeId;
    @Column(name = "college_code")
    private String collegeCode;
    @Column(name = "college_name")
    private String collegeName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    @Column(name = "list_of_department", nullable = false)
    @OneToMany(mappedBy = "college_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Department> listOfDepartment;

    private Status status;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;
}
