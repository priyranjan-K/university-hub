package com.example.college_hub.mapper;

import com.example.college_hub.api.model.StatusDto;
import com.example.college_hub.model.Status;
import com.example.college_hub.model.StatusCode;
import org.springframework.stereotype.Component;

@Component
public class StatusMapper {

    public StatusDto toDto(Status entity) {
        if (entity == null) return null;
        StatusDto dto = new StatusDto();
        dto.setId(entity.getId());
        dto.setStatusReason(entity.getStatusReason());
        if (entity.getStatusCode() != null) {
            dto.setStatusCode(StatusDto.StatusCodeEnum.fromValue(entity.getStatusCode().name()));
        }
        return dto;
    }

    public Status toEntity(StatusDto dto) {
        if (dto == null) return null;

        Status status = new Status();
        status.setId(dto.getId());
        status.setStatusReason(dto.getStatusReason());
        if (dto.getStatusCode() != null) {
            status.setStatusCode(StatusCode.valueOf(dto.getStatusCode().getValue()));
        }
        
        return status;
    }
}
