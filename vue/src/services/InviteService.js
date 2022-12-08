import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    getInvitationByInviteId(inviteID) {
        return http.get(`/invite/${inviteID}`) //check with backend to match endpoint
    },

    createInvitation(invitation) {
        return http.get(`/invite/create`, invitation) //check with backend to match endpoint
    }

        
    
}