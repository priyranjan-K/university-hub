package com.example.college_hub.mapper;

import com.example.college_hub.api.model.BranchDto;
import com.example.college_hub.model.Branch;
import com.example.college_hub.model.Faculty;
import com.example.college_hub.model.comp_key.BranchId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BranchMapper {

    @Autowired
    @Lazy
    private SectionMapper sectionMapper;

    @Autowired
    @Lazy
    private FacultyMapper facultyMapper;

    public BranchDto toDto(Branch entity) {
        if (entity == null) return null;
        BranchDto dto = new BranchDto();
        if (entity.getBranchId() != null) {
            dto.setBranchName(entity.getBranchId().getBranchName());
            dto.setBranchCode(entity.getBranchId().getBranchCode());
        }
        if (entity.getSections() != null) {
            dto.setSections(entity.getSections().stream().map(sectionMapper::toDto).collect(Collectors.toList()));
        }
        if (entity.getFaculty() != null) {
            dto.setFaculty(entity.getFaculty().stream().map(facultyMapper::toDto).collect(Collectors.toList()));
        }
        return dto;
    }

    public Branch toEntity(BranchDto dto) {
        if (dto == null) return null;

        Branch branch = new Branch();
        branch.setBranchId(new BranchId(dto.getBranchName(), dto.getBranchCode()));
        
        if (dto.getSections() != null) {
            branch.setSections(dto.getSections().stream()
                .map(sectionDto -> sectionMapper.toEntity(sectionDto, branch))
                .collect(Collectors.toList()));
        } else {
            branch.setSections(Collections.emptyList());
        }
        
        if (dto.getFaculty() != null) {
            List<Faculty> facultyList = dto.getFaculty().stream()
                .map(facultyMapper::toEntity)
                .collect(Collectors.toList());
            
            facultyList.forEach(faculty -> faculty.setBranch(branch));
            
            branch.setFaculty(facultyList);
        } else {
            branch.setFaculty(Collections.emptyList());
        }

        return branch;
    }
}
