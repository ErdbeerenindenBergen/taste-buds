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

export default {
  name: "restaurant-options",
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
      votes: []
    };
  },
  methods: {
      greenIfRestaurantApproved(id) {
          this.thumbsDownIcon = document.getElementsByClassName('thumbs-down-icon');
          this.thumbsUpIcon = document.getElementsByClassName('thumbs-up-icon');
           if (this.$store.state.approvedRestaurants.includes(id)) {
            this.thumbsUpIcon.style.color = "rgb(3, 173, 3)";
            this.thumbsDownIcon.style.color = "#a64d79ff";
          } 
        },
      redIfRestaurantRejected(id){
          let thumbsDownIcon = document.getElementsByClassName('thumbs-down-icon');
          let thumbsUpIcon = document.getElementsByClassName('thumbs-up-icon');
           if (this.$store.state.rejectedRestaurants.includes(id)) {
            thumbsDownIcon.style.color = "red";
            thumbsUpIcon.style.color = "#a64d79ff";
           }
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
      this.$router.push({name: 'voteSubmitted'});
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
            console.dir(this.businesses);
          });
        }
      );
    },
  },
  created() {
    this.showRestaurantInfo();
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