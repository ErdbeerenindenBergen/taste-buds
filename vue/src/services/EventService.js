import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    createEvent(userId, event){
        return http.post(`/create/${userId}`, event)
    }
}