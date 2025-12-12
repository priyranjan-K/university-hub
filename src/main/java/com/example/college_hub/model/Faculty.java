package com.example.college_hub.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import static com.example.college_hub.util.EnityTableName.FACULTY_TABLE_NAME;

@Entity
@Table(name = FACULTY_TABLE_NAME, indexes = {
        @Index(name = "idx_faculty_name", columnList = "facultyName"),
        @Index(name = "idx_fac_branch", columnList = "branchName, branchCode")
})
@Data
@NoArgsConstructor
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

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumns({
        @JoinColumn(name = "branchName", referencedColumnName = "branchName"),
        @JoinColumn(name = "branchCode", referencedColumnName = "branchCode")
    })
    private Branch branch;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(facultyId, faculty.facultyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId);
    }
}
