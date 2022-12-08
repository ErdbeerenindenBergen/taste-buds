package com.techelevator.services;

import com.techelevator.model.Businesses;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class YelpRestaurantService implements IYelpRestaurantService{

    private static final String API_BASE_URL = "https://api.yelp.com/v3/";
    private static final String API_KEY = "hto3PV1EXx4TD_iY6As5CyQaC60ijHyngfYUU-m681CcCjY6rpnHFxkDu5yNcLfzuLpTXotEhZFpEC-LW6xHZBqisku5OxCpq_VSDC2uA3BGej0nanDtkQQH3OOMY3Yx";
    private RestTemplate restTemplate = new RestTemplate();
    private final int TOTAL_BUSINESSES_LIMIT = 40;

    public Businesses getBusinesses(String location) throws RestClientException {
        HttpHeaders header = new HttpHeaders();
        header.setBearerAuth(API_KEY);
        HttpEntity<Void> entity = new HttpEntity<>(header);

        ResponseEntity<Businesses> response = restTemplate.exchange(API_BASE_URL + "businesses/search?location=" + location, HttpMethod.GET, entity, Businesses.class);
        Businesses businesses = response.getBody();
        return businesses;
    }

    //TODO add method to search for specific restaurant via API call

}
