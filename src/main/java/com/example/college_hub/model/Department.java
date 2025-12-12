package com.example.college_hub.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import static com.example.college_hub.util.EnityTableName.DEPARTMENT_TABLE_NAME;

@Entity
@Table(name = DEPARTMENT_TABLE_NAME, indexes = {
        @Index(name = "idx_department_id", columnList = "department_id"),
        @Index(name = "idx_dept_college", columnList = "college_code, college_name")
})
@Data
@NoArgsConstructor
public class Department implements Serializable {
    @Serial
    private static final long serialVersionUID = -729241559328644647L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
        @JoinColumn(name = "college_code", referencedColumnName = "collegeCode"), // Changed to property name
        @JoinColumn(name = "college_name", referencedColumnName = "collegeName")  // Changed to property name
    })
    private College college;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Branch> branches;

    @CreationTimestamp
    @Column(updatable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate lastModifiedDate;
}
