package com.tastebuds.services;

import com.tastebuds.model.Business;
import com.tastebuds.model.Businesses;
import com.tastebuds.model.EventRestaurant;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class YelpBusinessService implements IYelpBusinessService {

    private static final String API_BASE_URL = "https://api.yelp.com/v3/";
    private static final String API_KEY = "hto3PV1EXx4TD_iY6As5CyQaC60ijHyngfYUU-m681CcCjY6rpnHFxkDu5yNcLfzuLpTXotEhZFpEC-LW6xHZBqisku5OxCpq_VSDC2uA3BGej0nanDtkQQH3OOMY3Yx";
    private RestTemplate restTemplate = new RestTemplate();

    //receives list of restaurants from YelpFusionAPI based on location entered
    public List<Business> getBusinesses(String location) throws RestClientException {
        ResponseEntity<Businesses> response = restTemplate.exchange(API_BASE_URL + "businesses/search?location=" + location, HttpMethod.GET, makeAuthEntity(), Businesses.class);
        Businesses businesses = response.getBody();
        List<Business> returnArray = new ArrayList<>();
        for (Business business : businesses.getBusinesses()) {
            String id = business.getId();
            business = getBusinessById(id);
            returnArray.add(business);
        }
        return returnArray;
    }

    //retrieves individual restaurant info from YelpFusionAPI
    public Business getBusinessById(String id) throws RestClientException {
        Business business = null;
        business = restTemplate.exchange(API_BASE_URL + "/businesses/" + id, HttpMethod.GET, makeAuthEntity(), Business.class).getBody();
        return business;
    }

    //receives list of voted-on restaurants from front-end
    //retrieves restaurant info from YelpFusionAPI, sets vote count for each restaurant
    public List<Business> getBusinessesByYelpRestaurantId(List<EventRestaurant> eventRestaurants) throws RestClientException {
        List<Business> returnedBusinesses = new ArrayList<>();
        Business business = null;
        for (EventRestaurant eventRestaurant : eventRestaurants) {
            business = restTemplate.exchange(API_BASE_URL + "/businesses/" + eventRestaurant.getYelpRestaurantId(), HttpMethod.GET, makeAuthEntity(), Business.class).getBody();
            business.setNumVotes(eventRestaurant.getVoteCount());
            returnedBusinesses.add(business);
        }
        return returnedBusinesses;
    }

    //SECURITY METHOD BELOW - do not alter
    public HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(API_KEY);
        return new HttpEntity<>(headers);
    }

}
