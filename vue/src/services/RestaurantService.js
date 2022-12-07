import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    find(location) {
        return http.get(`/find/${location}`)
            }
        
    
}