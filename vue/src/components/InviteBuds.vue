<template>
    <div id="main-div">

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

export default{

    //mikey note to self: think about imports and whether u need them
    
    data() {
        return {
            restaurantOptions: [],//this is for 'view restaurants list' button?
            inviteId: "",
            location: "",
            decisionDate: "", //might have to parse LocalDate as string
            decisionTime: "",//might have to parse LocalTime as string
            uniqueInvitationLink: "",

        }
    },


        
    
}

</script>
