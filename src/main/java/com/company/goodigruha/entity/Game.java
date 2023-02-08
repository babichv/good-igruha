package com.company.goodigruha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @ManyToMany
    @JoinTable(name = "games_genres",
            joinColumns = @JoinColumn(name = "games_id"),
            inverseJoinColumns = @JoinColumn(name = "genres_id"))
    private Set<Genre> genres = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "games_developers",
            joinColumns = @JoinColumn(name = "games_id"),
            inverseJoinColumns = @JoinColumn(name = "developers_id"))
    private Set<Developer> developers = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "games_platforms",
            joinColumns = @JoinColumn(name = "games_id"),
            inverseJoinColumns = @JoinColumn(name = "platforms_id"))
    private Set<Platform> platforms = new HashSet<>();
}
