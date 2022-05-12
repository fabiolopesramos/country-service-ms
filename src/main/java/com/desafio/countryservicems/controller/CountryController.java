package com.desafio.countryservicems.controller;


import java.util.List;
import java.util.Optional;

import com.desafio.countryservicems.dto.CountryDTO;
import com.desafio.countryservicems.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/country", method = RequestMethod.GET)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryDTO>> listarTodos() {
        List<CountryDTO> listCountry = null;

        try {
            listCountry = countryService.listarTodos();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<List<CountryDTO>>(listCountry, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<CountryDTO>> listarPorId(@PathVariable String id){
        Optional<CountryDTO> country = Optional.empty();

        try {
            country = countryService.listarPorId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Optional<CountryDTO>>(country, HttpStatus.OK);
    }
}
