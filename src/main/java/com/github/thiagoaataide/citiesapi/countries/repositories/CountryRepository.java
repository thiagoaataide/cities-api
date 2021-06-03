package com.github.thiagoaataide.citiesapi.countries.repositories;

import com.github.thiagoaataide.citiesapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
