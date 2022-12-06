<template>
 <body>
    <div id="find-restaurant">
        <h2 id="find-title">Find a Restaurant</h2>
        <form class="find-form" @submit="find">
            <input type="text" id="location" v-model="cityOrZip" placeholder="City or Zipcode" />
            <button type="button" id="submit-Button" v-on:click="find()">SUBMIT</button>
        </form>
        </div>
    </body>
</template>


<script>
import RestaurantService from "../services/RestaurantService"

export default {
    name: "findARestaurant",
    props:{},
    data() {
        return{
            cityOrZip:"",
            queryResults: [],
            /*********the info below should match the data yelp sends back OR our database ?**************** */
            
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
         }]
        
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
</style>

