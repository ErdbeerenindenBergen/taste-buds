<template>
  <div class="home">
    <h1>Home</h1>
    <p>You've logged in!</p>
  </div>
</template>

<script>
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