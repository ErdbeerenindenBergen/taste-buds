<template>
  <div class="confirmation">
    <h1>Your event has been submitted!</h1>

    <h2>Here are the invitation links for your invitees:</h2>

    <div id="invitee-info" v-bind:invitee="invitee"  v-for="invitation in $store.state.invitees"  :key="invitation.invitationId">

      <div id="left-side">
        <p >{{ invitation.emailAddress }}</p>
      </div>

      <!-- <div id="right-side">
        <p  id="invitee-links"  
      >
        http://localhost:9000/invite-options/{{invitation.invitationId}}
        </p>
      </div> -->

      <button
        type="button"
        id="follow link"
        class="button"
        v-on:click="pushToInviteOptions(invitation.invitationId)"
      >
        http://localhost:9000/invite-options/{{invitation.invitationId}}
      </button>

      <!-- <div id="right-side">
        <a  id="invitee-links"  
        :href="'http://localhost:9000/invite-options/' + `${invitation.invitationId}`" @click="pushToInviteOptions()">
        http://localhost:9000/invite-options/{{invitation.invitationId}}
        </a>
      </div> -->

    </div>
  </div>
</template>

<script>

export default {
  name: "confirmation",
  props: ["invitee"],
  components: {
  },
  methods: {
    pushToInviteOptions(invitationId) {
       this.$router.push('/invite-options/'+ invitationId)
    },
  }
};
</script>

<style scoped>
h1 {
  font-family: "Playfair Display";
  font-weight: normal;
  text-align: center;
  padding-top: 40px;
}

button{
  background:none;
  border:none;
  font-family: Montserrat;
  font-weight: normal;
  font-size: 25px;
  color:#666666;
}

button:hover{
  color: #a64d79ff;
  border: none;
  text-decoration: none;
  font-weight: bold;
  border-radius: 10px;
  padding: 12px 12px;
}

a.router-link-active {
  font-weight: bold;
}

h2 {
  text-align: center;
  font-family: Montserrat;
  font-weight: normal;
  padding-top: 20px;
}

#invitee-info {
  display: flex;
  justify-content: center;
}

#left-side {
  text-align: right;
  padding-right: 40px;
}

#right-side {
  padding-right: 40px;
}

p {
  font-family: Montserrat;
  font-size: 25px;
}

a {
  font-family: Montserrat;
  font-size: 25px;
  padding-top: 25px;
}
</style>