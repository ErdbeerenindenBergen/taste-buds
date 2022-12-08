<template>
    <div id="invite-buds">

                    <!---------------------Form Left Panel ---------------------->

        <form class="invite-form" @submit="invite">
           
            <div class="event-info">
                <h2>Event Name:</h2>
                <input type="text" class="event-name" v-model="eventName" placeholder="Capstone Celebration" />
            </div>

            <div class="location">
                <h2>Enter a city or zipcode:</h2>
                <input type="text" class="location" v-model="location" placeholder="City or Zipcode" />
            </div>

            <div class="date-time">
                <h2>When must your buds respond by?</h2>
                <input type="text" class="date" v-model="date" placeholder="mm/dd/yyyy"/>
                <input type="text" class="time" v-model="time" placeholder="hh:mm" />
            </div>

            <button type="button" id="event-info-button" v-on:click="find()">SUBMIT</button>
            
                    <!-------------------View all Restaurants Button/Left Panel ----------------->
                    
                    <!---i'm thinking maybe this button should be near the top? -->
            <button type="button" id="restaurant-button" v-on:click="viewRestaurants()">View Restaurants List</button>

                    <!-------------------Send Invite Button Button/Right Panel ------------------>
            <div class="send-invite">
                <h2>Want to invite a friend who is not yet a taste bud?</h2>
                <button type="button" id="invite-button" v-on:click="sendInvite()">send an invite!</button>
            </div>
        
        </form>
    </div>
</template>



<script>
    //mikey note to self: think about imports and whether u need them

//import InviteService from '../services/InviteService';

export default{

    data() {
        return {
            restaurantOptions: [],//this is for 'view restaurants list' button, similar to find restaurant
            inviteId: "",
            decisionDate: "", //might have to parse LocalDate as string
            decisionTime: "",//might have to parse LocalTime as string
            uniqueInvitationLink: "",

        }
    },
    methods: {
      //mikey note to self: the submitInvite function should create new invite with the data from above. reference the store stuff from lecture.
      //capture data in variable and put that into create? must check backend create function
      submitInvite() {
      
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