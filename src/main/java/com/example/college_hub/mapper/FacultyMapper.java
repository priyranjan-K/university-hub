package com.example.college_hub.mapper;

import com.example.college_hub.api.model.FacultyDto;
import com.example.college_hub.model.Faculty;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FacultyMapper {

    public FacultyDto toDto(Faculty entity) {
        if (entity == null) return null;
        FacultyDto dto = new FacultyDto();
        dto.setFacultyId(entity.getFacultyId());
        dto.setFacultyName(entity.getFacultyName());
        dto.setMajorName(entity.getMajorName());
        if (entity.getJoiningDate() != null) {
            dto.setJoiningDate(entity.getJoiningDate());
        }
        return dto;
    }

    public Faculty toEntity(FacultyDto dto) {
        if (dto == null) return null;

        Faculty faculty = new Faculty();
        faculty.setFacultyId(dto.getFacultyId());
        faculty.setFacultyName(dto.getFacultyName());
        faculty.setMajorName(dto.getMajorName());
        faculty.setJoiningDate(dto.getJoiningDate() != null ? dto.getJoiningDate(): null);
        
        return faculty;
    }
}
