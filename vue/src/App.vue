<template>
  <div id="app">
    <div id="header-top">
      <header id="header">
        <link rel="preconnect" href="https://fonts.googleapis.com" /><link
          rel="preconnect"
          href="https://fonts.gstatic.com"
          crossorigin
        /><link
          href="https://fonts.googleapis.com/css2?family=Playfair+Display"
          rel="stylesheet"
        />
        <link
          rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
        />

        <div id="header-left">
         <router-link v-bind:to="{ name: 'home' }"><img
            id="tb-logo"
            src="../src/assets/Taste-Buds.png"
            alt="taste-buds-logo"
          />
          </router-link>

          <router-link v-bind:to="{ name: 'home' }">
          <h1 id="header-title">taste buds</h1>
          </router-link>
        </div>

        <nav id="myLinks" class="navbar">
          <ul class="nav-menu">
            <li class="nav-item">
              <router-link class="nav-link" v-bind:to="{ name: 'find' }"
                >Find restaurant</router-link
              >
            </li>
            <li class="nav-item">
              <router-link class="nav-link" v-bind:to="{ name: 'invite-buds' }"
                >Invite buds</router-link
              >
            </li>
            <li class="nav-item">
              <router-link class="nav-link"  v-bind:to="{ name: 'events' }"
                >Events</router-link
              >
            </li>
            <li class="nav-item">
              <router-link class="nav-link" :click="mobileMenu()" v-bind:to="{ name: 'about' }"
              >About</router-link> 
          </li>
            <li class="nav-item">
              <router-link
                class="nav-link"
                active-class="active"
                v-bind:to="{ name: 'log-in' }"
                v-if="$store.state.token === ''"
                >Log in</router-link
              >
              <router-link
                class="nav-link"
                v-bind:to="{ name: 'log-out' }"
                v-if="$store.state.token != ''"
                >Log out</router-link
              >
            </li>
          </ul>
        </nav>

        <div
          id="hamburger"
          class="hamburger"
          v-on:click="mobileMenu()"
        >

        <!-- v-on:click="mobileMenu(), (userProfileMenuIsOpen = true)" -->


          <span class="bar"></span>
          <span class="bar"></span>
          <span class="bar"></span>
        </div>
      </header>

      <div class="background-white">
        <div id="header-padding-top" class="background-white"></div>
        <hr />
        <div id="header-padding" class="background-white"></div>
      </div>
    </div>

    <router-view />
  </div>
</template>

<script>
export default {
  name: "Timer",
  data() {
    return {
      fixed: false,
      userProfileMenuIsOpen: false, // Default to 'false'!
    };
  },
  methods: {
    mobileMenu() {
      let hamburger = document.querySelector(".hamburger");
      let navMenu = document.querySelector(".nav-menu");
      hamburger.classList.toggle("active");
      navMenu.classList.toggle("active");
    },
    turnOffFindView() {
      let targetDiv = document.getElementById("find");
      if (targetDiv.style.display !== "none") {
        targetDiv.style.display = "none";
      } else {
        targetDiv.style.display = "flex";
        targetDiv.style.position = "fix";
        targetDiv.style.justifyContent = "center";
        targetDiv.style.alignContent = "center";
      }
    },
    doNotDisplayHamburgerMenu() {
      let hamburger = document.querySelector(".hamburger");
      let navMenu = document.querySelector(".nav-menu");
      hamburger.classList.toggle("active");
      navMenu.classList.toggle("active");
    }
  },
};
</script>


<style>
@import url("https://fonts.googleapis.com/css2?family=Playfair+Display");

.hamburger {
  display: none;
  margin: 15px;
}

.bar {
  display: block;
  width: 45px;
  height: 3px;
  margin: 15px auto;
  -webkit-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
  background-color: #666666;
}

li {
  list-style: none;
}

a {
  text-decoration: none;
}

.nav-menu,
.nav-link {
  display: flex;
  flex-direction: row;
  background: none;
  z-index: 99;
}

#app {
  padding-top: 100px;
}

#tb-logo {
  padding-left: 5px;
  height: 60px;
  width: auto;
  margin: auto;
}

#header-top {
  width: 100%;
  position: fixed;
  top: 0px;
}

#header-title {
  color: #434343;
  font-family: "Playfair Display", serif;
  font-weight: medium;
  font-size: 4rem;
  min-width: 20px;
  line-height: 13px;
}

#header-padding-top {
  padding-top: 3px;
  line-height: 0px;
}

#header-padding {
  padding-bottom: 3px;
  line-height: 3px;
}

a.router-link-active {
  font-weight: bold;
}

hr {
  color: #999999;
  margin-left: 20px;
  margin-right: 35px;
  background: #999999;
  margin-bottom: 20px;
}

#background {
  background: white;
}

.background-white {
  background: white;
}

header {
  margin: 0px 10px 0px 10px;
  background: white;
  padding-top: 5px;
}

header,
#header-left {
  display: flex;
}

nav {
  display: flex;
  justify-content: flex-end;
}

#header-left {
  display: inline-flex;
  justify-content: flex-start;
}

nav {
  color: #434343;
  flex-grow: 1;
  display: flex;
  flex-direction: row;
  margin: auto;
  padding: 20px 10px 0 0px;
}

a {
  text-decoration: none;
  justify-content: space-evenly;
  display: flex;
  flex-direction: row;
  font-family: "Playfair Display";
  font-weight: normal;
  font-size: 22px;
  color: #434343;
  padding-right: 20px;
}

a:link,
a:visited,
a:hover {
  color: #434343;
  font-family: "Playfair Display";
  font-weight: normal;
}

a:hover {
  font-weight: bold;
}

#header-title{
  padding-left:3px;
}


@media screen and (max-width: 800px) and (min-width: 200px) {
  #header-title {
    font-size: 40px;
    margin: 3px;
    justify-content: center;
    align-items: center;
    margin: auto;
    margin-left: 0px;
    margin-top: 35px;
    padding-left: 0px;
  }

  hr {
    margin-bottom: 0px;
  }

  .bar {
    margin: 10px;
    width: 30px;
  }

  header {
    padding: 0px;
    margin: 0px;
  }

  #header-padding {
    padding: 0px;
    line-height: 0px;
  }

  .hamburger {
    display: block;
    padding-right: 8px;
  }

  li.nav-item {
    margin: 5px;
  }

  #tb-logo {
    padding-left: 15px;
    height: 45px;
    width: auto;
    margin: auto;
    margin-right:0px;
  }

  #router-link{
    padding-left:none;
    margin-left: none;
  }

  ul{
    padding-left:0px;
  }

}

@media screen and (max-width: 1200px) {
  .nav-menu {
    position: fixed;
    left: -100%;
    top: 120px;
    flex-direction: column;
    width: 100%;
    border-radius: 10px;
    text-align: center;
    transition: 0.3s;
    z-index: 999999999999 !important;
  }

  .nav-menu.active {
    left: 0;
    background: white;
    box-shadow: 0 10px 27px rgba(0, 0, 0, 0.05);
  }

  li.nav-item {
    margin: 5px;
  }

  .hamburger {
    display: block;
    cursor: pointer;
    margin-right:26px;
  
  }
}
</style>