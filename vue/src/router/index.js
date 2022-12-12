import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Restaurant from '../views/Restaurants.vue'
import Invite from '../views/InviteBuds.vue'
import Events from '../views/Events.vue'
import About from '../views/About.vue'
import InviteOptions from '../views/InviteOptions.vue'
import InviteBuds from '../views/InviteOptions.vue'


Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/log-in",
      name: "log-in",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/log-out",
      name: "log-out",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/find",
      name: "find",
      component: Restaurant,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/invite-buds",
      name: "invite-buds",
      component: Invite,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/invite-options/:id',
      name: 'invite-options',
      component: InviteOptions,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/events",
      name: "events",
      component: Events,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/about",
      name: "about",
      component: About,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/event/create',
      name: 'create-event',
      component: InviteBuds,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/invitation/create',
      name: 'create-invitation',
      component: InviteBuds,
      meta: {
        requiresAuth: true
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/log-in");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
