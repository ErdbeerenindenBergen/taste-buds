<template>
 <body>
    <div id="find-restaurant">
        <form class="find-form" @submit="find">
            <p>Enter a city or zipcode:</p>
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
            
            /*********the info below should match the data yelp sends back OR our database ?**************** 
            //-------------i just copy and pasted yelp info from postman -------------------------
            businesses: [
                            {
            id: "",
            alias: "",
            name: "",
            image_url: "",
            is_closed: false,
            url: "",
            review_count: 0,
            categories: [
                {
                    alias: "",
                    title: ""
                }
            ],
            rating: 0,
            coordinates: {
                latitude: 0,
                longitude: 0
            },
            transactions: [],
            price: "",
            location: {
                address1: "",
                address2: "",
                address3: "",
                city: "",
                zip_code: "",
                country: "",
                state: "",
                display_address: [
                    "",
                    ""
                    ]
            },
            phone: "",
            display_phone: "",
            distance: 0
         }]*/
        
        }
     
    },
    methods: {
        find() {
            RestaurantService.find(this.cityOrZip).then(response => {
            this.$store.commit("SET_QUERY_RESULTS", this.queryResults);
            this.queryResults = response.data;

            })
        }
    },
        created() {
        RestaurantService.find(this.cityOrZip).then(response => {
            this.queryResults = response.data;
        })
    },
    
    
    
}
</script>

<style scoped>

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
