<template>
    <div id="root">

      <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Playfair+Display" rel="stylesheet">
           
            <!-- <img v-if="business.image_url" :src="this.business.image_url" class="thumbnail"> -->
            <div id="restaurant-display" v-for='business in business' :key='business.id'>
                
                <div id="restaurant-left">
                    <h2 id='name'>{{ business.name }}</h2>
                
                    <img v-if="business.image_url != ''" :src="business.image_url" class="thumbnail"/>
                
                    <div id="icon-links">
                        <a id='url' href="`${business.url}`" >
                            <img id="yelp-icon" src="@/assets/yelp.png" alt="yelp-icon" class="yelp-icon"/>
                        </a>
                    </div>
                </div>
                
                <div id="restaurant-right">
                    
                    <!-- <h2 id='title'>{{ business.restaurantList.categories[1].title }}</h2> -->
                    <h2 id='stars'>Average rating: {{ business.rating }}</h2>
                    <h2 id='isClosed'>{{ business.is_closed === false ? "Open now" : "Closed" }}</h2>
                    <p id="contacts">{{ business.phone}}</p>
                
                    <div id="phone-button">
                        <a href="tel:${business.phone}" target="_blank"><button class="call-button" type="button call">Call to Order</button></a>
                        <!-- <p class="address">{{business.location[7]}}</p> -->   
                    </div>
                </div>

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
}

</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display');

#restaurant-display{
    font-family: 'Playfair Display';
    border: 1px solid #999999;
    margin: 20px 0 10px 0;
    padding: 0 10px 0 10px;
    text-align: center;
    font-weight: normal;
    display: flex;
    justify-content: space-evenly;
}

#restaurant-left{
    display: flex;
    flex-direction: column;
}

#restaurant-right{
    display: flex;
    flex-direction: column;
    flex: grow;
    width: 70%;
}

.call-button{
background-color: #a64d79ff;
  color: white;
  border:none;
  text-decoration: none;
  font-size:15px;
  font-weight: bold;
  border-radius: 10px;
  width: 10%;
  padding: 12px 12px;
  margin-bottom: 20px;
}

.thumbnail{
    height:400px;
    width:auto;
    object-fit: cover;
}

#yelp-icon{
    height: 40px;
    margin: 10px;
}

p{
    font-size: 22px;
}

</style>


