<template>
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

          <div id="trophy">
            <a>
              <font-awesome-icon icon="fa-solid fa-trophy"
                class= "zoom trophy-icon"
                :class="isRestaurantWinner(business) === true ? 'winner' : ''"
              />
            </a>
          </div>

        </div>
      </div>

      <div id="restaurant-right">


        <div class="rating" 
          :class="(ifRestaurant5(business.rating) ? 'r-5' : '') + '' +  
          (ifRestaurant45(business.rating) ? 'r-45' : '')  + '' +
          (ifRestaurant4(business.rating) ? 'r-4' : '') + '' + 
          (ifRestaurant35(business.rating) ? 'r-35' : '')  + '' +
          (ifRestaurant3(business.rating) ? 'r-3' : '')  + '' +
          (ifRestaurant25(business.rating) ? 'r-25' : '')  + '' +
          (ifRestaurant2(business.rating) ? 'r-2' : '')  + '' +
          (ifRestaurant15(business.rating) ? 'r-15' : '')  + '' +
          (ifRestaurant1(business.rating) ? 'r-1' : '')  + '' +
          (ifRestaurant05(business.rating) ? 'r-05' : '') + '' +
          (ifRestaurant00(business.rating) ? 'r-0' : '') "
        ></div>

        <!-- <h2 id="stars">Average rating: {{ business.rating }}</h2> -->
        <h2 id="isClosed" >
          {{ business.hours[0].openNow === true ? "Open now" : "Closed" }}
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
          <a href="tel:${business.phone}" id="call-to-order" target="_blank"
            ><button class="call-button" type="button call">
              <font-awesome-icon icon="phone" /> CALL TO ORDER
            </button></a
          >
        </div>
      </div>
    </div>
  </div>
</template>

<script>

export default {    
  name: "event-restaurant-card",
  props: {
      business: Object,
  },
  components: {},
  data() {
      return {
       isWinner: false,
      }
  },
   created() {
    this.userId = this.$store.state.user.id;
    // this.restaurantWinner({...this.business.yelpRestaurantId});
    this.winningRestaurants = this.$store.state.winningRestaurants;
    this.isRestaurantWinner({...this.business});
   },
  methods: {
    ifRestaurant5(rating){
      if (rating === 5) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant45(rating){
      if (rating === 4.5) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant4(rating){
      if (rating === 4) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant35(rating){
      if (rating === 3.5) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant3(rating){
      if (rating === 3) {
        return true;
      } else {
        return false;
      }
    },  
    ifRestaurant25(rating){
      if (rating === 2.5) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant2(rating){
      if (rating === 2) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant15(rating){
      if (rating === 1.5) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant1(rating){
      if (rating === 1) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant05(rating){
      if (rating === 0.5) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant00(rating){
      if (rating === 0) {
        return true;
      } else {
        return false;
      }
    },
    userIsLoggedIn() {
      let $loggedIn = false;
      if (this.userId != 0) {
      $loggedIn = true;
    } return $loggedIn;  
  },
    isRestaurantWinner(business) {
      // this.$store.state.winningRestaurants.forEach((restaurant) => {
      //   if (id === restaurant.id) {
      //     this.isWinner === true;
      //   }
      // })
      if (this.$store.state.winningRestaurants.includes(business)) {
        return true;
      } else {
        return false;
      }
    },
    // restaurantWinner(id) {
    //   if (id === this.$store.state.winner) {
    //     return true;
    //   } else {
    //     return false;
    //   }
    // }
  },
}

</script>

<style scoped>

#rating-box{
  display: flex;
}

h1 {
  font-family: "Playfair Display";
  font-weight: normal;
  text-align: center;
  padding-top: 40px;
}

h2 {
  font-size:24px;
}


a.router-link-active {
  font-weight: bold;
}

@import url("https://fonts.googleapis.com/css2?family=Playfair+Display");

#restaurant-display {
  font-family: "Playfair Display";
  font-size: 20px;
  /* border: 1px solid #999999; */
  border-radius: 10px;
  margin: 20px 0 10px 0;
  padding: 0 30px 0 30px;
  text-align: center;
  font-weight: normal;
  display: flex;
  background: #f0efef;
  flex: grow;
}

#restaurant-left {
  display: flex;
  flex-direction: column;
  flex: grow;
  width: 50%;
  justify-content: center;
  text-align: center;
}

#restaurant-right {
  display: flex;
  flex-direction: column;
  flex: grow;
  width: 50%;
  justify-content: center;
  text-align: center;
}

.call-button {
  background-color: #a64d79ff;
  color: white;
  border: none;
  text-decoration: none;
  font-size: 15px;
  font-weight: bold;
  border-radius: 10px;
  width: 200px;
  padding: 12px 12px;
  margin-bottom: 20px;
}

.thumbnail {
  float: left;
  height: 400px;
  width: 400px;
  object-fit: cover;
  border-radius: 10px;
  margin: auto;
}

svg {
  margin-right: 10px;
}

#icons {
  display: flex;
  justify-content: center;
}

#yelp-icon,
#heart-icon,
#thumbs-up-icon,
#thumbs-down-icon {
  height: 40px;
  margin: 10px;
}

/* might need to delete below */
.trophy-icon{
  display:none;
}

#heart-icon,
#thumbs-up-icon,
#thumbs-down-icon {
  color: #a64d79ff;
}

.trophy{
display: none;
}

#google-icon {
  height: 40px;
  margin: 10px;
}

#purple-heart-icon {
  height: 40px;
  margin: 10px;
  border: 0px;
  text-decoration: none;
}

p {
  font-size: 25px;
  font-family: Montserrat;
}

button:focus {
  background: #e06666;
}

button:hover {
  background: #741b47ff;
}

#call-to-order-button{
  padding-right:0 !important;
}

.zoom:hover {
  transform: scale(1.2);
  transition: all ease 500ms;
}

.winner {
  display: block;
  height: 40px;
  margin: 10px;
  color: gold;
}


div.rating { font-family: FontAwesome; font-size: 40px;  display: inline-block; padding-top:20px;}
/* div.rating:before { content: "\f006\f006\f006\f006\f006"; color: Gray;  } */
div.rating:after { color: rgb(255, 217, 0); left: 0;}  

.r-0:before { content: ""; }
.r-05:after { content: "\f089\00a0";}
.r-1:after { content: "\f005"; }
.r-15:after { content: "\f005\f089\00a0"; }
.r-2:after { content: "\f005\f005"; }
.r-25:after { content: "\f005\f005\f089\00a0"; }
.r-3:after { content: "\f005\f005\f005"; }
.r-35:after { content: "\f005\f005\f005\f089\00a0"; }
.r-4:after { content: "\f005\f005\f005\f005"; }
.r-45:after { content: "\f005\f005\f005\f005\f089\00a0";  }
.r-5:after { content: "\f005\f005\f005\f005\f005"; }


@media screen and (max-width: 1350px) {
  .thumbnail {
    margin: auto;
    height: 300px;
    width: 300px;
  }
  #restaurant-right {
    justify-content: center;
    margin: auto;
  }
  #restaurant-left {
    justify-content: center;
    margin: auto;
  }
}

@media screen and (max-width: 1200px) {
  #root {
    padding-top: 100px;
  }
}

@media screen and (max-width: 970px) {
  #restaurant-display {
    flex-direction: column;
  }

  #root {
    padding-top: 100px;
  }

  .thumbnail {
    float: left;
    height: 225px;
    width: 225px;
    object-fit: cover;
    border-radius: 10px;
    justify-content: center;
    /* margin: auto; */
  }
  #restaurant-display {
    flex: grow;
    justify-content: center;
    padding: 0 30px 0 30px;
  }
}
</style>