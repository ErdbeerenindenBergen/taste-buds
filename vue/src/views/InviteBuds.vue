<template>
<div id="container">
    <div id="invite-buds">
        <form class="inviteBud-form" v-on:submit.prevent="submitForm">
            <button type="button" id="restaurant-button" v-on:click="viewRestaurants()">view restaurants list</button>
                     <!-------B-------------- Query Fields to Search Restaurants ---------------------->
            <div class="event-info">
                <h2>Event Name:</h2>
                <input type="text" class="event-name" v-model="invitation.eventName" placeholder="Capstone Celebration" />
            </div>
           <!--  <div class="city-zip">
                <h2>Enter a city or zipcode:</h2>
                <input type="text" class="zip-city" v-model="location" placeholder="City or Zipcode" />
            </div>
            <div class="state">
                <h2>State:</h2>
                <input type="text" class="state" v-model="location" placeholder="State" />
            </div> -->
              <!-------------- Search Restaurant button similar to Find Restaurant ------------------->
            <!-- <button type="button" id="search-button" v-on:click="find()">searchRestaurants</button> -->
            <!-----------------------Current Location button ----------------------->
            <!-- <button type="button" id="current-location-button" v-on:click="currentLocation">Current Location</button>  -->
                    <!------------------------- Date/Time Fields ------------------------------>
            <div class="date-time">
                <h2>When must your buds respond by?</h2>
                <input type="text" class="date" v-model="invitation.decisionDate" placeholder="mm/dd/yyyy"/>
                <input type="text" class="time" v-model="invitation.decisionTime" placeholder="hh:mm" />
            </div>
                     <!-----------------------Submit Invite info Button ----------------------->
            <button type="button" id="event-info-button" v-on:click="submitForm()">SUBMIT</button>
                    <!-----------------------Enter Email Field ----------------------->
            <div class="email">
                <h2>Enter the email of the bud you want to invite:</h2>
                <input type="text" class="date" v-model="email" placeholder="your bud's email"/>
            </div>
            <button type="button" id="invite-button" v-on:click="viewInviteLink()">See Invite</button>
                    <!-------------------Send Invite Button Link or Button --------------------->
            <!-- <div class="send-invite">
                <h2>Want to invite a friend who is not yet a taste bud?</h2>
                <h2>Share this invite Id with them: {{ this.invitation.inviteId }}</h2>
            </div> -->
            </form>
                     <!-------------------View all Restaurants Button ----------------------->
        <!-- this here is the imported RestaurantCard.vue template from components -->
             <div id="find-restaurants-results" class="right-panel">
            <restaurant-card class="card" v-for="business in restaurantList" v-bind:key="business.id" v-bind:business="business"> </restaurant-card>
            </div>
    </div>
    </div>
</template>



<script>
    //mikey note to self: think about imports and whether u need them

import InviteService from '../services/InviteService';
import RestaurantCard from '../components/RestaurantCard.vue';
//import RestaurantService from '../services/RestaurantService';


export default{
    components: {
        RestaurantCard,
        
    },
    props: {
        business: []
   },
    data() {
        return {
            inviteInfo: {},
            businesses: [],
            invitation: {
                eventName: "",
                event_organizer_id: "",
                inviteId: "",
                decisionDate: "", //might not be correct default date approach
                decisionTime: "",//might not be correct default time approach
                uniqueInvitationLink: ""
            },


        }
    },
    methods: {
      
      //mikey note to self: the submit function should create new invite with the data from above. reference the store stuff from lecture.
      //the idea is to save all the invites to the store and then we could access it anytime and mutate it....i think. lmao
      submitForm() {
          const inviteInfo = {
              eventName: this.eventName,
              event_organizer_id: this.event_organizer_Id, 
              inviteId: this.inviteId, 
              decisionDate: this.invitation.decisionDate, 
              decisionTime: this.invitation.decisionTime, 
              uniqueInvitationLink: this.invitation.uniqueInvitationLink
           };
          
          InviteService.createInvitation(inviteInfo).then(response => {
              this.invitation.inviteId = response.data;
              this.$store.commit("SET_PENDING_INVITE", response.data);
          })

      },
        //need to make sure backend is set up. work in progress
      viewInviteLink() {
          let inviteLink = "http://localhost:8080/invitation/view/" + this.invitation.inviteId;
          window.open(inviteLink);

      }
        
    }

        
    
}

</script>


<style scoped>
h1{
  font-family: 'Playfair Display';
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
};
</style>