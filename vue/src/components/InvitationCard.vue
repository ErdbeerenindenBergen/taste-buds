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

    <div id="restaurant-display">
      <div id="restaurant-left">
        <h2 id="name">{{ business.name }}</h2>

        <img
          v-if="business.image_url != ''"
          :src="business.image_url"
          class="thumbnail"
        />

        <div id="icons">
          <!-- <div id="add-restaurant-to-favorites">
                  <a><font-awesome-icon icon="fa-solid fa-heart" class="zoom" id="heart-icon" v-if="userIsLoggedIn()"/></a>
                </div>   -->

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

          <div id="thumbs-up-link">
            <a>
              <font-awesome-icon
                icon="fa-solid fa-thumbs-up"
                class="zoom thumbs-up-icon"
                id="thumbs-up-icon"
                :class="isApproved ? 'green' : ''"
                v-on:click="addRestaurantToYesList(business.id)"
              />
            </a>
          </div>

          <div id="thumbs-down-link">
            <a>
              <font-awesome-icon
                icon="fa-solid fa-thumbs-down"
                class="zoom thumbs-down-icon"
                id="thumbs-down-icon"
                :class="isRejected ? 'red' : ''"
                v-on:click="addRestaurantToNoList(business.id)"
              />
            </a>
          </div>
        </div>
      </div>

      <div id="restaurant-right">
        <div
          class="rating"
          :class="
            (ifRestaurant5(business.rating) ? 'r-5' : '') +
            '' +
            (ifRestaurant45(business.rating) ? 'r-45' : '') +
            '' +
            (ifRestaurant4(business.rating) ? 'r-4' : '') +
            '' +
            (ifRestaurant35(business.rating) ? 'r-35' : '') +
            '' +
            (ifRestaurant3(business.rating) ? 'r-3' : '') +
            '' +
            (ifRestaurant25(business.rating) ? 'r-25' : '') +
            '' +
            (ifRestaurant2(business.rating) ? 'r-2' : '') +
            '' +
            (ifRestaurant15(business.rating) ? 'r-15' : '') +
            '' +
            (ifRestaurant1(business.rating) ? 'r-1' : '') +
            '' +
            (ifRestaurant05(business.rating) ? 'r-05' : '') +
            '' +
            (ifRestaurant00(business.rating) ? 'r-0' : '')
          "
        ></div>

        <h2 id="isClosed">
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
          <a href="tel:${business.phone}" target="_blank"
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
import fontawesome from "@fortawesome/fontawesome";
import brands from "@fortawesome/fontawesome-free-brands";
import solid from "@fortawesome/fontawesome-free-solid";

fontawesome.library.add(brands, solid);

export default {
  name: "invitation-card",
  props: {
    business: Object,
  },
  components: {},
  data() {
    return {
      userId: "",
      favorite: {
        restaurantId: "",
        userId: 0,
      },
      isApproved: false,
      isRejected: false,
      restaurants: [],
      approvedRestaurants: [],
      rejectedRestaurants: [],
    };
  },
  methods: {
    addToInvitees() {
      this.invitees.push({ ...this.invitation });
      //resetForm;
      let target = document.getElementById("invitee-input");
      target.value = "";
    },
    userIsLoggedIn() {
      let $loggedIn = false;
      if (this.userId != 0) {
        $loggedIn = true;
      }
      return $loggedIn;
    },
    addRestaurantToYesList(id) {
      this.$store.commit("ADD_TO_YES_LIST", id);
      this.isApproved = true;
      this.isRejected = false;
    },
    addRestaurantToNoList(id) {
      this.$store.commit("ADD_TO_NO_LIST", id);
      this.isApproved = false;
      this.isRejected = true;
    },
    ifRestaurant5(rating) {

      if (rating === 5) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant45(rating) {
      if (rating === 4.5) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant4(rating) {
      if (rating === 4) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant35(rating) {
      if (rating === 3.5) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant3(rating) {
      if (rating === 3) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant25(rating) {
      if (rating === 2.5) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant2(rating) {
      if (rating === 2) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant15(rating) {
      if (rating === 1.5) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant1(rating) {
      if (rating === 1) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant05(rating) {
      if (rating === 0.5) {
        return true;
      } else {
        return false;
      }
    },
    ifRestaurant00(rating) {
      if (rating === 0) {
        return true;
      } else {
        return false;
      }
    },
  },
  created() {
    this.userId = this.$store.state.user.id;
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Playfair+Display");

div.rating {
  font-family: FontAwesome;
  font-size: 40px;
  display: inline-block;
  padding-top: 20px;
}
/* div.rating:before { content: "\f006\f006\f006\f006\f006"; color: Gray;  } */
div.rating:after {
  color: rgb(255, 217, 0);
  left: 0;
}

.r-0:before {
  content: "";
}
.r-05:after {
  content: "\f089\00a0";
}
.r-1:after {
  content: "\f005";
}
.r-15:after {
  content: "\f005\f089\00a0";
}
.r-2:after {
  content: "\f005\f005";
}
.r-25:after {
  content: "\f005\f005\f089\00a0";
}
.r-3:after {
  content: "\f005\f005\f005";
}
.r-35:after {
  content: "\f005\f005\f005\f089\00a0";
}
.r-4:after {
  content: "\f005\f005\f005\f005";
}
.r-45:after {
  content: "\f005\f005\f005\f005\f089\00a0";
}
.r-5:after {
  content: "\f005\f005\f005\f005\f005";
}

#restaurant-display {
  font-family: "Playfair Display";
  font-size: 20px;
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

.green path {
  fill: rgb(3, 173, 3);
}

.red path {
  fill: red;
}

#yelp-icon,
#heart-icon,
.thumbs-up-icon,
.thumbs-down-icon {
  height: 40px;
  margin: 10px;
}

#heart-icon,
.thumbs-up-icon,
.thumbs-down-icon {
  color: #a64d79ff;
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

.zoom:hover {
  transform: scale(1.2);
  transition: all ease 500ms;
}

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




