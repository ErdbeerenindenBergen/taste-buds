<template>
  <div class="restaurant-options">
    <h1>
      Please click the thumbs up or thumbs down to approve or reject a
      restaurant.
    </h1>

    <div id="restaurant-options" class="right-panel">
      <invitation-card
        class="card"
        v-for="business in businesses"
        v-bind:key="business.id"
        v-bind:business="business"
      >
      </invitation-card>

      <button type="button" class="submit" id="submit-button" v-on:click="submitVote()">
        SUBMIT
      </button>

    </div>
  </div>
</template>

<script>
import InvitationCard from "../components/InvitationCard.vue";
import InvitationService from "../services/InvitationService.js";
import RestaurantService from "../services/RestaurantService.js";
import VoteService from "../services/VoteService.js";
import EventService from "../services/EventService.js";

export default {
  name: "invite-options",
  components: {
    InvitationCard,
  },
  props: ["business"],
  data() {
    return {
      id: this.$route.params.id, //this is the id from the browser
      invitation: {
        invitationId: this.$route.params.id,
        eventId: 0,
        emailAddress: "",
        hasVoted: Boolean,
      },
      businesses: [],
      vote: {
        yelpRestaurantId: "",
        eventId: 0,
        voteCount: 0
      },
      votes: [],
      event: {
        eventId: 0,
        eventName: "",
        eventCity: "",
        eventState: "",
        zipcode: Number,
        userLatitude: Number,
        userLongitude: Number,
        eventDate: Date,
        eventTime: "",
        eventOrganizerId: Number,
        deadlineDate: Date,
        deadlineTime: ""
      }
    };
  },
  methods: {
    checkIfVoted(){
      InvitationService.getInvitationByInvitationId(this.$route.params.id).then(
        (response) => {
          this.invitation.hasVoted = response.data.hasVoted;
      if (this.invitation.hasVoted === true) {
        this.$router.push({name: 'vote-submitted'});
      }
      })
    },
    checkIfPastDeadline(){
      InvitationService.getInvitationByInvitationId(this.$route.params.id).then((response) => {
      this.vote.eventId = response.data.eventId;  
      EventService.getEventById(this.vote.eventId).then(result =>
      this.event = result.data);
      console.dir(this.event.deadlineDate);
      let rightNow = Date.now();
      console.log("date", rightNow);
      if (this.event.deadlineDate > rightNow && this.event.deadlineTime > Date.now()) {
        this.$router.push({name: 'invitation-expired'}); //need to change to new page
      } 
      })
    },
    submitVote(){
      this.$store.state.approvedRestaurants.forEach(restaurant => {
      InvitationService.getInvitationByInvitationId(this.$route.params.id).then((response) => {
      this.vote.eventId = response.data.eventId;  
      this.vote.yelpRestaurantId = restaurant;
      this.vote.voteCount = 1;
      VoteService.updateVoteCount({...this.vote});
      })
    }),
      this.$store.state.rejectedRestaurants.forEach(restaurant => {
      InvitationService.getInvitationByInvitationId(this.$route.params.id).then((response) => {
      this.vote.eventId = response.data.eventId;
      this.vote.yelpRestaurantId = restaurant;
      this.vote.voteCount = -1;
      VoteService.updateVoteCount({...this.vote});
      })
    }),
      InvitationService.updateHasVoted(this.$route.params.id);
      this.$router.push({name: 'vote-submitted'});
    },
    showRestaurantInfo() {
      InvitationService.getInvitationByInvitationId(this.$route.params.id).then(
        (response) => {
          this.invitation.eventId = response.data.eventId;
          this.invitation.emailAddress = response.data.emailAddress;
          this.invitation.hasVoted = response.data.hasVoted;
          RestaurantService.findBusinessesByEventId(
            this.invitation.eventId
          ).then((response) => {
            response.data.forEach((object) => {
              this.businesses.push(object);
            });
            // }
            // console.dir(this.businesses);
          });
        },
      );
    },
  },
  created() {
    this.showRestaurantInfo();
    this.checkIfVoted(); //not able to test yet
    this.checkIfPastDeadline();
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

button{
  justify-content: center;
  align-content: center;
  margin:auto;
}

.submit {
  background-color: #a64d79ff;
  color: white;
  border: none;
  display: flex;
  font-size: 22px;
  font-family: Helvetica, sans-serif;
  font-weight: bold;
  border-radius: 10px;
  width: 250px;
  padding: 10px;
  margin-top: auto;
  justify-content: center;
  align-content: center;
}

button:hover {
  background: #741b47ff;
}

a.router-link-active {
  font-weight: bold;
}
</style>