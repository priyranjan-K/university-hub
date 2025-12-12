package com.example.college_hub.model;

import com.example.college_hub.model.comp_key.BranchId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static com.example.college_hub.util.EnityTableName.BRANCH_TABLE_NAME;

@Entity
@Table(name = BRANCH_TABLE_NAME)
@Data
@NoArgsConstructor
public class Branch implements Serializable {

    @Serial
    private static final long serialVersionUID = 441266545066309431L;

    @EmbeddedId
    private BranchId branchId;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Section> sections;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Faculty> faculty;

    @CreationTimestamp
    @Column(updatable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate lastModifiedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(branchId, branch.branchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId);
    }
}
