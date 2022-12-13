<template>
  <body class="container">
    <div id="find" class="left-panel">
      <form class="find-form" @submit="find()">
        <br />
        <p>Enter a city or zipcode</p>
        <br />
        <input
          id="city-or-zip"
          type="text"
          class="location"
          v-model="location"
          @keydown.enter.exact.prevent="find()"
          placeholder="City or Zipcode"
        />
        <br />
        <br />
        <label for="state">If you'd like, you can specify a state.</label>
        <br />
        <select id="state" name="state" v-model="state" size="5">
          <option value=",AL">Alabama</option>
          <option value=",AK">Alaska</option>
          <option value=",AZ">Arizona</option>
          <option value=",AR">Arkansas</option>
          <option value=",CA">California</option>
          <option value=",CO">Colorado</option>
          <option value=",CT">Connecticut</option>
          <option value=",DE">Delaware</option>
          <option value=",DC">District Of Columbia</option>
          <option value=",FL">Florida</option>
          <option value=",GA">Georgia</option>
          <option value=",HI">Hawaii</option>
          <option value=",ID">Idaho</option>
          <option value=",IL">Illinois</option>
          <option value=",IN">Indiana</option>
          <option value=",IA">Iowa</option>
          <option value=",KS">Kansas</option>
          <option value=",KY">Kentucky</option>
          <option value=",LA">Louisiana</option>
          <option value=",ME">Maine</option>
          <option value=",MD">Maryland</option>
          <option value=",MA">Massachusetts</option>
          <option value=",MI">Michigan</option>
          <option value=",MN">Minnesota</option>
          <option value=",MS">Mississippi</option>
          <option value=",MO">Missouri</option>
          <option value=",MT">Montana</option>
          <option value=",NE">Nebraska</option>
          <option value=",NV">Nevada</option>
          <option value=",NH">New Hampshire</option>
          <option value=",NJ">New Jersey</option>
          <option value=",NM">New Mexico</option>
          <option value=",NY">New York</option>
          <option value=",NC">North Carolina</option>
          <option value=",ND">North Dakota</option>
          <option value=",OH">Ohio</option>
          <option value=",OK">Oklahoma</option>
          <option value=",OR">Oregon</option>
          <option value=",PA">Pennsylvania</option>
          <option value=",RI">Rhode Island</option>
          <option value=",SC">South Carolina</option>
          <option value=",SD">South Dakota</option>
          <option value=",TN">Tennessee</option>
          <option value=",TX">Texas</option>
          <option value=",UT">Utah</option>
          <option value=",VT">Vermont</option>
          <option value=",VA">Virginia</option>
          <option value=",WA">Washington</option>
          <option value=",WV">West Virginia</option>
          <option value=",WI">Wisconsin</option>
          <option value=",WY">Wyoming</option>
        </select>
        <br />
        <button type="button" id="submit-button" v-on:click="find()">
          SUBMIT
        </button>
      </form>
    </div>

    <img v-if="!find-restaurants-results" src="@/assets/cheers.gif"/>

    <div id="find-restaurants-results" class="right-panel">
      <restaurant-card
        class="card"
        v-for="business in businesses"
        v-bind:key="business.id"
        v-bind:business="business"
      >
      </restaurant-card>
    </div>
  </body>
</template>


<script>
import RestaurantService from "../services/RestaurantService.js";
import RestaurantCard from "../components/RestaurantCard.vue";

export default {
  name: "restaurants",
  components: {
    RestaurantCard,
  },
  props: ["business"],
  data() {
    return {
      location: "",
      businesses: [],
    };
  },
  methods: {
    find() {
      if (this.state != undefined) {
        this.location = this.location + this.state;
      }
      RestaurantService.find(this.location).then((response) => {
        this.businesses = response.data;
      });
    },
  },
};
</script>

<style scoped>
body {
  padding-top: 15px;
  display: flex;
  order: bottom;
  z-index: -1;
}

.left-panel {
  width: 30%;
  display: flex;
  margin: auto;
  justify-content: center;
  margin-top: 100px;
}

form.find-form {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.right-panel {
  width: 70%;
  flex-grow: 1;
  justify-content: center;
  text-align: center;
  padding-left: 0%;
}

p {
  font-size: 25px;
  display: flex;
  line-height: 5px;
  font-family: Montserrat;
  font-weight: normal;
}

input.location {
  width: 175px;
  padding: 10px 15px;
  border: 3px solid lightgray;
  text-align: center;
  border-radius: 10px;
  font-size: 16px;
}

a.router-link-active {
  font-weight: bold;
}

#submit-button {
  background-color: #a64d79ff;
  color: white;
  border: none;
  text-decoration: none;
  font-size: 15px;
  font-weight: bold;
  border-radius: 10px;
  width: 100px;
  padding: 12px 12px;
}

label {
  font-family: Montserrat;
  font-size: 23px;
}

select {
  -webkit-appearance: none;
  border: none;
  font-family: Montserrat;
  color: #666666;
  font-size: 20px;
  padding: 0 15px 0 0;
}

option {
  padding: 5px;
}

#submit-button:focus {
  background: #e06666;
}

#submit-button:hover {
  background: #741b47ff;
}

@media screen and (max-width: 800px) and (min-width: 200px) {
  .container {
    display: flex;
  }

  .left-panel {
    width: 100%;
    padding-bottom: 20px;
  }
  .right-panel {
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
}

@media screen and (max-width: 1200px) {
  .container {
    padding-top: 15px;
    display: flex;
    flex-direction: column;
  }

  .left-panel {
    width: 30%;
    /* position: fixed; */
    top: 175px;
    margin-top: 50px;
  }

  .right-panel {
    width: 100%;
    justify-content: center;
    text-align: center;
    padding-left: 0;
    padding-top: 75px;
  }
}
</style>
