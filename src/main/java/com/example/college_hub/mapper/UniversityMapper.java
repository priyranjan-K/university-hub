package com.example.college_hub.mapper;

import com.example.college_hub.api.model.UniversityDto;
import com.example.college_hub.model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class UniversityMapper {

    @Autowired
    @Lazy
    private CollegeMapper collegeMapper;

    @Autowired
    @Lazy
    private AddressMapper addressMapper;

    public UniversityDto toDto(University entity) {
        if (entity == null) return null;
        UniversityDto dto = new UniversityDto();
        dto.setUniversityId(entity.getUniversityId());
        dto.setUniversityCode(entity.getUniversityCode());
        if (entity.getColleges() != null) {
            dto.setColleges(entity.getColleges().stream().map(collegeMapper::toDto).collect(Collectors.toList()));
        }
        if (entity.getAddresses() != null) {
            dto.setAddresses(entity.getAddresses().stream().map(addressMapper::toDto).collect(Collectors.toList()));
        }
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLastModifiedDate(entity.getLastModifiedDate());
        return dto;
    }

    public University toEntity(UniversityDto dto) {
        if (dto == null) return null;

        University university = new University();
        university.setUniversityId(dto.getUniversityId());
        university.setUniversityCode(dto.getUniversityCode());
        // createdDate and lastModifiedDate are typically set by @CreationTimestamp/@UpdateTimestamp
        // so we don't map them from DTO to entity for creation/update operations.
        
        if (dto.getColleges() != null) {
            university.setColleges(dto.getColleges().stream().map(collegeMapper::toEntity).collect(Collectors.toList()));
            university.getColleges().forEach(college -> college.setUniversity(university));
        } else {
            university.setColleges(Collections.emptyList());
        }
        
        if (dto.getAddresses() != null) {
            university.setAddresses(dto.getAddresses().stream().map(addressMapper::toEntity).collect(Collectors.toList()));
            university.getAddresses().forEach(address -> address.setUniversity(university));
        } else {
            university.setAddresses(Collections.emptyList());
        }

        return university;
    }
}
