package com.example.college_hub.mapper;

import com.example.college_hub.api.model.ReportCardDto;
import com.example.college_hub.model.ReportCard;
import com.example.college_hub.model.ReportCardStatus;
import com.example.college_hub.model.Semester;
import org.springframework.stereotype.Component;

@Component
public class ReportCardMapper {

    public ReportCardDto toDto(ReportCard entity) {
        if (entity == null) return null;
        ReportCardDto dto = new ReportCardDto();
        dto.setReportCardId(entity.getReportCardId());
        dto.setMarks(entity.getMarks());
        if (entity.getSemester() != null) {
            dto.setSemester(ReportCardDto.SemesterEnum.fromValue(entity.getSemester().name()));
        }
        if (entity.getReportCardStatus() != null) {
            dto.setReportCardStatus(ReportCardDto.ReportCardStatusEnum.fromValue(entity.getReportCardStatus().name()));
        }
        return dto;
    }

    public ReportCard toEntity(ReportCardDto dto) {
        if (dto == null) return null;

        ReportCard reportCard = new ReportCard();
        reportCard.setReportCardId(dto.getReportCardId());
        reportCard.setMarks(dto.getMarks());
        if (dto.getSemester() != null) {
            reportCard.setSemester(Semester.valueOf(dto.getSemester().getValue()));
        }
        if (dto.getReportCardStatus() != null) {
            reportCard.setReportCardStatus(ReportCardStatus.valueOf(dto.getReportCardStatus().getValue()));
        }
        
        return reportCard;
    }
}
