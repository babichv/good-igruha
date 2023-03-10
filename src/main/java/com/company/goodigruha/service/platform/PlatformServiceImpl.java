package com.company.goodigruha.service.platform;

import com.company.goodigruha.model.Platform;
import com.company.goodigruha.repository.PlatformRepository;
import com.company.goodigruha.service.platform.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlatformServiceImpl implements PlatformService {
    private final PlatformRepository platformRepository;

    public List<Platform> getAll(){
        return platformRepository.getAll();
    }

    public Optional<Platform> getById(Long id){
        return platformRepository.findById(id);
    }

    public Optional<Platform> getByTitle(String title){
        return Optional.ofNullable(platformRepository.getByTitleIgnoreCase(title));
    }

    public Platform save(Platform platform){
        return platformRepository.save(platform);
    }

    public Platform update(Platform platform){
        return platformRepository.save(platform);
    }

    public void deleteById(Long id){
        platformRepository.deleteById(id);
    }
}
