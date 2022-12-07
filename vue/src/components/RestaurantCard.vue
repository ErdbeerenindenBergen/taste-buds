<template>
    <div id="root">

<p>
    {{business[0].url}}
</p>

        <!-- <div id="main-info">
           
            <img v-if="business.thumbnailImageURL" :src="this.business.thumbnailImageURL" class="thumbnail">
        
            <h2 id='name'>{{ business.restaurantName }}</h2>
            <h2 id='url'>{{ business.url }}</h2>
             <h2 id='title'>{{ business.restaurantList.categories[1].title }}</h2>
            <h2 id='stars'>{{ business.stars }}</h2>
            <h2 id='isClosed'>{{ business.isClosed === false ? "Open now" : "Closed" }}</h2>
            <p class="address">{{business.restaurantAddress}}</p>
        
        </div>

        <div id="phone-button">
            <a href="tel:${business.restaurantList.phoneNumber}" target="_blank"><button class="call-button" type="button call">Call to Order</button></a>
        </div> -->

    </div>
</template>

<script>

export default {
    name :'restaurant-card',
    props: {
        business: []
    }
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


