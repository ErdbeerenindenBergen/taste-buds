<template>
  <div id="invite-buds">

    <div class="tab-buttons">
    <button  type="button"  id="step-1-create-event" class="button"  v-on:click="showFormStepOne()">Step 1: Info</button>
    <button  type="button"  id="step-2-create-event"  class="button" v-on:click="showFormStepThree()" >Step 2: Tastes</button>
    <button  type="button"  id="step-3-create-event"  class="button" v-on:click="showFormStepThree()" >Step 3: Buds</button>
    </div>
    <!-----------------------Event Form----------------------->

    <form id="event-form" @submit="createEvent()">

      <h1>Enter your event information below:</h1>

      <div class="event-info">
        <h2>Event Name:</h2>
        <input  type="text"  class="event-input"  v-model="event.eventName"  placeholder="your event name" />
        <h2>Event Date:</h2>
        <input  type="date"  class="event-input"  v-model="event.eventDate"  placeholder="mm/dd/yyyy" />
        <h2>Event Time:</h2>
        <input  type="time"  class="event-input"  v-model="event.eventTime"  placeholder="hh:mm" />
      </div>

      <div class="invite-due-date-time">
        <h2>When must your buds respond by?</h2>
        <input  type="date"  class="event-input"  v-model="event.deadlineDate"  placeholder="mm/dd/yyyy" />
        <input  type="time"  class="event-input"  v-model="event.deadlineTime"  placeholder="hh:mm" />
      </div>

      <button  type="button"  id="create-event-button"  v-on:click="createEvent()">SUBMIT</button>
    </form>

    <!-----------------------Invite Form----------------------->

    <form id="invite-form" v-show=false @submit="invite">
      <div class="email">
        <h1>Enter the email address of the bud you want to invite:</h1>
        <input  type="text"  class="date"  v-model="invitation.emailAddress"  placeholder="your bud's email"/>
                <button type="button" id="invite-button" v-on:click="addToInvitees()" >ADD</button>
      </div>

      <div class="send-invite">

      </div>

      <div id="current-list-of-invitees">
        <h2>Below is a list of current invitees to this event:</h2>
          <!-- how to print current invitees in their own rows here? -->
      </div>

    </form>

      <!-------------------Add Restaurants to Event ----------------------->

      <!-- <button  type="button"  id="restaurant-button"  v-on:click="viewRestaurants()" >view restaurants list</button> -->

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
  name: "create-event",
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
        // eventId: '',
        event: {
            eventId: '',
            eventName: "",
            eventDate: "",
            eventTime: "",
            eventOrganizerId: 0,
            deadlineDate: "", //might have to parse LocalDate as string
            deadlineTime: "", //might have to parse LocalTime as string
        },
        invitation: {
            emailAddress: ''
      },
    };
  },
  methods: {
    createEvent() {
         this.eventDate = this.moment(this.eventDate).format('YYYY-MM-DD');
         this.deadlineDate = this.moment(this.deadlineDate).format('YYYY-MM-DD');
        console.log(this.event);
        console.log(this.$store.state.user);
        EventService.createEvent(this.event).then(response => {
            this.event.eventId = response.data.eventId;
            this.$router.push({name: 'restaurants'});
            // return this.event.eventId;
            // this.$router.push({name: 'create-event'});
        })
    },
    showFormStepOne() {
      const stepOneForm = document.getElementById('event-form');
      const stepTwoForm = document.getElementById('invite-form');
        // if (form.style.display === 'none') {
          stepOneForm.style.display = 'block';
          stepTwoForm.style.display = 'none';
        // } else {
        //   form.style.display = 'none';
        // }
    },
    showFormStepThree() {
      const stepOneForm = document.getElementById('event-form');
      const stepTwoForm = document.getElementById('invite-form');
        // if (form.style.display === 'none') {
          stepTwoForm.style.display = 'block';
          stepOneForm.style.display = 'none';
        // } else {
        //   form.style.display = 'none';
        // }
    },
    viewRestaurants() {
       return RestaurantService.findBusinessesByEventId(this.event.eventId).then(response => {
            this.businesses = response.data;
       })
    }
    // mikey note to self: the sendInvite function should create new invite with the data from above. reference the store stuff from lecture.
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
    //  computed: {
    //      getEvent() {
    //          return {
    //             eventName: this.eventName,
    //             eventDate: this.eventDate,
    //             eventTime: this.eventTime,
    //             deadlineDate: this.deadlineDate,
    //             deadlineTime: this.deadlineTime,
    //          }
    //      }
    //  }
  },
  created() {
    this.event.eventOrganizerId = this.$store.state.user.id;
    this.showFormStepOne();
    // const stepOneForm = document.getElementById('event-form');
    // const stepTwoForm = document.getElementById('invite-form');
  }
};

</script>

<style scoped>

h1 {
  font-family: Montserrat;
  color: #666666;
  font-weight: normal;
  text-align: center;
  padding-top: 45px;
}

a.router-link-active{
  font-weight: bold;
}

/* .inviteBud-form {
    width: 30%;
    position: fixed;
    top: 150px;
    padding: 10px;
    display: flex;
    flex-direction: row;
    align-items: center;
    flex-wrap: wrap;
    justify-content: center;
} */

input {
  width: 25%;
  height: 25%;
  align-self: center;
  padding: 10px 15px;
  border: 3px solid lightgray;
  text-align: center;
  justify-content: center;
  border-radius: 10px;
  font-size: 16px;
  display: flex;
  flex-grow: 0;
  margin-top: 15px;
}

h2 {
    text-align: center;
    font-family: Montserrat;
    font-weight: normal;
}

.tab-buttons{
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
}

.button{
  background-color: #f0efef;
  color: #666666;
  border:none;
  text-decoration: none;
  font-size:22px;
  font-weight: normal;
  font-family: Montserrat;
  border-radius: 10px;
  width: 15%;
  padding: 12px 12px;
  margin-top:40px;
  display: flex;
}

#create-event-button{
  background-color: #a64d79ff;
  color: white;
  border:none;
  text-decoration: none;
  font-size:15px;
  font-weight: bold;
  border-radius: 10px;
  width: 15%;
  padding: 12px 12px;
  display: flex;
  justify-content: center;
  margin: auto;
  margin-top: 15px;
}

#event-info-button, #invite-button, #restaurant-button{
  background-color: #a64d79ff;
  color: white;
  border:none;
  text-decoration: none;
  font-size:15px;
  font-weight: bold;
  border-radius: 10px;
  width: 15%;
  height: 45px;
  padding: 12px 12px;
}

placeholder {
  font-family: Montserrat;
  color: #909090;
}

/* #restaurant-button {
    margin-bottom: 10px;
    width: 50%;
} */

input.date{
  justify-content: center;
  display: flex;
  align-content: center;
  margin: auto;
  margin-top: 60px;
}

#invite-button{
  justify-content: center;
  display: flex;
  align-content: center;
  margin: auto;
  margin-top: 20px;
  margin-bottom: 40px;
  width:15%;
}

.event-input {
  display: flex;
  justify-content: center;
  margin: auto;
  font-family: Arial;
  color:#909090;
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
    width: 100%
}
</style>