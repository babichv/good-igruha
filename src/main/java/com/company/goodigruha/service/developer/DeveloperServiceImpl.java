package com.company.goodigruha.service;

import com.company.goodigruha.model.Developer;
import com.company.goodigruha.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService{
    private final DeveloperRepository developerRepository;

    public List<Developer> getAll(){
        return developerRepository.getAll();
    }

    public Optional<Developer> getById(Long id){
        return developerRepository.findById(id);
    }

    public Optional<Developer> getByTitle(String title) {
        return Optional.ofNullable(developerRepository.getByTitleIgnoreCase(title));
    }

    public Developer save(Developer developer){
        return developerRepository.save(developer);
    }

    public Developer update(Developer developer){
        return developerRepository.save(developer);
    }

    public void deleteById(Long id){
        developerRepository.deleteById(id);
    }
}
