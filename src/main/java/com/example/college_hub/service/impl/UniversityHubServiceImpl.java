package com.example.college_hub.service.impl;

import com.example.college_hub.api.model.UniversityDto;
import com.example.college_hub.mapper.UniversityMapper;
import com.example.college_hub.model.University;
import com.example.college_hub.repository.UniversityRepository;
import com.example.college_hub.service.UniversityHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UniversityHubServiceImpl implements UniversityHubService {

    private final UniversityRepository universityRepository;
    private final UniversityMapper universityMapper;

    @Autowired
    public UniversityHubServiceImpl(UniversityRepository universityRepository, UniversityMapper universityMapper) {
        this.universityRepository = universityRepository;
        this.universityMapper = universityMapper;
    }

    @Override
    @Transactional
    public UniversityDto createOrUpdateUniversityStructure(UniversityDto universityDto) {
        University university = universityMapper.toEntity(universityDto);
        University savedUniversity = universityRepository.save(university);
        return universityMapper.toDto(savedUniversity);
    }
}
