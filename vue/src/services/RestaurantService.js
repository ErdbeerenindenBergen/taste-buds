import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    find(location) {
        return http.get(`/find/${location}`)
    },

    //not sure this connects to anything in back- or frontend -KB
    collectRestaurantsForInvite(eventRestaurant) {
        return http.post('/restaurants/save', eventRestaurant)
    },

    createEventRestaurantInDatabase(eventRestaurant) {
        return http.post('/event/restaurant/create', eventRestaurant)
    },

    findBusinessesByEventId(eventId) {
        return http.get(`/event/find/${eventId}`)
    }
   
}