<template>

  <div id="app">

    <header>
      <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Playfair+Display" rel="stylesheet">
      <div id="header-left">
        <img id="tb-logo" src="../src/assets/Taste-Buds.png" alt="taste-buds-logo"/>
        <h1 id="header-title">taste buds</h1>
      </div>  

      <nav>
        <router-link class="with-bar" v-bind:to="{ name: 'find-a-restaurant' }">Find restaurant</router-link> 
        <router-link class="with-bar" v-bind:to="{ name: 'invite-buds' }">Invite buds</router-link>  
        <router-link class="with-bar" v-bind:to="{ name: 'events' }">Events</router-link> 
        <router-link class="with-bar" v-bind:to="{ name: 'about' }">About</router-link> 
        <router-link active-class="active" v-bind:to="{ name: 'log-in'}" >Log in</router-link>
        <router-link v-bind:to="{ name: 'log-out' }" v-if="$store.state.token != ''">Log out</router-link>
      </nav>

    </header>

    <hr/>
    <router-view />
  </div>
</template>

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

hr {
  color:#999999;
  margin-left: 2rem; 
  margin-right: 2rem;
}

header {
  margin: 5px 10px 5px 10px;
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

@media (max-width: 1090px) {


}

</style>