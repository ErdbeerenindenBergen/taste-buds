<template>
  <div class="restaurant-options">
    <h1>This is where restaurant options will be.</h1>
    <div id="restaurant-options" class="right-panel">
      <invitation-card  class="card"         
        v-for="business in businesses"
        v-bind:key="business.id"
        v-bind:business="business"></invitation-card>

          <!-- HOW TO CREATE VOTES -->

          <!-- Have a getter to grab restaurants and display above -->
                    <!-- Send inviteId to get eventId -->
                    <!-- use eventId to get all restaurants and return yelp results -->
                    <!-- restaurants will display -->

          <!-- create two lists of restaurants, a rejected list and an approved list? -->
                    <!-- need to think through this logic with someone -->


          <!-- when voter clicks thumbs up or thumbs down, the restaurant will be added to the appropriate list -->

    </div>
  </div>
</template>

<script>
import InvitationCard from "../components/InvitationCard.vue";
import InvitationService from "../services/InvitationService.js";
import RestaurantService from "../services/RestaurantService.js";

export default {
  name: "restaurant-options",
  components: {
    InvitationCard,
  },
  props: ["business"],
  data() {
    return{
    id: this.$route.params.id, //this is the id from the browser
    invitation: {
      invitationId: this.$route.params.id,
      eventId: 0,
      emailAddress: "",
      hasVoted: Boolean
      },
    businesses: [],
    }
  },
  methods: {
    showRestaurantInfo() {
      InvitationService.getInvitationByInvitationId(this.$route.params.id).then((response) => {
            this.invitation.eventId = response.data.eventId;
            this.invitation.emailAddress = response.data.emailAddress;
            this.invitation.hasVoted = response.data.hasVoted;
        RestaurantService.findBusinessesByEventId(this.invitation.eventId).then((response) => {
            // if (response.data.location.display_address != '') {
            // this.businesses = response.data;
            response.data.forEach((object) => {
              this.businesses.push(object);
            })
            // }
            console.dir(this.businesses);
        });
      })
    }

  },
  created() {
    this.showRestaurantInfo();
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

a.router-link-active {
  font-weight: bold;
}
</style>