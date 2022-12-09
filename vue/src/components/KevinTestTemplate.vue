<template>
    <div id="invite-buds">


        <form class="inviteBud-form" v-on:submit.prevent="submitForm">
           
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

            </form>
                    <!-----------------------Enter Email Field ----------------------->

            <div class="email">
                <h2>Enter the email of the bud you want to invite:</h2>
                <input type="text" class="date" v-model="email" placeholder="your bud's email"/>
            </div>
            
                    <!-------------------Send Invite Button Link or Button --------------------->

            <div class="send-invite">
                <h2>Want to invite a friend who is not yet a taste bud?</h2>
                <h2>Share this invite Id with them: {{ this.invitation.inviteId }}</h2>
                <button type="button" id="invite-button" v-on:click="viewInviteLink()">See Invite</button>
            </div>
       
                     <!-------------------View all Restaurants Button ----------------------->

             <button type="button" id="restaurant-button" v-on:click="viewRestaurants()">view restaurants list</button>

         

        <!-- this here is the imported RestaurantCard.vue template from components -->
            
            <div id="find-restaurants-results" class="right-panel">
            <restaurant-card class="card" v-for="business in restaurantList" v-bind:key="business.id" v-bind:business="business"> </restaurant-card>
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
            invitation: {
                eventName: "",
                inviteId: "",
                decisionDate: "", //might not be correct default date approach
                decisionTime: "",//might not be correct default time approach
                uniqueInvitationLink: ""
            },


        }
    },
    methods: {
      
      //mikey note to self: the submit function should create new invite with the data from above. reference the store stuff from lecture.
      submitForm() {
          const inviteInfo = {
              eventName:"", 
              inviteId: "", 
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

.container{
    padding-top: 15px;
    display:flex;
}

.left-panel{
  width:30%;
  position: fixed;
  top: 250px;
  left: 0;
}

.right-panel{
  width:70%;
  justify-content: center;
  text-align: center;
  padding-left: 30%;
}

p {
  font-size: 25px;
  display: flex;
  line-height: 5px;
  font-family:Montserrat;
  font-weight: normal;
}

input.location {
  width: 25%;
  padding: 10px 15px;
  border: 3px solid lightgray;
  text-align: center;
  border-radius: 10px;
  font-size: 16px;
}

form.find-form {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    position: fix;
    top: 0;
    left: 0;
    right: 0;
}

a.router-link-active{
  font-weight: bold;
}

#submit-button{
  background-color: #a64d79ff;
  color: white;
  border:none;
  text-decoration: none;
  font-size:15px;
  font-weight: bold;
  border-radius: 10px;
  width: 100px;
  padding: 12px 12px;
}

label{
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

option{
  padding: 5px;
}

#submit-button:focus{
  background: orange;
}

#submit-button:hover{
  background:#741b47ff;
}

@media screen and (max-width: 1200px) {

.container{
    padding-top: 15px;
    display:flex;
    flex-direction: column;
}

  .left-panel{
    width: 100%;
    position: fixed;
    top: 150px;
    left: 0;
    background: white;
  }

  .right-panel{
    width:100%;
    justify-content: center;
    text-align: center;
    padding-left: 0;
    padding-top: 425px;
  }
}

@media screen and (max-width: 800px) {
 .container{
    display:flex;
}

.left-panel{
  width:100%;
  padding-bottom:20px;
}
.right-panel{
  width:100%;
  justify-content: center;
  text-align: center;
}
}



</style>