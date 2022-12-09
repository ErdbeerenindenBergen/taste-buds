<template>
  <div id="invite-buds">

    <!-----------------------Create-Event Form----------------------->

    <form class="event-form" @submit="createEvent()">
      <div class="event-info">
        <h2>Event Name:</h2>
        <input  type="text"  class="event-name"  v-model="event.eventName"  placeholder="Capstone Celebration" />
        <h2>Event Date:</h2>
        <input  type="text"  class="event-name"  v-model="event.eventDate"  placeholder="Capstone Celebration" />
        <h2>Event Time:</h2>
        <input  type="text"  class="event-name"  v-model="event.eventTime"  placeholder="Capstone Celebration" />
      </div>

      <div class="invite-due-date-time">
        <h2>When must your buds respond by?</h2>
        <input  type="text"  class="date"  v-model="event.responseDeadlineDate"  placeholder="mm/dd/yyyy" />
        <input  type="text"  class="time"  v-model="event.responseDeadlineTime"  placeholder="hh:mm" />
      </div>

    <!-----------------------Create-Event Button ----------------------->

      <button  type="button"  id="create-event-button"  v-on:click="createEvent()">SUBMIT</button>
    </form>

    <!-----------------------Create-Invite Form----------------------->

    <!-----------------------Enter Email Field ----------------------->

    <form class="invite-form" @submit="invite">
      <div class="email">
        <h2>Enter the email address of the bud you want to invite:</h2>
        <input  type="text"  class="date"  v-model="email"  placeholder="your bud's email"/>
      </div>

      <!-------------------Send Invite Button Button --------------------->

      <div class="send-invite">
        <button type="button" id="invite-button" v-on:click="sendInvite()" >send an invite!</button>
      </div>

      <!-------------------View all Restaurants Button ----------------------->

      <button  type="button"  id="restaurant-button"  v-on:click="viewRestaurants()" >view restaurants list</button>
    </form>

    <!-- this here is the imported RestaurantCard.vue template from components -->

    <div id="find-restaurants-results" class="right-panel">
      <restaurant-card  class="card"  v-for="business in Businesses"  v-bind:key="business.id"  v-bind:business="business"></restaurant-card>
    </div>

  </div>
</template>



<script>

// import InviteService from "../services/InviteService";
import RestaurantCard from "../components/RestaurantCard.vue";
import RestaurantService from "../services/RestaurantService.js";
import EventService from "../services/EventService.js";


export default {
  components: {
    RestaurantCard,
  },
  props: {
    business : Object
  },
  data() {
    return {
      businesses: [], //this is for 'view restaurants list' button, OR this is what will hold the results of the queries? same thing?
      event: {
        eventId: "",
        eventName: "",
        eventDate: "",
        eventTime: "",
        eventOrganizerId: "",
        deadlineDate: "", //might have to parse LocalDate as string
        deadlineTime: "", //might have to parse LocalTime as string
      }
    };
  },
  methods: {
    createEvent() {
        EventService.createEvent(this.user.userId, this.event).then(response => {
             this.event.eventId = response.data;
        })
    },
    viewRestaurants() {
       return RestaurantService.findBusinessesByEventId(this.event.eventId).then(response => {
           this.businesses = response.data;
       })
    }
    //mikey note to self: the sendInvite function should create new invite with the data from above. reference the store stuff from lecture.
//     sendInvite() {
//       const invitationObject = {
//         eventName: "",
//         inviteId: "",
//         decisionDate: "",
//         decisionTime: "",
//         uniqueInvitationLink: "",
//       };

//       InviteService.createInvitation(invitationObject).then((response) => {
//         this.invitation.inviteId = response.data;
//         this.$store.commit("SET_PENDING_INVITE", response.data);
//       });
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