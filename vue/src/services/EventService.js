import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    createEvent(event){
        return http.post(`/event/create`, event)
    },

    createInvitation(invitation){
        return http.post(`/invitation/create`, invitation)
    },

    getEventById(eventId){
        return http.get(`/${eventId}`)
    },

    getEventByName(eventName){
        return http.get('/eventName', eventName)
    },

    getAllEvents(){
        return http.get('event') //does this have an endpoint? - nice catch! yes, it does! I fixed it.
    }
}