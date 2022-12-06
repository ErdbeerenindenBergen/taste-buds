<template>
  <div id="app">
    <header>
      <div id="header-left">
        <img id="tb-logo" src="images\Taste-Buds.png" alt="taste-buds-logo"/>
        <h1 id="header-title">taste buds</h1>
      </div>  
      <nav>
        <router-link v-bind:to="{ name: 'find-a-restaurant' }">Find a Restaurant</router-link> |
        <router-link v-bind:to="{ name: 'invite-buds' }">Invite Buds</router-link> | 
        <router-link v-bind:to="{ name: 'events' }">Events</router-link> |
        <router-link v-bind:to="{ name: 'about' }">About</router-link> |
        <router-link v-bind:to="{ name: 'log-in' }">Log In</router-link> |
        <router-link v-bind:to="{ name: 'log-out' }" v-if="$store.state.token != ''">Logout</router-link>
      </nav>
    </header>
    <hr/>
    <router-view />
  </div>
</template>

<style>
#header-title{
  color:#434343;
  font-family:'Playfair Display';
  font-weight: normal;
  font-size: 3rem;
}

hr{
  color:#999999;
}

nav{
  color:#434343;
}

a{
  text-decoration: none;
  justify-content: space-evenly;
  font-family:'Playfair Display';
  font-weight: normal;
  font-size: 14px;
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