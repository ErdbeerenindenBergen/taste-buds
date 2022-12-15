import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    getInvitationByInviteId(inviteID) {
        return http.get(`/invite-buds/${inviteID}`) //check with backend to match endpoint
    },

}