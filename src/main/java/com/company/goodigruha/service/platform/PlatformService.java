package com.company.goodigruha.service.platform;

import com.company.goodigruha.model.Platform;

import java.util.List;
import java.util.Optional;

public interface PlatformService {
    List<Platform> getAll();

    Optional<Platform> getById(Long id);

    Optional<Platform> getByTitle(String title);

    Platform save(Platform platform);

    Platform update(Platform platform);

    void deleteById(Long id);
}
