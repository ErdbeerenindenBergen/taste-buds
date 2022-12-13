import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    updateVoteCount(vote) {
        return http.put(`/vote`, vote)
    }
}