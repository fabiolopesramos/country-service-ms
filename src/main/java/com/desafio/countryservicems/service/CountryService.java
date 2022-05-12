package com.desafio.countryservicems.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.desafio.countryservicems.dto.CountryDTO;
import com.desafio.countryservicems.service.util.CountryUtil;

@Service
public class CountryService {
	public List<CountryDTO> listarTodos() {
        String url = "http://api.worldbank.org/v2/country?format=json";
        
        return CountryUtil.doApiURLToListCountryDTO(url);
    }

    public Optional<CountryDTO> listarPorId(String id) {
        String url = "http://api.worldbank.org/v2/country/{id}?format=json";
        
        url = url.replace("{id}", id);
        return CountryUtil.doApiURLToCountryDTO(url);
    }
}
