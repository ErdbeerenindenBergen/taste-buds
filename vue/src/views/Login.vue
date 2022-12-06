<template> 
 <body>
  <form class="form-signin" @submit.prevent="login">
    <!---------- consider breaking this intro into h2 tag to style or do it inline --------->
      <h1>welcome to taste buds<br/>where the first bite could change your life</h1>
      
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Email</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Sign in</button>
    </form>
  </body>
  
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          alert(error);
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>


 <style scoped>
body{
  background-color: rgb(255, 255, 235);
  display: flex;
  flex-direction: row;
  flex-grow: 1;
  justify-content: space-between;
  gap: 25px;
  
  /* original color: rgba(255, 255, 221, 0.867); */
}


h1 {
  text-align: center;
}

form.form-signin{
  order: 2;
  flex-basis: 33%;
  justify-content: center;
  display: flex;
  flex-direction: column;
  align-items: center;
}
input.form-control {
  width: 80%;
  padding: 10px 15px;
  border: 3px solid lightgray;
  border-radius: 10px;
  font-size: 16px;
}
input.form-control:focus {
  border: 3px solid black;
}
button.submit {
  border: none;
  background-color: rgb(243, 214, 243);
  font-size: 20px;
  border-radius: 25px;
  width: 250px;
  padding: 12px 32px;
}
button.submit:hover {
  background-color: plum;
  color: white;
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}
/* SCREEN DIFFERENCES */
@media screen and (max-width: 400px) {
  body {
      display:flex;
      flex-direction: column;
    }
  
    
}
@media screen and (max-width: 800px) and (min-width: 400px) {
  body {
    display:flex;
    flex-direction: column;
  }
  
}
</style>