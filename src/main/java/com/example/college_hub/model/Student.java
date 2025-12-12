package com.example.college_hub.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import static com.example.college_hub.util.EnityTableName.STUDENT_TABLE_NAME;

@Entity
@Table(name = STUDENT_TABLE_NAME, indexes = {
        @Index(name = "idx_student_name", columnList = "name"),
        @Index(name = "idx_student_email", columnList = "email"),
        @Index(name = "idx_section_id", columnList = "section_id")
})
@Data
@NoArgsConstructor
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "gender")
    private String gender;

    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @Temporal(TemporalType.DATE)
    private LocalDate admissionDate;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private ReportCard reportCard;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "country_code")
    private  String countryCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    private Section section;

    @CreationTimestamp
    @Column(updatable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate lastModifiedDate;
}
