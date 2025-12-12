package com.example.college_hub.mapper;

import com.example.college_hub.api.model.StudentDto;
import com.example.college_hub.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StudentMapper {

    @Autowired
    @Lazy
    private AddressMapper addressMapper;

    @Autowired
    @Lazy
    private ReportCardMapper reportCardMapper;

    public StudentDto toDto(Student entity) {
        if (entity == null) return null;
        StudentDto dto = new StudentDto();
        dto.setStudentId(entity.getStudentId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setGender(entity.getGender());
        if (entity.getDateOfBirth() != null) {
            dto.setDateOfBirth(entity.getDateOfBirth());
        }
        if (entity.getAdmissionDate() != null) {
            dto.setAdmissionDate(entity.getAdmissionDate());
        }
        dto.setMobileNumber(entity.getMobileNumber());
        dto.setAddress(addressMapper.toDto(entity.getAddress()));
        dto.setReportCard(reportCardMapper.toDto(entity.getReportCard()));
        return dto;
    }

    public Student toEntity(StudentDto dto) {
        if (dto == null) return null;

        Student student = new Student();
        student.setStudentId(dto.getStudentId());
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setGender(dto.getGender());
        student.setDateOfBirth(dto.getDateOfBirth() != null ? dto.getDateOfBirth() : null);
        student.setAdmissionDate(dto.getAdmissionDate() != null ? dto.getAdmissionDate() : null);
        student.setMobileNumber(dto.getMobileNumber());
        student.setAddress(addressMapper.toEntity(dto.getAddress()));
        student.setReportCard(reportCardMapper.toEntity(dto.getReportCard()));

        if (student.getReportCard() != null) {
            student.getReportCard().setStudent(student);
        }

        return student;
    }
}
