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
            @JoinColumn(name = "college_code", referencedColumnName = "collegeCode"),
            @JoinColumn(name = "college_name", referencedColumnName = "collegeName")
    })
    private College college;
}
