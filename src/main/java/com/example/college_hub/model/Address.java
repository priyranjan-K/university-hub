package com.example.college_hub.model;

import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;

import static com.example.college_hub.util.EnityTableName.ADDRESS_TABLE_NAME;

@Entity
@Table(name = ADDRESS_TABLE_NAME, indexes = {
        @Index(name = "idx_city", columnList = "city"),
        @Index(name = "idx_state", columnList = "state"),
        @Index(name = "idx_zip_code", columnList = "zip_code"),
        @Index(name = "idx_addr_college", columnList = "college_code, college_name"),
        @Index(name = "idx_university_id", columnList = "university_id")
})
@Builder
public class Address implements Serializable {
    @Serial
    private static final long serialVersionUID = -7570681885981445452L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "house_number" ,length = 10, nullable = false)
    private String houseNumber;
    @Column(name = "address_line1" ,length = 50, nullable = false)
    private String addressLine1;
    @Column(name = "address_line2" ,length = 50, nullable = true)
    private String addressLine2;
    @Column(name = "street",length = 50, nullable = true)
    private String street;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "state",nullable = false)
    private String state;
    @Column(name = "zip_code", nullable = false)
    private String zipCode;
    @Column(name = "country", nullable = false)
    private String country;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "college_code", referencedColumnName = "college_code"),
        @JoinColumn(name = "college_name", referencedColumnName = "college_name")
    })
    private College college;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    private University university;
}
