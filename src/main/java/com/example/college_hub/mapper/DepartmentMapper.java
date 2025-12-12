package com.example.college_hub.mapper;

import com.example.college_hub.api.model.DepartmentDto;
import com.example.college_hub.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class DepartmentMapper {

    @Autowired
    @Lazy
    private BranchMapper branchMapper;

    public DepartmentDto toDto(Department entity) {
        if (entity == null) return null;
        DepartmentDto dto = new DepartmentDto();
        dto.setDepartmentId(entity.getDepartmentId());
        if (entity.getBranches() != null) {
            dto.setBranches(entity.getBranches().stream().map(branchMapper::toDto).collect(Collectors.toList()));
        }
        return dto;
    }

    public Department toEntity(DepartmentDto dto) {
        if (dto == null) return null;

        Department department = new Department();
        department.setDepartmentId(dto.getDepartmentId());
        
        if (dto.getBranches() != null) {
            department.setBranches(dto.getBranches().stream().map(branchMapper::toEntity).collect(Collectors.toList()));
            department.getBranches().forEach(branch -> branch.setDepartment(department));
        } else {
            department.setBranches(Collections.emptyList());
        }

        return department;
    }
}
