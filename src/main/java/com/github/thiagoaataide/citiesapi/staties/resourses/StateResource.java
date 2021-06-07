package com.github.thiagoaataide.citiesapi.staties.resourses;

import com.github.thiagoaataide.citiesapi.staties.entities.State;
import com.github.thiagoaataide.citiesapi.staties.repositories.StateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staties")
public class StateResource {

    private final StateRepository repository;

    public StateResource(StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<State> staties(Pageable page){
        return repository.findAll(page);
    }
}
