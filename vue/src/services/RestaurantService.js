import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    search(location) {
        return http.get(`/find/`, {
            headers: {
                'location': location
            }
        })
    }
}