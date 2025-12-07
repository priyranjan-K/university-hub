package com.example.college_hub.model;

import com.example.college_hub.model.comp_key.CollegeId;
import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import static com.example.college_hub.util.EnityTableName.COLLEGE_TABLE_NAME;

@Entity
@Table(name = COLLEGE_TABLE_NAME)
@IdClass(CollegeId.class)
@Builder
public class College implements Serializable {
    @Serial
    private static final long serialVersionUID = -6347149431888959492L;

    @Id
    @Column(name = "college_code")
    private String collegeCode;

    @Id
    @Column(name = "college_name")
    private String collegeName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Department> departments;

    @OneToOne(mappedBy = "college", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Status status;

    @CreationTimestamp
    @Column(updatable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate lastModifiedDate;
}
