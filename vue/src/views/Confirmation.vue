<template>
<div class="about">
    <h1>Your event has been submitted!</h1>
  </div>
</template>

<script>
// import InviteBuds from "../views/InviteBuds.vue";

export default {
  name: "about",
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
</style>