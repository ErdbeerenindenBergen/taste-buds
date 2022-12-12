<template>
<div class="confirmation">
    <h1>Your event has been submitted!</h1>

    <h2>Here are the invitation links for your invitees:</h2>

  <div id=invitee-info>

    <div id='left-side'>
      <p v-bind:uniqueLink="invitee" v-for='invitation in $store.state.invitees' :key="invitation.invitationId">{{invitation.emailAddress}}</p>
    </div>
    
    <div id='right-side'>
      <p id="invitee-links" v-bind:uniqueLink="uniqueLink" v-for='uniqueLink in $store.state.inviteeLinks' :key="uniqueLink">{{uniqueLink}}</p>
    </div>

  </div>

  </div>
</template>

<script>
// import InviteBuds from "../views/InviteBuds.vue";

export default {
  name: "confirmation",
  props:[ 
      "invitee"],
  components: {
    //   InviteBuds
  }
};
</script>

<style scoped>
h1{
  font-family: 'Playfair Display';
  font-weight: normal;
  text-align: center;
  padding-top: 40px;
}

a.router-link-active{
  font-weight: bold;
}

h2{
    text-align: center;
    font-family: Montserrat;
    font-weight: normal;
    padding-top: 20px;
}

#invitee-info{
  display:flex;
  justify-content: center;
}

#left-side{
  text-align: right;
  padding-right:40px;
}

p {
  font-family: Montserrat;
  font-size:25px;
}


</style>