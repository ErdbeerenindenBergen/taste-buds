<template>
  <div class="events">
    <div class="tab-buttons">
      <button
        type="button"
        id="view-restaurants"
        class="button"
        v-on:click="showRestaurantList()"
      >
        View Restaurant List
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

    <!---------------- Events Info ------------------>
    <h3>Events:</h3>
    <div id="event-name-info" v-for="event in events" :key="event.id">
      <h2> {{ event.eventName }}</h2>
    </div>
  </div>
</template>

<script>
//import RestaurantService from "../services/RestaurantService.js";
import EventService from "../services/EventService.js";

export default {
  name: "event-details",
  props:  {
    business: Object
    }, 
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
      
      return this.$store.state.approvedRestaurants;//trying to get the approvedRestaurants list from the store
      
      // return this.$store.state.restaurants;
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

h1 {
  font-family: "Playfair Display";
  font-weight: normal;
  text-align: center;
  padding-top: 40px;
}

h2,
h3 {
  text-align: left;
  font-family: Montserrat;
  font-weight: normal;
}

a.router-link-active {
  font-weight: bold;
}

router-link.active {
  font-weight: bold;
}
</style>