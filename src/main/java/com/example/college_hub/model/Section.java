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

import static com.example.college_hub.util.EnityTableName.SECTION_TABLE_NAME;

@Entity
@Table(name = SECTION_TABLE_NAME, indexes = {
        @Index(name = "idx_section_name", columnList = "sectionName"),
        @Index(name = "idx_sec_branch", columnList = "branchName, branchCode")
})
@Data
@NoArgsConstructor
public class Section implements Serializable {
    @Serial
    private static final long serialVersionUID = 4882979714239832572L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_id")
    private Long sectionId;

    private String sectionName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
        @JoinColumn(name = "branchName", referencedColumnName = "branchName"),
        @JoinColumn(name = "branchCode", referencedColumnName = "branchCode")
    })
    private Branch branch;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "section_faculty",
            joinColumns = @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "faculty_id")
    )
    private List<Faculty> faculties;

    @CreationTimestamp
    @Column(updatable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate lastModifiedDate;
}
