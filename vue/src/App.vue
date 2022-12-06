<template>

  <div id="app">

    <header>
      <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Playfair+Display" rel="stylesheet">
      <div id="header-left">
        <img id="tb-logo" src="../src/assets/img/Taste-Buds.png" alt="taste-buds-logo"/>
        <h1 id="header-title">taste buds</h1>
      </div>  

      <nav>
        <router-link v-bind:to="{ name: 'find-a-restaurant' }">Find a Restaurant</router-link> |
        <router-link v-bind:to="{ name: 'invite-buds' }">Invite Buds</router-link> | 
        <router-link v-bind:to="{ name: 'events' }">Events</router-link> |
        <router-link v-bind:to="{ name: 'about' }">About</router-link> |
        <router-link v-bind:to="{ name: 'log-in' }">Log In</router-link>
        <router-link v-bind:to="{ name: 'log-out' }" v-if="$store.state.token != ''">Logout</router-link>
      </nav>

    </header>

    <hr/>
    <router-view />
  </div>
</template>

<style>
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display');

#tb-logo {
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
  padding-right: 20px;
  min-width: 80px;
  line-height: 13px;
}

hr {
  color:#999999;
}

header {
    margin: 5px 10px 5px 10px;
}

header, #header-left, nav {
    display: flex;
    justify-content: flex-end;
}

nav {
  color:#434343;
  flex-grow: 1;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  margin: auto;
  padding: 20px 0 0 0;
}

a{
  text-decoration: none;
  justify-content: space-evenly;
  font-family:'Playfair Display';
  font-weight: normal;
  font-size: 22px;
  color:#434343;
}

a:link,a:visited,a:hover{
  color:#434343;
  font-family:'Playfair Display';
  font-weight: normal;
}

a:active{
  color:#434343;
  font-family:'Playfair Display';
  font-weight: bold;
  
}

</style>

@media (max-width: 800px) {



}