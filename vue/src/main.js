import Vue from 'vue';
import App from './App.vue';
import router from './router/index';
import store from './store/index';
import axios from 'axios';
import moment from 'moment';
import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { faCalendarDays, faChampagneGlasses, faMapLocationDot, faPhone } from "@fortawesome/free-solid-svg-icons";
import { faCalendar } from '@fortawesome/free-regular-svg-icons';

library.add(faPhone);
library.add(faCalendarDays);
library.add(faCalendar);
library.add(faMapLocationDot);
library.add(faChampagneGlasses);

Vue.component('icon', FontAwesomeIcon);

Vue.config.productionTip = false;

Vue.prototype.moment = moment;


Vue.component('font-awesome-icon', FontAwesomeIcon);

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');
