package com.dictionary.freeApi.services;

import com.dictionary.freeApi.exceptions.ExternalServiceException;
import com.dictionary.freeApi.exceptions.WordNotFoundException;
import com.dictionary.freeApi.model.DictionaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class DictionaryService {
    private static final String URL_API = "https://api.dictionaryapi.dev/api/v2/entries/en/";
    private final RestTemplate restTemplate;
    @Autowired
    public DictionaryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DictionaryResponse search(String word) {
        try
        {
            String url = URL_API + word;
            DictionaryResponse[] response = restTemplate.getForObject(url, DictionaryResponse[].class);
            if (response != null && response.length > 0) {
                return response[0];
            }
            else{
                throw new WordNotFoundException("Word is not found: "+word);
            }
        } catch(HttpClientErrorException.NotFound e){
                throw new WordNotFoundException("Word is not found: "+word);
        } catch(HttpClientErrorException | HttpServerErrorException e){
                throw new ExternalServiceException("Error occurred while calling the external service",e);
        } catch(Exception e){
            throw new ExternalServiceException("An unexpected error occurred", e);
        }

    }
}
