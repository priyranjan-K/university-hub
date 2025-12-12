package com.example.college_hub.controller;

import com.example.college_hub.api.UniversityHubApi;
import com.example.college_hub.api.model.UniversityDto;
import com.example.college_hub.service.UniversityHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniversityHubController implements UniversityHubApi {

    private final UniversityHubService universityHubService;

    @Autowired
    public UniversityHubController(UniversityHubService universityHubService) {
        this.universityHubService = universityHubService;
    }

    @Override
    public ResponseEntity<UniversityDto> createOrUpdateUniversityStructure(UniversityDto universityDto) {
        UniversityDto createdUniversity = universityHubService.createOrUpdateUniversityStructure(universityDto);
        return ResponseEntity.status(201).body(createdUniversity);
    }
}
