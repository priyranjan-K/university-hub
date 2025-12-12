package com.example.college_hub.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

import static com.example.college_hub.util.EnityTableName.REPORT_CARD_TABLE_NAME;

@Entity
@Table(name = REPORT_CARD_TABLE_NAME, indexes = {
        @Index(name = "idx_student_id", columnList = "student_id")
})
@Data
@NoArgsConstructor
public class ReportCard implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_card_id")
    private Long reportCardId;

    @Enumerated(EnumType.STRING)
    private Semester semester;

    @Column(name = "marks")
    private String marks;

    @Enumerated(EnumType.STRING)
    private ReportCardStatus reportCardStatus;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;
}
