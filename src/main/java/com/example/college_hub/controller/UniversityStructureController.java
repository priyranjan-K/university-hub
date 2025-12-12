package com.example.college_hub.controller;

import com.example.college_hub.api.UniversityStructureApi;
import com.example.college_hub.api.model.UniversityDto;
import com.example.college_hub.service.UniversityStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniversityStructureController implements UniversityStructureApi {

    private final UniversityStructureService universityStructureService;

    @Autowired
    public UniversityStructureController(UniversityStructureService universityStructureService) {
        this.universityStructureService = universityStructureService;
    }

    @Override
    public ResponseEntity<UniversityDto> createOrUpdateUniversityStructure(UniversityDto universityDto) {
        UniversityDto createdUniversity = universityStructureService.createOrUpdateUniversityStructure(universityDto);
        return ResponseEntity.status(201).body(createdUniversity);
    }
}
