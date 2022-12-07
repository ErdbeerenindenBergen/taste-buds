<template>
 <body class="container">
    <div id="find" class="left-panel">

        <form class="find-form" @submit="find">
          <p>Enter a city or zipcode</p>

            <input type="text" class="location" v-model="location" placeholder="City or Zipcode" />
            <button type="button" id="submit-button" v-on:click="find()">SUBMIT</button>
        </form>
        </div>

         <restaurant-card class="card" v-for="business in restaurantList" v-bind:key="business.id" v-bind:business="business"> </restaurant-card>

  </body>
</template>


<script>
import RestaurantService from "../services/RestaurantService.js"
import RestaurantCard from '../components/RestaurantCard.vue'


export default {
    name: "restaurants",
    components: {
          RestaurantCard
    },
    props:[ 
      "business"],
    data() {
        return{
            location:"",
            restaurantList: [],
            businesses: {
              id: "",
             restaurantName: "",
             thumbnailImageURL: "",
             isClosed: false,
             // categories: [
             //     {
             //         alias: "",
             //         title: ""
             //     }
             // ],
             stars: 0.0,
             // coordinates: {
             //     latitude: 0,
             //     longitude: 0
             // },
             // location: {
             //     address1: "",
             //     city: "",
             //     zip_code: "",
             //     state: "",
                
             // },
             restaurantAddress: "",
             phoneNumber: "",
             url: ""
            }
        }
     },
    methods: {
        find() {
            RestaurantService.find(this.location).then(response => {
             this.restaurantList = response.data;
            })
        }
    },
     
     
}
</script>

<style scoped>

.find-form{
    padding-top: 20px;
}

.container{
    padding-top: 25px;
}

p {
  font-size: 25px;
  display: flex;
  line-height: 5px;
  font-family:'Playfair Display';
  font-weight: normal;
  padding-right: 20px;
}


input.location {
  width: 25%;
  padding: 10px 15px;
  border: 3px solid lightgray;
  text-align: center;
  border-radius: 10px;
  font-size: 16px;
  margin-right: 30px;
}

form.find-form {
    display: flex;
    flex-direction: row;
    justify-content: center;
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
  width: 10%;
  padding: 12px 12px;
}

</style>
