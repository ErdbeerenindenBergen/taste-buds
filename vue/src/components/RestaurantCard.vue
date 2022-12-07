<template>
    <div id="root">
        <div id="main-info">
           
            <img v-if="restaurant.image_url" :src="this.business.thumbnailImageURL" class="thumbnail"> -->
        
            <h2 id='name'>{{ this.business.restaurantName }}</h2>
            <h2 id='url'>{{ this.business.url }}</h2>
            <!-- <h2 id='title'>{{ business.restaurantList.categories[1].title }}</h2> -->
            <h2 id='stars'>{{ this.business.stars }}</h2>
            <h2 id='isClosed'>{{ this.business.isClosed === false ? "Open now" : "Closed" }}</h2>
            <p class="address">{{this.business.restaurantAddress}}</p>
        
        </div>

        <div id="phone-button">
            <a href="tel:${business.restaurantList.phoneNumber}" target="_blank"><button class="call-button" type="button call">Call to Order</button></a>
        </div>

    </div>
</template>

<script>

export default {
    name :'restaurant-card',
    props: {
        business: Object
    },
    // data() {
    //     return {
    //         location:"",
    //         restaurantList: []
    //     }
    // },
    // methods: {
        
    // }
        
}
</script>

<style scoped>

</style>


