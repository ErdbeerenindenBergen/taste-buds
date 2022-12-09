import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    find(location) {
        return http.get(`/find/${location}`)
    },

    //not sure this connects to anything in back- or frontend -KB
    collectRestaurantsForInvite(restaurant) {
        return http.post('/restaurants/save', restaurant)
    },

    createEventRestaurantInDatabase(restaurantId,eventId) {
        return http.post(`/event/${eventId}/restaurant/${restaurantId}`)
    },

    findBusinessesByEventId(eventId) {
        return http.get(`/event/find/${eventId}`)
    }
   
}