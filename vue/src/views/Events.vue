<template>
  <div class="events">
    <div class="tab-buttons">
      <button
        type="button"
        id="view-restaurants"
        class="button"
        v-on:click="showRestaurantList()"
      >
        View Event Restaurant 
      </button>
      <button
        type="button"
        id="view-invitees"
        class="button"
        v-on:click="showViewInvitees()"
      >
        View Invitees
      </button>
    </div>

    <!---------------- Event Name ------------------>
  <div class="eventSide">
    <h3>Events:</h3>
    <div id="event-name-info" v-for="event in events" :key="event.id">
      <h2> {{ event.eventName }}</h2> 
    </div>
  </div>

                 
    <!---------------- View Event Restaurant ------------------>
    <event-restaurant-card
        class="card"
        v-for="business in businesses" 
        v-bind:key="business.id"
        v-bind:business="business"
    >
    </event-restaurant-card>


      <!---------------- View Event Invitees ------------------>
   <event-invitee 
        id="invitee-info" 
        v-bind:invitee="invitee"  
        v-for="invitation in $store.state.invitees"  
        :key="invitation.invitationId"
    >
    </event-invitee>



  </div>
</template>

<script>

import EventService from "../services/EventService.js";
import EventRestaurantCard from "../components/EventRestaurantCard.vue"
import EventInvitee from "../components/EventInvitee.vue"

export default {
  name: "event-details",
  components: {
    EventRestaurantCard,
    EventInvitee
  },
  props:  ["business",
  ], 
  data() {
    return {
      events: [],
      invitees: [],
    };
  },
  created() {
    EventService.getAllEvents().then((response) => {
      this.events = response.data;
      console.log(this.events);
    });
  },
  methods: {
    showRestaurantList() {
      const stepOneForm = document.getElementById('view-restaurants');
      const stepTwoForm = document.getElementById('view-invitees');
          stepOneForm.style.display = 'block';
          stepTwoForm.style.display = 'none';

      return EventService.getRestaurantRankedListByEventId(this.event.eventId).then(
        (response) => {
          this.businesses = response.data;
        }
      );    
      
    },
    showViewInvitees() {
      const stepOneForm = document.getElementById('view-restaurants');
      const stepTwoForm = document.getElementById('view-invitees');
          stepOneForm.style.display = 'none';
          stepTwoForm.style.display = 'block';
    
    
    },
    
  } 
}
</script>

<style scoped>
.tab-buttons {
  display: flex;
  flex-direction: row;
  justify-content: flex-end; 
}

.button {
  background-color: #a64d79ff;
  color: white;
  border: none;
  text-decoration: none;
  font-size: 22px;
  font-weight: normal;
  font-family: Montserrat;
  border-radius: 10px;
  width: 15%;
  padding: 12px 12px;
  margin-top: 40px;
  margin-right: 60px;
  margin-left: 50px;
  display: flex;
}

.eventSide {
  display: flex;
  flex-direction: column;
  align-items: left;
  margin-left: 15%;
  
}

h2,
h3 {
  display: flex;
  font-family: Montserrat;
  font-weight: normal;
  color: #666666;

}


a.router-link-active {
  font-weight: bold;
}

router-link.active {
  font-weight: bold;
}
</style>