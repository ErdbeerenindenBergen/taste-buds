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
            queryResults: []
            /**below is where the yelp api json goes? */
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
