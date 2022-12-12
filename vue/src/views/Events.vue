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

    <!---------------- View Event Restaurant ------------------>
    <h3>Events:</h3>
    <div id="event-name-info" v-for="event in events" :key="event.id">
      <h2> {{ event.eventName }}</h2>
    </div>

    <!---------------- Event Restaurant Info ------------------>
    <div id="root">
    <link rel="preconnect" href="https://fonts.googleapis.com" /><link
      rel="preconnect"
      href="https://fonts.gstatic.com"
      crossorigin
    /><link
      href="https://fonts.googleapis.com/css2?family=Playfair+Display"
      rel="stylesheet"
    />

    <div
      id="restaurant-display"
      v-for="business in business"
      :key="business.id"
    >
      <div id="restaurant-left">
        <h2 id="name">{{ business.name }}</h2>

        <img
          v-if="business.image_url != ''"
          :src="business.image_url"
          class="thumbnail"
        />

        <div id="icons">
        

          <div id="yelp-icon-link">
            <a id="url" :href="`${business.url}`" target="_blank">
              <img
                id="yelp-icon"
                src="@/assets/yelp.png"
                alt="yelp-icon"
                class="zoom"
              />
            </a>
          </div>

          <div id="google-icon-link">
            <a
              id="url"
              :href="
                'http://maps.google.com/?q=' +
                `${business.name}` +
                `${business.location.display_address[0]}`
              "
              target="_blank"
            >
              <img
                id="google-icon"
                src="@/assets/google-maps.png"
                alt="google-maps-icon"
                class="zoom"
              />
            </a>
          </div>

        </div>
      </div>

      <div id="restaurant-right">
        <h2 id="stars">Average rating: {{ business.rating }}</h2>
        <h2 id="isClosed">
          {{ business.is_closed === false ? "Open now" : "Closed" }}
        </h2>

        <div id="contact-information">
          <p id="contacts">{{ business.display_phone }}</p>
          <p id="address1">{{ business.location.display_address[0] }}</p>
          <p id="address2">{{ business.location.display_address[1] }}</p>
        </div>

        <div id="pickup-or-delivery">
          <p id="pickup">
            {{
              business.transactions.includes("pickup")
                ? "Pick-up is available"
                : ""
            }}
          </p>
          <p id="delivery">
            {{
              business.transactions.includes("delivery")
                ? "Delivery is available"
                : ""
            }}
          </p>
        </div>

        <div id="phone-button">
          <a href="tel:${business.phone}" target="_blank"
            ><button class="call-button" type="button call">
              <font-awesome-icon icon="phone" /> CALL TO ORDER
            </button></a
          >
        </div>
      </div>
    </div>
   </div>

    <!---------------- View Invitees ------------------>


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