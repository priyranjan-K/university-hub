package com.example.college_hub.mapper;

import com.example.college_hub.api.model.CollegeDto;
import com.example.college_hub.model.College;
import com.example.college_hub.model.comp_key.CollegeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class CollegeMapper {

    @Autowired
    @Lazy
    private DepartmentMapper departmentMapper;

    @Autowired
    @Lazy
    private AddressMapper addressMapper;

    @Autowired
    @Lazy
    private StatusMapper statusMapper;

    public CollegeDto toDto(College entity) {
        if (entity == null) return null;
        CollegeDto dto = new CollegeDto();
        if (entity.getCollegeId() != null) {
            dto.setCollegeCode(entity.getCollegeId().getCollegeCode());
            dto.setCollegeName(entity.getCollegeId().getCollegeName());
        }
        dto.setStatus(statusMapper.toDto(entity.getStatus()));
        if (entity.getDepartments() != null) {
            dto.setDepartments(entity.getDepartments().stream().map(departmentMapper::toDto).collect(Collectors.toList()));
        }
        if (entity.getAddresses() != null) {
            dto.setAddresses(entity.getAddresses().stream().map(addressMapper::toDto).collect(Collectors.toList()));
        }
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLastModifiedDate(entity.getLastModifiedDate());
        return dto;
    }

    public College toEntity(CollegeDto dto) {
        if (dto == null) return null;

        College college = new College();
        college.setCollegeId(new CollegeId(dto.getCollegeCode(), dto.getCollegeName()));
        college.setStatus(statusMapper.toEntity(dto.getStatus()));
        // createdDate and lastModifiedDate are typically set by @CreationTimestamp/@UpdateTimestamp
        // so we don't map them from DTO to entity for creation/update operations.
        
        if (college.getStatus() != null) {
            college.getStatus().setCollege(college);
        }
        
        if (dto.getDepartments() != null) {
            college.setDepartments(dto.getDepartments().stream().map(departmentMapper::toEntity).collect(Collectors.toList()));
            college.getDepartments().forEach(department -> department.setCollege(college));
        } else {
            college.setDepartments(Collections.emptyList());
        }
        
        if (dto.getAddresses() != null) {
            college.setAddresses(dto.getAddresses().stream().map(addressMapper::toEntity).collect(Collectors.toList()));
            college.getAddresses().forEach(address -> address.setCollege(college));
        } else {
            college.setAddresses(Collections.emptyList());
        }

        return college;
    }
}
