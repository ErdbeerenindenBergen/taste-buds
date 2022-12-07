<template>
    <div id="root">
        <div id="main-info">
           
            <img v-if="restaurant.image_url" :src="restaurant.businesses.image_url" class="thumbnail">
        
            <h2 id='name'>{{ restaurant.businesses.name }}</h2>
            <h2 id='title'>{{ restaurant.businesses.categories[1].title }}</h2>
            <h2 id='name'>{{ restaurant.businesses.rating }}</h2>
            <h2 id='name'>{{ restaurant.businesses.is_closed === false ? "Open now" : "Closed" }}</h2>
            <p class="address">{{restaurant.businesses.location.display_address}}</p>
        
        </div>

        <div id="phone-button">
            <a href="tel:${restaurant.businesses.phone}" target="_blank"><button class="call-button" type="button call">Call to Order</button></a>
        </div>

    </div>
</template>

<script>

export default {
    name :'restaurant-card',
    props: {
        restaurant: Object
    },
    data() {
        return {
            location:"",
            queryResults: []
        }
    },
    methods: {

    }
        
}
</script>

<style scoped>

</style>


