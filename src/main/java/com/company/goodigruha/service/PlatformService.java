package com.company.goodigruha.service;

import com.company.goodigruha.entity.Platform;
import com.company.goodigruha.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlatformService {
    @Autowired
    private final PlatformRepository platformRepository;

    public PlatformService(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    public List<Platform> findAll(){
        return platformRepository.getAll();
    }

    public Optional<Platform> findById(Long id){
        return platformRepository.findById(id);
    }

    public Optional<Platform> findByTitle(String title){
        return Optional.ofNullable(platformRepository.getByTitleIgnoreCase(title));
    }

    public Platform save(Platform platform){
        return platformRepository.save(platform);
    }

    public Platform update(Platform platform){
        return platformRepository.save(platform);
    }
    public void delete(Long id){
        platformRepository.deleteById(id);
    }
}
