import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    createEvent(event){
        return http.post(`/event/create`, event)
    }
}