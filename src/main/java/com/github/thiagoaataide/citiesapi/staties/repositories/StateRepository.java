package com.github.thiagoaataide.citiesapi.staties.repositories;

import com.github.thiagoaataide.citiesapi.staties.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}