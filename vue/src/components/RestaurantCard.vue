<template>
    <div id="root">

      <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Playfair+Display" rel="stylesheet">
           
            <div id="restaurant-display" v-for='business in business' :key='business.id'>
                
                <div id="restaurant-left">
                    <h2 id='name'>{{ business.name }}</h2>
                
                    <img v-if="business.image_url != ''" :src="business.image_url" class="thumbnail"/>
                
                    <div id="icons">
                        <div id="yelp-icon-link">
                            <a id='url' :href="`${business.url}`" target="_blank">
                                <img id="yelp-icon" src="@/assets/yelp.png" alt="yelp-icon" class="zoom"/>
                            </a>
                        </div>

                        <div id="google-icon-link">
                            <a id='url' :href="'http://maps.google.com/?q=' + `${business.name}` + `${business.location.display_address[0]}`" target="_blank">
                                <img id="google-icon" src="@/assets/google-maps.png" alt="google-maps-icon" class="zoom"/>
                            </a>
                        </div>

                        <div id="purple-heart-icon-link">
                            <button type="button" @click="created() ? addToFavorites() : $router.push('/log-in')"><img src="@/assets/purple-heart-icon.png" alt="purple-icon" id="purple-heart-icon" class="zoom"/></button>
                        </div>

                    </div>

                </div>
                
                <div id="restaurant-right">

                    <h2 id='stars'>Average rating: {{ business.rating }}</h2>
                    <h2 id='isClosed'>{{ business.is_closed === false ? "Open now" : "Closed" }}</h2>

                    <div id='contact-information'>
                        <p id="contacts">{{ business.display_phone}}</p>
                        <p id="address1">{{ business.location.display_address[0]}}</p>
                        <p id="address2">{{ business.location.display_address[1]}}</p>
                    </div>

                    <div id='pickup-or-delivery'>
                        <p id="pickup">{{ business.transactions.includes("pickup") ? "Pick-up is available" : "" }}</p>
                        <p id="delivery">{{ business.transactions.includes("delivery") ? "Delivery is available" : "" }}</p>
                        </div>
                
                    <div id="phone-button">
                        <a href="tel:${business.phone}" target="_blank"><button class="call-button" type="button call">CALL TO ORDER</button></a>
                        <!-- <p class="address">{{business.location[7]}}</p> -->   
                    </div>
                </div>

            </div>

    </div>
</template>

<script>

import InviteService from '../services/InviteService';

export default {
    name :'restaurant-card',
    props: {
        business : Object,
    },
    data() {
        return {
        eventOrganizerId: "",
        }
     },
    methods: {
        addToFavorites() {
            const favorite = {
                restaurantId: this.favRestaurants.restaurantId,
                inviteId: this.favRestaurants.inviteId,
                eventId: this.favRestaurants.eventId,
                business: Object
            };
            InviteService.createFavorites(favorite).then(response => {
              this.invitation.inviteId = response.data;
              this.$store.commit("SET_FAVORITES_LIST", response.data);
          })

        },
        created() {
            this.eventOrganizerId = this.$store.state.user.id;
        }
    
    }
}

</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display');

#restaurant-display{
    font-family: 'Playfair Display';
    font-size: 20px;
    /* border: 1px solid #999999; */
    border-radius: 10px;
    margin: 20px 0 10px 0;
    padding: 0 30px 0 30px;
    text-align: center;
    font-weight: normal;
    display: flex;
    background:#f0efef;
    flex: grow;
}

#restaurant-left{
    display: flex;
    flex-direction: column;
    flex: grow;
    width: 50%;
    justify-content: center;
    text-align: center;
}

#restaurant-right{
    display: flex;
    flex-direction: column;
    flex: grow;
    width: 50%;
    justify-content: center;
    text-align: center;
}

.call-button{
background-color: #a64d79ff;
  color: white;
  border:none;
  text-decoration: none;
  font-size:15px;
  font-weight: bold;
  border-radius: 10px;
  width: 150px;
  padding: 12px 12px;
  margin-bottom: 20px;
}

.thumbnail{
    float: left;
    height:400px;
    width: 400px;
    object-fit: cover;
    border-radius:10px;
    margin:auto;
}

#icons{
    display: flex;
    justify-content: center;
}

#yelp-icon{
    height: 40px;
    margin: 10px;
}

#google-icon{
    height: 40px;
    margin: 10px;
}

#purple-heart-icon{
    height: 40px;
    margin: 10px;
    border: 0px;
    text-decoration: none;
}

p{
    font-size: 25px;
    font-family: Montserrat;
}

button:focus{
    background: #e06666;
}

button:hover{
  background:#741b47ff;
}

.zoom:hover{
  transform: scale(1.2);
  transition: all ease 500ms;
}

@media screen and (max-width: 1350px) {

    .thumbnail{
    margin: auto;
    height:300px;
    width: 300px;
    }
    #restaurant-right {
    justify-content: center;
    margin: auto;
    }
    #restaurant-left {
    justify-content: center;
    margin: auto;
    }
}

@media screen and (max-width: 1200px) {
    #root{
    padding-top: 100px;
    }
}

@media screen and (max-width: 970px) {
    #restaurant-display {
    flex-direction: column;
    }

    #root{
    padding-top: 100px;
    }

    .thumbnail{
    float: left;
    height:225px;
    width: 225px;
    object-fit: cover;
    border-radius:10px;
    justify-content: center;
    /* margin: auto; */
    }
    #restaurant-display {
    flex:grow;
    justify-content: center;
    padding: 0 30px 0 30px;
    }

}
</style>




