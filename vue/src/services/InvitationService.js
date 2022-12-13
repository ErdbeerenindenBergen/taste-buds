import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    createInvitation(invitation) {
        return http.post('/invitation/create', invitation)
    },

    getInvitationByInvitationId(invitationId) {
        return http.get(`/invitation/${invitationId}`)
    },

    updateHasVoted(invitationId) {
        return http.put(`/invitation/vote-submitted/${invitationId}`)
    }

}