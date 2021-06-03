package com.github.thiagoaataide.citiesapi.countries.resources;

import com.github.thiagoaataide.citiesapi.countries.entities.Country;
import com.github.thiagoaataide.citiesapi.countries.repositories.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResourse {


    private CountryRepository repository;

    public CountryResourse(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Country> countries(Pageable page){
        return repository.findAll(page);
    }

    /**
     * Na representação abaixo está sendo retornado um Optional pois o {id} passado pode não existir no banco de dados
     * porém, não é realizado nenhuma tratamento para isso. E a API irá retornar um erro interno(500). O método
     * será reescrito com o Wrapper(ResponseEntity) para tratar as exceções.
     * */
//    @GetMapping("/{id}")
//    public Country getOne(@PathVariable Long id){
//        Optional<Country> optional = repository.findById(id);
//        return optional.get();
//    }

    /**
     * Aqui será retornando um 404.
     * */
    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable Long id){
        Optional<Country> optional = repository.findById(id);

        if(optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
