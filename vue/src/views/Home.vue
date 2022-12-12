<template>
  <div class="home">
    <h1>Home</h1>
    <p>You've logged in!</p>

  <div id='icons'>

    <div id="search">
      <a>
        <font-awesome-icon  icon="fa-brands fa-wpexplorer" id="search-icon"/>
        </a>
        <p>Discover new places</p>
    </div>

    <!-- <font-awesome-icon icon="fa-solid fa-earth-americas" /> -->
    <!-- <font-awesome-icon icon="fa-solid fa-panorama" /> -->
    <!-- <font-awesome-icon icon="fa-solid fa-kitchen-set" /> -->
    <!-- <font-awesome-icon icon="fa-solid fa-magnifying-glass" /> -->
    <!-- <font-awesome-icon icon="fa-regular fa-keyboard" /> -->

    <div id="plan">
        <a>
          <font-awesome-icon icon="fa-solid fa-calendar-days" id="plan-icon" />
        </a>
        <p>Plan an event</p>
    </div>

  </div>

  </div>
</template>

<script>
import fontawesome from "@fortawesome/fontawesome";
import brands from "@fortawesome/fontawesome-free-brands";
import solid from "@fortawesome/fontawesome-free-solid"; 

fontawesome.library.add(brands, solid);

export default {
  name: "home"
};
</script>

<style scoped>
h1{
  font-family: 'Playfair Display';
  font-weight: normal;
  text-align: center;
  padding-top: 40px;
}

#icons{
  display: flex;
  justify-content: space-evenly;
  padding-top:30px;
}

#plan, #search{
  display: flex;
  flex-direction: column;
}

#search-icon{
  color: gray;
  height:400px;
  width:auto;
}

#plan-icon{
  color: gray;
  height:400px;
  width:auto;
}

p{
  font-size: 25px;
  text-align: center;
  line-height: 5px;
  font-family:'Playfair Display';
  font-weight: normal;
  padding-right: 20px;
}

a.router-link-active{
  font-weight: bold;
}

@media screen and (max-width: 800px) and (min-width: 200px) {
  p{
  font-size: 20px;
  text-align: center;
  line-height: 5px;
  font-family:'Playfair Display';
  font-weight: normal;
  padding-right: 20px;
}
}

</style>