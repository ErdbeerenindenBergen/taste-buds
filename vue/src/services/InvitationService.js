import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    createInvitation(invitation) {
        return http.post('/invitation/create', invitation)
    }

}