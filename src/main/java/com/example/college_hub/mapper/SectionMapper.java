package com.example.college_hub.mapper;

import com.example.college_hub.api.model.SectionDto;
import com.example.college_hub.model.Branch;
import com.example.college_hub.model.Faculty;
import com.example.college_hub.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SectionMapper {

    @Autowired
    @Lazy
    private StudentMapper studentMapper;

    @Autowired
    @Lazy
    private FacultyMapper facultyMapper;

    public SectionDto toDto(Section entity) {
        if (entity == null) return null;
        SectionDto dto = new SectionDto();
        dto.setSectionId(entity.getSectionId());
        dto.setSectionName(entity.getSectionName());
        if (entity.getStudents() != null) {
            dto.setStudents(entity.getStudents().stream().map(studentMapper::toDto).collect(Collectors.toList()));
        }
        if (entity.getFaculties() != null) {
            dto.setFaculties(entity.getFaculties().stream().map(facultyMapper::toDto).collect(Collectors.toList()));
        }
        return dto;
    }

    // Overloaded method to be called from BranchMapper
    public Section toEntity(SectionDto dto, Branch parentBranch) {
        if (dto == null) return null;

        Section section = new Section();
        section.setSectionId(dto.getSectionId());
        section.setSectionName(dto.getSectionName());
        section.setBranch(parentBranch); // Set the back-reference to the branch

        if (dto.getStudents() != null) {
            section.setStudents(dto.getStudents().stream().map(studentMapper::toEntity).collect(Collectors.toList()));
            section.getStudents().forEach(student -> student.setSection(section));
        } else {
            section.setStudents(Collections.emptyList());
        }

        if (dto.getFaculties() != null) {
            List<Faculty> faculties = dto.getFaculties().stream()
                .map(facultyMapper::toEntity)
                .collect(Collectors.toList());
            // This is the critical fix: associate the faculty with the correct branch
            faculties.forEach(faculty -> faculty.setBranch(parentBranch));
            section.setFaculties(faculties);
        } else {
            section.setFaculties(Collections.emptyList());
        }

        return section;
    }
    
    // Keep the old method for cases where it might be called without a parent context
    public Section toEntity(SectionDto dto) {
        return toEntity(dto, null);
    }
}
