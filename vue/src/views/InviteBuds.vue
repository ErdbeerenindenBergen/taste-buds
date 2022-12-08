<template>
    <div id="invite-buds">


        <form class="invite-form" @submit="invite">
           
                     <!--------------------- Query Fields to Search Restaurants ---------------------->

            <div class="event-info">
                <h2>Event Name:</h2>
                <input type="text" class="event-name" v-model="invitation.eventName" placeholder="Capstone Celebration" />
            </div>

            <div class="city-zip">
                <h2>Enter a city or zipcode:</h2>
                <input type="text" class="zip-city" v-model="location" placeholder="City or Zipcode" />
            </div>

            <div class="state">
                <h2>State:</h2>
                <input type="text" class="state" v-model="location" placeholder="State" />
            </div>

              <!-------------- Search Restaurant button similar to Find Restaurant ------------------->

            <button type="button" id="search-button" v-on:click="find()">search restaurants</button>

                    <!------------------------- Date/Time Fields ------------------------------>

            <div class="date-time">
                <h2>When must your buds respond by?</h2>
                <input type="text" class="date" v-model="invitation.decisionDate" placeholder="mm/dd/yyyy"/>
                <input type="text" class="time" v-model="invitation.decisionTime" placeholder="hh:mm" />
            </div>

                     <!-----------------------Submit Invite info Button ----------------------->
                    <!-- my understanding is this button will submit/save the restaurants of 10 or whatever from the query above -->

            <button type="button" id="event-info-button" v-on:click="collectRestaurantsForInvite()">SUBMIT</button> 

                    <!-----------------------Enter Email Field ----------------------->

            <div class="email">
                <h2>Enter the email of the bud you want to invite:</h2>
                <input type="text" class="date" v-model="email" placeholder="your bud's email"/>
            </div>
            
                    <!-------------------Send Invite Button Button --------------------->

            <div class="send-invite">
                <h2>Want to invite a friend who is not yet a taste bud?</h2>
                <button type="button" id="invite-button" v-on:click="sendInvite()">send an invite!</button>
            </div>
       
                     <!-------------------View all Restaurants Button ----------------------->

             <button type="button" id="restaurant-button" v-on:click="viewRestaurants()">view restaurants list</button>

         </form>

        <!-- this here is the imported RestaurantCard.vue template from components -->
            
            <div id="find-restaurants-results" class="right-panel">
            <restaurant-card class="card" v-for="business in restaurantList" v-bind:key="business.id" v-bind:business="business"> </restaurant-card>
            </div>

            <!-- this here is the imported Restaurants.vue template from views -->
           
            <restaurants />
            

    </div>
</template>



<script>
    //mikey note to self: think about imports and whether u need them

import InviteService from '../services/InviteService';
import RestaurantCard from '../components/RestaurantCard.vue';
import Restaurants from '../views/Restaurants.vue';
//import RestaurantService from '../services/RestaurantService';


export default{
    components: {
        RestaurantCard,
        Restaurants
    },
    props: {
        RestaurantCard,
    },
    data() {
        return {
            restaurantOptions: {},//this is for 'view restaurants list' button, OR this is what will hold the results of  the queryies? same thing?

            invitation: {
                eventName: "",
                inviteId: "",
                decisionDate: "", //might have to parse LocalDate as string
                decisionTime: "",//might have to parse LocalTime as string
                uniqueInvitationLink: ""
            },


        }
    },
    methods: {
      //needs work
      collectRestaurantsForInvite() {
         // RestaurantService.collectRestaurantsForInvite
          
      },
      
      //mikey note to self: the sendInvite function should create new invite with the data from above. reference the store stuff from lecture.
      sendInvite() {
          const invitationObject = {eventName: "", inviteId: "", decisionDate: "", decisionTime: "", uniqueInvitationLink:""};
          
          InviteService.createInvitation(invitationObject).then(response => {
              this.invitation.inviteId = response.data;
              this.$store.commit("SET_PENDING_INVITE", response.data);
          })

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
</style>