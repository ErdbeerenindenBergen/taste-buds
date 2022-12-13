<template>
  <div class="restaurant-options">
    <h1>This is where restaurant options will be.</h1>
    <div id="restaurant-options" class="right-panel">
      <invitation-card  class="card"  v-for="business in businesses"  v-bind:key="business.id"  v-bind:business="business"></invitation-card>

          <!-- HOW TO CREATE VOTES -->

          <!-- Have a getter to grab restaurants and display above -->

          <!-- create two lists of restaurants, a rejected list and an approved list -->

          <!-- when voter clicks thumbs up or thumbs down, the restaurant will be added to the appropriate list -->


    </div>
  </div>
</template>

<script>
import InvitationCard from "../components/InvitationCard.vue";

export default {
  name: "restaurant-options",
  components: {
    InvitationCard,
  },
  data() {
    return{
    id: this.$route.params.id //this is the id from the browser
    }
  },
};
</script>

<style scoped>
h1 {
  font-family: "Playfair Display";
  font-weight: normal;
  text-align: center;
  padding-top: 40px;
}

a.router-link-active {
  font-weight: bold;
}
</style>