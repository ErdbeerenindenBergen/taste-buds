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

      <div>
        <h2>Your email address:</h2>
            <input  type="text"  class="event-name"  v-model="userId"  placeholder="Capstone Celebration" />
      </div>

    <!-----------------------Create-Event Button ----------------------->

      <button  type="button"  id="create-event-button"  v-on:click="createEvent()">SUBMIT</button>
    </form>

    <!-----------------------Create-Invite Form----------------------->

    <!-----------------------Enter Email Field ----------------------->

    <!-- <form class="invite-form" @submit="invite"> -->
      <div class="email">
        <h2>Enter the email address of the bud you want to invite:</h2>
        <input  type="text"  class="date"  v-model="invitation.emailAddress"  placeholder="your bud's email"/>
      </div>

      <!-------------------Send Invite Button Button --------------------->

      <!-- <div class="send-invite">
        <button type="button" id="invite-button" v-on:click="sendInvite()" >send an invite!</button>
      </div> -->

      <!-------------------View all Restaurants Button ----------------------->

      <button  type="button"  id="restaurant-button"  v-on:click="viewRestaurants()" >view restaurants list</button>
    <!-- </form> -->

    <!-- this here is the imported RestaurantCard.vue template from components -->

    <div id="find-restaurants-results" class="right-panel">
      <restaurant-card  class="card"  v-for="business in businesses"  v-bind:key="business.id"  v-bind:business="business"></restaurant-card>
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
    RestaurantCard
  },
    props:[ 
      "business"
      ],
  data() {
    return {
        businesses: [], //this is for 'view restaurants list' button, OR this is what will hold the results of the queries? same thing?
        userId: '',
        event: {
            // eventId: '',
            eventName: '',
            eventDate: '',
            eventTime: '',
            eventOrganizerId: '',
            deadlineDate: '', //might have to parse LocalDate as string
            deadlineTime: '', //might have to parse LocalTime as string
        },
        invitation: {
            emailAddress: ''
      },
    };
  },
  methods: {
    createEvent() {
        // let userId = this.event.eventOrganizerId = $http.get('api/user').then(response => {
        //     console.log(response.body)
        // })

        EventService.createEvent(this.userId, this.event).then(response => {
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
     computed: {
         getEvent() {
             return {
                eventId: this.eventId,
                eventName: this.eventName,
                eventDate: this.eventDate,
                eventTime: this.eventTime,
                deadlineDate: this.deadlineDate,
                deadlineTime: this.deadlineTime,
             }
         }
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

a.router-link-active{
  font-weight: bold;
}

.inviteBud-form {
    width: 30%;
    position: fixed;
    top: 150px;
    padding: 10px;
    display: flex;
    flex-direction: row;
    align-items: center;
    flex-wrap: wrap;
    justify-content: center;
}

input {
  width: 25%;
  height: 25%;
  align-self: center;
  padding: 10px 15px;
  border: 3px solid lightgray;
  text-align: center;
  border-radius: 10px;
  font-size: 16px;
  display: inline-flex;
  flex-grow: 0;
  margin-top: 15px;
}

h2 {
    text-align: left;
}

#event-info-button, #invite-button, #restaurant-button{
  background-color: #a64d79ff;
  color: white;
  text-decoration: none;
  font-size:15px;
  font-weight: bold;
  border-radius: 10px;
  width: 100px;
  height: 45px;
  padding: 12px 12px;
}

#invite-button {
    align-self: center;
    width: 30%;
    margin: 10px
}

#restaurant-button {
    margin-bottom: 10px;
    width: 50%;
}

#event-info-button {
    width: 30%;
    margin: 10px;
}

#event-info-button:focus, #invite-button:focus, #restaurant-button:focus{
  background: #E06666;
}

#event-info-button:hover, #invite-button:hover, #restaurant-button:hover{
  background:#741b47ff;
}

div.event-info, div.date-time, div.email, div.send-invite {
    justify-content: space-between;
    margin: 10px;
    flex-wrap: wrap;
    padding-bottom: 10px;
    display: inline-block;
    width: 100%
}
</style>