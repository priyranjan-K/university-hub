package com.example.college_hub.model;


import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import java.util.List;
import static com.example.college_hub.util.EnityTableName.FACULTY_TABLE_NAME;

@Entity
@Table(name = FACULTY_TABLE_NAME, indexes = {
        @Index(name = "idx_faculty_name", columnList = "facultyName"),
        @Index(name = "idx_fac_branch", columnList = "branchName, branchCode")
})
@Builder
public class Faculty implements Serializable {
    @Serial
    private static final long serialVersionUID = 4291312144479970056L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Long facultyId;
    private String facultyName;
    private String majorName;

    @Temporal(TemporalType.DATE)
    private LocalDate joiningDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
        @JoinColumn(name = "branchName", referencedColumnName = "branchName"),
        @JoinColumn(name = "branchCode", referencedColumnName = "branchCode")
    })
    private Branch branch;

    @ManyToMany(mappedBy = "faculties")
    private List<Section> sections;

}
