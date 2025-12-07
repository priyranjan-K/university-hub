package com.example.college_hub.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import static com.example.college_hub.util.EnityTableName.UNIVERSITY_TABLE_NAME;

@Entity
@Table(name = UNIVERSITY_TABLE_NAME, indexes = {
        @Index(name = "idx_university_code", columnList = "university_code")
})
@Builder
public class University implements Serializable {

    @Serial
    private static final long serialVersionUID = -7201963539415592534L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private Long universityId;

    @Column(name = "university_code", nullable = false, length = 10, unique = true)
    private String universityCode;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<College> colleges;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

    @CreationTimestamp
    @Column(updatable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate lastModifiedDate;

}
