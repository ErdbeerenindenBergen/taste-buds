<template>
 <body class="container">
    <div id="find-restaurant" class="left-panel">

        <form class="find-form" @submit="find">
          <p>Enter a city or zipcode</p>

            <input type="text" class="location" v-model="cityOrZip" placeholder="City or Zipcode" />
            <button type="button" id="submit-button" v-on:click="find()">SUBMIT</button>
        </form>
        </div>

        <restaurant-card />

  </body>
</template>


<script>
import RestaurantService from "../services/RestaurantService"
import RestaurantCard from '../components/RestaurantCard.vue'


export default {
    name: "findARestaurant",
    components: {
          RestaurantCard
    },
    props:{},
    data() {
        return{
            cityOrZip:"",
            queryResults: [],
            
        
        }
     
    },
    methods: {
        find() {
            RestaurantService.find(this.cityOrZip).then(response => {
            this.queryResults = response.data;

            })
        }
    },
        
    
    
    
}
</script>

<style scoped>


p {
  font-size: 25px;
  display: flex;
  line-height: 5px;
  font-family:'Playfair Display';
  font-weight: normal;
}


input.location {
  width: 8%;
  padding: 10px 15px;
  border: 3px solid lightgray;
  border-radius: 10px;
  font-size: 16px;
  margin-right: 15px;
}

form.find-form {
    display: flex;
    flex-direction: row;
    justify-content: center;
}

#submit-button{
  background-color: #a64d79ff;
  color: white;
  border:none;
  text-decoration: none;
  font-size:15px;
  font-weight: bold;
  border-radius: 25px;
  width: 10%;
  padding: 12px 12px;
}


</style>
