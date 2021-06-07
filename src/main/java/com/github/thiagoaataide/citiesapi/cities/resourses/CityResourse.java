package com.github.thiagoaataide.citiesapi.cities.resourses;

import com.github.thiagoaataide.citiesapi.cities.entities.City;
import com.github.thiagoaataide.citiesapi.cities.repositories.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityResourse {

    private final CityRepository repository;

    public CityResourse(CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<City> cities(final Pageable page){
        return repository.findAll(page);
    }
}
