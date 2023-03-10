package com.company.goodigruha.repository;

import com.company.goodigruha.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    @Query("SELECT d FROM Developer d")
    List<Developer> getAll();

    Developer getByTitleIgnoreCase(String title);
}
