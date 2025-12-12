package com.example.college_hub.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

import static com.example.college_hub.util.EnityTableName.STATUS_TABLE_NAME;

@Entity
@Table(name = STATUS_TABLE_NAME)
@Data
@NoArgsConstructor
public class Status implements Serializable {
    @Serial
    private static final long serialVersionUID = -2286093091932945756L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusCode statusCode;

    private String statusReason;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "college_code", referencedColumnName = "collegeCode"), // Changed to property name
            @JoinColumn(name = "college_name", referencedColumnName = "collegeName")  // Changed to property name
    })
    private College college;
}
