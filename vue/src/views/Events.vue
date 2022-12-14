<template>
  <div class="events">
    <!-- <div class="tab-buttons">
      <button
        type="button"
        id="view-restaurants"
        class="button"
        v-on:click="showRestaurantList()"
      >
        View Restaurant Ranking 
      </button>
      <button
        type="button"
        id="view-invitees"
        class="button"
        v-on:click="showViewInvitees()"
      >
        View Invitees
      </button>
    </div> -->

    <!---------------- Event Name ------------------>
  <div class="event-side">

    <h3>Events:</h3>

    <div id="event-name-info" v-for="event in events" :key="event.id">
      <button
        type="button" 
        class="event-name-button"
        @click="displayRestaurantRanking(`${event.eventId}`)"
      >
      {{ event.eventName }}
      </button> 
    </div>
  </div>
                 
    <!---------------- View Event Restaurant ------------------>

    <div class="restaurant-side">

      <h3>Finalists in order of most liked to least:</h3>

      <event-restaurant-card
          class="card"
          v-for="business in businesses" 
          v-bind:key="business.id"
          v-bind:business="business"
      >
      </event-restaurant-card>
    </div>


      <!---------------- View Event Invitees ------------------>
   <!-- <event-invitee 
        id="invitee-info" 
        v-bind:invitee="invitee"  
        v-for="invitation in $store.state.invitees"  
        :key="invitation.invitationId"
    >
    </event-invitee> -->



  </div>
</template>

<script>

import EventService from "../services/EventService.js";
import EventRestaurantCard from "../components/EventRestaurantCard.vue"
// import EventInvitee from "../components/EventInvitee.vue"

export default {
  name: "event-details",
  components: {
    EventRestaurantCard,
    // EventInvitee
  },
  props:  ["business"
  ], 
  data() {
    return {
      events: [],
      invitees: [],
      eventId: Number,
      businesses: [],
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
  created() {
    EventService.getAllEvents().then((response) => {
      this.events = response.data;
      // console.log(this.events);
    });
  },
  methods: {
    // showRestaurantList() {
    //    const stepOneForm = document.getElementById('view-restaurants');
    //    const stepTwoForm = document.getElementById('view-invitees');
    //        stepOneForm.style.display = 'block';
    //        stepTwoForm.style.display = 'none';
    displayRestaurantRanking(eventId) {
      console.log(eventId);
      this.eventId = this.event.eventId;
      return EventService.getRestaurantRankedListByEventId(eventId).then(
        (response) => {
          this.businesses = response.data;
          console.dir(this.businesses);
        }
      );    
    // }
    },
    // showViewInvitees() {
    //   const stepOneForm = document.getElementById('view-restaurants');
    //   const stepTwoForm = document.getElementById('view-invitees');
    //       stepOneForm.style.display = 'none';
    //       stepTwoForm.style.display = 'block';
    // },
      goldIfFirstPlace() {
        let trophy = document.getElementById("trophy-icon");
        if (this.business.indexOf(this.business) == 0) {
          trophy.style.display = "block";
          trophy.style.height= "40px";
          trophy.style.margin="10px";
          trophy.style.color = "gold";
          return true;
        } else {
          trophy.style.display = 'none';
          return false;
        }
      }
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
  display: flex;
}

.event-name-button {
  background-color: white;
  color: #a64d79ff;
  border: none;
  font-size: 30px;
  font-weight: bold;
  font-family: "Playfair Display";
  border-radius: 10px;
  width: 75%;
  justify-content: center;
  padding: 24px 12px;
  margin:auto;
  margin-top: 10px;
  display: flex;
  /* box-shadow: 5px 10px #888888; */
}

.event-name-button:hover {
  transform: scale(1.2);
}

.events{
  display: flex;
}

.event-name-button:focus {
  background-color: #ead1dcff;
}

.event-side {
  display: flex;
  flex-direction: column;
  align-items: left;
  margin-left: 20px;
  margin-right: 20px;
  width: 40%;
}

.restaurant-side{
  /* margin-top:75px; */
  width: 100%;
  margin-right:20px;
}

h2,
h3 {
  display: flex;
  font-weight: normal;
  color: #666666;
  text-align: center;
  overflow:wrap;
}

h3{
  justify-content: center;
  padding-top: 60px;
  font-family: "Playfair Display";
  font-weight: bold;
  font-size: 40px;
  text-align:wrap;
}

a.router-link-active {
  font-weight: bold;
}

router-link.active {
  font-weight: bold;
}

@media screen and (max-width: 800px) and (min-width: 200px) {
  .events {
    display: flex;
  }

  .event-side {
    width: 100%;
    padding-bottom: 20px;
  }
  .restaurant-side {
    width: 100%;
    justify-content: center;
    text-align: center;
  }

  p {
    font-size: 21px;
  }

  label {
    font-size: 20px;
  }

  #cheers{
  height: 200px;
}
}

@media screen and (max-width: 1200px) {
  .events {
    padding-top: 15px;
    display: flex;
    flex-direction: column;
  }

  .event-side {
    width: 30%;
    /* position: fixed; */
    top: 175px;
    margin-top: 50px;
  }

  .restaurant-side {
    width: 100%;
    justify-content: center;
    text-align: center;
    padding-left: 0;
    padding-top: 75px;
  }

  #cheers{
  height: 200px;
  }

}


</style>