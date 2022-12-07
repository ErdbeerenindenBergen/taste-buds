<template>
    <div id="root">
        <div id="main-info">
            <img v-if="restaurant.image_url" :src="restaurant.businesses.image_url" class="thumbnail">
        
            <h2 id='name'>{{ restaurant.businesses.name }}</h2>
            <h2 id='title'>{{ restaurant.businesses.categories[1].title }}</h2>
            <h2 id='name'>{{ restaurant.businesses.rating }}</h2>
            <h2 id='name'>{{ restaurant.businesses.is_closed }}</h2>
                
                <p v-if="restaurant.location.address1" class="address display">{{restaurant.location.address1}}</p>
                <p v-if="restaurant.location.address2" class="address display">{{ restaurant.location.address2}}</p>
                <p v-if="restaurant.location.address3" class="address display">{{ restaurant.location.address3}}</p>
        </div>

        <div id="button-info">
            <a href="tel:${restaurant.businesses.display_phone}" target="_blank"><button class="call-button" type="button call">Call to Order</button></a>
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
            cityOrZip:"",
            queryResults: []
        }
    },
    methods: {

    }
        
}
</script>

<style scoped>

</style>


