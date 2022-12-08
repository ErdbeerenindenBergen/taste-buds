<template>

  <div id="app">
  <scroll-fixed-header :fixed.sync="fixed" :threshold="56">
    <header id="header">

      <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Playfair+Display" rel="stylesheet">
      
      <div id="header-left">
        <img id="tb-logo" src="../src/assets/Taste-Buds.png" alt="taste-buds-logo"/>
        <h1 id="header-title">taste buds</h1>
      </div>  

      <nav>
        <router-link class="with-bar" v-bind:to="{ name: 'find' }">Find restaurant</router-link> 
        <router-link class="with-bar" v-bind:to="{ name: 'invite-buds' }">Invite buds</router-link>  
        <router-link class="with-bar" v-bind:to="{ name: 'events' }">Events</router-link> 
        <router-link class="with-bar" v-bind:to="{ name: 'about' }">About</router-link> 
        <router-link active-class="active" v-bind:to="{ name: 'log-in'}" v-if="$store.state.token === ''" >Log in</router-link>
        <router-link v-bind:to="{ name: 'log-out' }" v-if="$store.state.token != ''">Log out</router-link>
      </nav>
      

    </header>

    <div class="background-white">
      <div id="header-padding-top" class="background-white">
        </div>
      <hr/>
      <div id="header-padding" class="background-white">
        </div>
    </div>
    
  </scroll-fixed-header>
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'Timer',
  data() {
    return {
      fixed: false,
    };
  },
};
</script>


<style>
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display');

#tb-logo {
  padding-left: 10px;
    height: 60px;
    width: auto;
    margin: auto;
}

#header-title{
  color:#434343;
  font-family: 'Playfair Display', serif;
  font-weight: medium;
  font-size: 4rem;
  padding-left: 20px;
  /* padding-right: 450px; */
  min-width: 20px;
  line-height: 13px;
}

#header-padding-top{
  padding-top: 3px;
  line-height: 0px;
}

#header-padding{
  padding-bottom: 3px;
  line-height: 3px;
}

a.router-link-active{
  font-weight: bold;
}

hr {
  color:#999999;
  margin-left: 2rem; 
  margin-right: 2rem;
  background: white;
  margin-bottom: 20px;
}

#background{
  background: white;
}

.background-white{
  background: white;
}

header {
  margin: 0px 10px 0px 10px;
  background:white;
  padding-top: 5px;
}

header, #header-left, nav{
  display: flex;
  justify-content: flex-end;
}

#header-left {
  display: inline-flex;
  justify-content: flex-start;
}

nav {
  color:#434343;
  flex-grow: 1;
  display: flex;
  flex-direction: row;
  margin: auto;
  padding: 20px 10px 0 0px;
}

.with-bar{
border-right: solid 2px;
border-color:#666666;
}

a{
  text-decoration: none;
  justify-content: space-evenly;
  display: flex;
  flex-direction: row;
  font-family:'Playfair Display';
  font-weight: normal;
  font-size: 22px;
  color:#434343;
  padding-left: 20px;
  padding-right: 20px;
}

a:link,a:visited,a:hover{
  color:#434343;
  font-family:'Playfair Display';
  font-weight: normal;
}

a:hover{
  font-weight: bold;
}

</style>