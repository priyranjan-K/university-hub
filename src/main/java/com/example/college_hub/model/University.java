package com.example.college_hub.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.college_hub.util.EnityModelConstants.UNIVERSITY_TABLE_NAME;

@Entity
@Table(name = UNIVERSITY_TABLE_NAME)
@Builder
public class University implements Serializable {

    private static final long serialVersionUID = -7201963539415592534L;

    @Id
    @Column(name = "university_id")
    private Long universityId;

    @Column(name = "university_code", nullable = false, length = 10, unique = true)
    private String universityCode;

    @OneToMany(mappedBy = "college_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "list_of_college")
    private List<College> listOfCollege;

    private Address address;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;

}
