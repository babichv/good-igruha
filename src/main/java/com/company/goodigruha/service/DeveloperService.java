package com.company.goodigruha.service;

import com.company.goodigruha.entity.Developer;
import com.company.goodigruha.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DeveloperService {
    @Autowired
    private final DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public List<Developer> findAll(){
        return developerRepository.getAll();
    }

    public Optional<Developer> findById(Long id){
        return developerRepository.findById(id);
    }

    public Optional<Developer> findByTitle(String title){
        return Optional.ofNullable(developerRepository.getByTitleIgnoreCase(title));
    }
    public Developer save(Developer developer){
        return developerRepository.save(developer);
    }

    public Developer update(Developer developer){
        return developerRepository.save(developer);
    }
}
