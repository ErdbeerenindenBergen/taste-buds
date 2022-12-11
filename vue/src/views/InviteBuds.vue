<template>
  <div id="invite-buds">

    <div class="tab-buttons">
    <button  type="button"  id="step-1-create-event" class="button"  v-on:click="showFormStepOne()">Step 1: Info</button>
    <button  type="button"  id="step-2-create-event"  class="button" v-on:click="showFormStepTwo()" >Step 2: Tastes</button>
    <button  type="button"  id="step-3-create-event"  class="button" v-on:click="showFormStepThree()" >Step 3: Buds</button>
    </div>
    <!-----------------------Event Form----------------------->

    <form id="event-form" @submit="createEvent()">

      <h1>Enter your event information below:</h1>

      <div class="event-info">
        <h2>Event Name:</h2>
        <input  type="text"  class="event-input"  v-model="event.eventName"  placeholder="your event name" />
        <h2>Event Date:</h2>
        <input  type="date"  class="event-input"  v-model="event.eventDate"  placeholder="mm/dd/yyyy" />
        <h2>Event Time:</h2>
        <input  type="time"  class="event-input"  v-model="event.eventTime"  placeholder="hh:mm" />
      </div>

      <div class="invite-due-date-time">
        <h2>When must your buds respond by?</h2>
        <input  type="date"  class="event-input"  v-model="event.deadlineDate"  placeholder="mm/dd/yyyy" />
        <input  type="time"  class="event-input"  v-model="event.deadlineTime"  placeholder="hh:mm" />
      </div>

      <button  type="button"  id="create-event-button"  v-on:click="createEvent()">SUBMIT</button>
    </form>

    <!-----------------------Invite Form----------------------->

    <form id="invite-form" ref="invite-form" v-show=false @submit="addToInvitees()">
      <div class="email">
        <h1>Enter the email address of the bud you want to invite:</h1>
        <input  type="text" id="invitee-input" class="date"  v-model="invitation.emailAddress"  placeholder="your bud's email" @keydown.enter.exact.prevent="addToInvitees()"/>
                <button type="button" id="invite-button" value='clearInput' v-on:click="addToInvitees()" >ADD</button>
      </div>

      <div class="send-invite">

      </div>

        <h2>Below is a list of current invitees to this event:</h2>
      <div id="current-list-of-invitees" v-for='invitation in invitees' :key='invitation.emailAddress'>
        <h2 id='inviteeEmailAddress'>{{ invitation.emailAddress }}</h2>
          <!-- how to print current invitees in their own rows here? -->
      </div>

    </form>

      <!-------------------Add Restaurants to Event ----------------------->

    <form id="restaurants-form" v-show=false>  
<template>
 <body class="container">

    <div id="find" class="left-panel">
        <form class="find-form" @submit="find()">
          <br>
          <p>Enter a city or zipcode</p>
          <br>
            <input id="city-or-zip" type="text" class="location" v-model="location"
              @keydown.enter.exact.prevent="find()" placeholder="City or Zipcode"/>
            <br>
            <br>
            <label for="state">If you'd like, you can specify a state.</label>
            <br>
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
            <br>
            <button type="button" id="submit-button" v-on:click="find()">SUBMIT</button>
        </form>
    </div>

    <div id="find-restaurants-results" class="right-panel">
        <restaurant-event-view class="card" v-for="business in businesses" v-bind:key="business.id" v-bind:business="business"> </restaurant-event-view>
    </div>

  </body>
</template>


    </form>

  </div>
</template>



<script>

// import InviteService from "../services/InviteService";
import RestaurantEventView from "../components/RestaurantEventView.vue";
import RestaurantService from "../services/RestaurantService.js";
import EventService from "../services/EventService.js";
import InvitationService from "../services/InvitationService.js"
// import InviteService from '../services/InviteService';


export default {
  name: "create-event",
  components: {
    RestaurantEventView
  },
    props:[ 
      "business"],
  data() {
    return {
        location:"",
        businesses: [], //this is for 'view restaurants list' button, OR this is what will hold the results of the queries? same thing?
        userId: '',
        event: {
            eventId: 0,
            eventName: "",
            eventDate: "",
            eventTime: "",
            eventOrganizerId: 0,
            deadlineDate: "", 
            deadlineTime: "", 
        },
        state:'',
        eventRestaurant: {
          yelpRestaurantId: "",
          eventId: 0
        },
        invitation: {
          // invitationId: '',
          eventId: 0,
          emailAddress: '',
        },
        invitationIds: [],
        invitees: [], //this is to store invitees as they are added by user
        eventRestaurants: []
    };
  },
  methods: {
    createEvent() {
        this.eventDate = this.moment(this.eventDate).format('YYYY-MM-DD');
        this.deadlineDate = this.moment(this.deadlineDate).format('YYYY-MM-DD');
        // console.log(this.event);
        // console.log(this.$store.state.user);
        
        EventService.createEvent(this.event).then(response => {
          this.event.eventId = response.data.eventId;

          this.invitees.forEach ((invitation) => {
            invitation.eventId = this.event.eventId;
          InvitationService.createInvitation(invitation).then(response => {
            this.invitationIds.push(response.data.invitationId);
          })
        })
          console.dir(this.invitees);

          // RestaurantService.createEventRestaurantInDatabase(this.eventRestaurant);
        })
    },
    makeInvitationList() {
    },
    showFormStepOne() {
      const stepOneForm = document.getElementById('event-form');
      const stepTwoForm = document.getElementById('restaurants-form');
      const stepThreeForm = document.getElementById('invite-form');
          stepOneForm.style.display = 'block';
          stepTwoForm.style.display = 'none';
          stepThreeForm.style.display = 'none';
    },
    showFormStepTwo() {
      const stepOneForm = document.getElementById('event-form');
      const stepTwoForm = document.getElementById('restaurants-form');
      const stepThreeForm = document.getElementById('invite-form');
          stepOneForm.style.display = 'none';
          stepTwoForm.style.display = 'block';
          stepThreeForm.style.display = 'none';
    },
      showFormStepThree() {
      const stepOneForm = document.getElementById('event-form');
      const stepTwoForm = document.getElementById('restaurants-form');
      const stepThreeForm = document.getElementById('invite-form');
          stepOneForm.style.display = 'none';
          stepTwoForm.style.display = 'none';
          stepThreeForm.style.display = 'block';
    },
    //think I'm doing something wrong here
    addToInvitees() {
      this.invitees.push({...this.invitation});
       //learned about this really cool thing called the "spread operator" or "..." which makes a clone of input and therefore freezes it in time basically
      // document.getElementById("invitee-input").value = "";
      this.invitation.emailAddress="";
    },
    viewRestaurants() {
       return RestaurantService.findBusinessesByEventId(this.event.eventId).then(response => {
            this.businesses = response.data;
       })
    },
    find() {
      if (this.state != undefined) {
      this.location = this.location + this.state;}
      RestaurantService.find(this.location).then(response => {
        this.businesses = response.data;
      })
    },
    clearInput(target) {
      if (target.value== 'clear input'){
      target.value= "";
      }
    }
  },
  created() {
    this.event.eventOrganizerId = this.$store.state.user.id;
    this.showFormStepOne();
    // const stepOneForm = document.getElementById('event-form');
    // const stepTwoForm = document.getElementById('invite-form');
  }
};

</script>

<style scoped>

h1 {
  font-family: Montserrat;
  color: #666666;
  font-weight: normal;
  text-align: center;
  padding-top: 45px;
}

a.router-link-active{
  font-weight: bold;
}

/* .inviteBud-form {
    width: 30%;
    position: fixed;
    top: 150px;
    padding: 10px;
    display: flex;
    flex-direction: row;
    align-items: center;
    flex-wrap: wrap;
    justify-content: center;
} */

input {
  width: 25%;
  align-self: center;
  padding: 10px 15px;
  border: 3px solid lightgray;
  text-align: center;
  justify-content: center;
  border-radius: 10px;
  font-size: 16px;
  display: flex;
  flex-grow: 0;
  margin-top: 15px;
}

h2 {
    text-align: center;
    font-family: Montserrat;
    font-weight: normal;
}

.tab-buttons{
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
}

.button{
  background-color: #f0efef;
  color: #666666;
  border:none;
  text-decoration: none;
  font-size:22px;
  font-weight: normal;
  font-family: Montserrat;
  border-radius: 10px;
  width: 15%;
  padding: 12px 12px;
  margin-top:40px;
  display: flex;
}

#create-event-button{
  background-color: #a64d79ff;
  color: white;
  border:none;
  text-decoration: none;
  font-size:15px;
  font-weight: bold;
  border-radius: 10px;
  width: 15%;
  padding: 12px 12px;
  display: flex;
  justify-content: center;
  margin: auto;
  margin-top: 15px;
}

#event-info-button, #invite-button, #restaurant-button{
  background-color: #a64d79ff;
  color: white;
  border:none;
  text-decoration: none;
  font-size:15px;
  font-weight: bold;
  border-radius: 10px;
  width: 15%;
  height: 45px;
  padding: 12px 12px;
}

placeholder {
  font-family: Montserrat;
  color: #909090;
}

/* #restaurant-button {
    margin-bottom: 10px;
    width: 50%;
} */

input.date{
  justify-content: center;
  display: flex;
  align-content: center;
  margin: auto;
  margin-top: 60px;
}

#invite-button{
  justify-content: center;
  display: flex;
  align-content: center;
  margin: auto;
  margin-top: 20px;
  margin-bottom: 40px;
  width:15%;
}

.event-input {
  display: flex;
  justify-content: center;
  margin: auto;
  font-family: Arial;
  color:#909090;
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
    width: 100%
}

body{
    padding-top: 15px;
    display:flex;
    order: bottom;
    z-index: -1;
}

.left-panel{
  width:30%;
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
  background: #e06666;
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
    width: 30%;
    /* position: fixed; */
    top: 175px; 
    margin-top:50px;
  }

  .right-panel{
    width:100%;
    justify-content: center;
    text-align: center;
    padding-left: 0;
    padding-top: 475px;
  }
}

@media screen and (max-width: 800px) and (min-width: 200px) {
 .container{
    display:flex;
}

.left-panel{
  width:100%;
  padding-bottom:20px;
}

.tab-buttons{
  flex-direction: row;
  margin-top:25px;
}

.button{
  flex-grow: 1;
  width: 100%;
  margin:5px;
}

.right-panel{
  width:100%;
  justify-content: center;
  text-align: center;
}
}

</style>