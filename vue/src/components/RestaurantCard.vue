<template>
    <div id="root">


      
           
            <!-- <img v-if="business.image_url" :src="this.business.image_url" class="thumbnail"> --> -->
            <div v-for='business in business' :key='business.id'>
            <h2 id='name'>{{ business.name }}</h2>
            <h2 id='url'>{{ business.url }}</h2>
            <!-- <h2 id='title'>{{ business.restaurantList.categories[1].title }}</h2> -->
            <h2 id='stars'>{{ business.rating }}</h2>
            <h2 id='isClosed'>{{ business.is_closed === false ? "Open now" : "Closed" }}</h2>
            <!-- <p class="address">{{business.location[7]}}</p> -->
            </div>
        

        <div id="phone-button">
            <a href="tel:${business.restaurantList.phoneNumber}" target="_blank"><button class="call-button" type="button call">Call to Order</button></a>
        </div>

    </div>
</template>

<script>

//import RestaurantService from '../services/RestaurantService'
import restaurants from '../views/Restaurants.vue'

export default {
    name :'restaurant-card',
    props: {
        business: [],
        restaurants
    },
     /*data() {
         return {
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
        
         }*/
    
        
}
</script>

<style scoped>

</style>


