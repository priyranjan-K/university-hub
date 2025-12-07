package com.example.college_hub.model;

import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;

import static com.example.college_hub.util.EnityTableName.STATUS_TABLE_NAME;

@Entity
@Table(name = STATUS_TABLE_NAME)
@Builder
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
            @JoinColumn(name = "college_code", referencedColumnName = "college_code"),
            @JoinColumn(name = "college_name", referencedColumnName = "college_name")
    })
    private College college;
}
