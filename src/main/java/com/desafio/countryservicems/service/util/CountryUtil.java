package com.desafio.countryservicems.service.util;

import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.desafio.countryservicems.dto.CountryDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public final class CountryUtil {

    private CountryUtil() {        
    }

    public static List<CountryDTO> doApiURLToListCountryDTO(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        List<CountryDTO> listCountryDTO = new ArrayList<>();

        try {
            JsonNode json = mapper.readTree(restTemplate.getForObject(url, String.class));
            
            listCountryDTO = mapper.readValue(doJsontoStringTrated(json), new TypeReference<List<CountryDTO>>(){});
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCountryDTO;
    }

    public static Optional<CountryDTO> doApiURLToCountryDTO(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        List<CountryDTO> listCountryDTO = new ArrayList<>();
        CountryDTO retornoTratado = new CountryDTO();


        try {
            JsonNode json = mapper.readTree(restTemplate.getForObject(url, String.class));
            listCountryDTO = mapper.readValue(doJsontoStringTrated(json), new TypeReference<List<CountryDTO>>(){});
            
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
        retornoTratado = listCountryDTO.get(0);
        return Optional.ofNullable(retornoTratado);
    }

    private static String doJsontoStringTrated(JsonNode jsons){
        ObjectMapper mapper = new ObjectMapper();
        String noConvertido="";

        for (JsonNode node : jsons) {
            if (noConvertido.isEmpty()){
                try {
                    ((ObjectNode) node).removeAll();
                    noConvertido = mapper.writeValueAsString(node);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }else{
                try {
                    noConvertido = mapper.writeValueAsString(node);    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return noConvertido;
    }
}