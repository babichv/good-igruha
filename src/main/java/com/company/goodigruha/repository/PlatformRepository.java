package com.company.goodigruha.repository;

import com.company.goodigruha.entity.Game;
import com.company.goodigruha.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {
    @Query("SELECT p FROM Platform p")
    List<Platform> getAll();
    Platform getByTitleIgnoreCase(String title);
}
