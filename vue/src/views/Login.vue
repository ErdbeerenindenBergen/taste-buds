<template> 
 <body>
   <form class="form-signin" @submit.prevent="login">
      <h1>Welcome to taste buds</h1>
      <h2>where the first bite could change your life.</h2>
      <br/>
      <br/>
      
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials">
        Invalid username and password!
        </div>

      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>

      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="email"
        v-model="user.username"
        required
        autofocus/>
        <br/>

      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="password"
        v-model="user.password"
        required/>

      <br/>
      <br/>
      <button id="login-button" type="submit">LOG IN</button>

      <p>New to taste buds? Sign up <a class="register-link" href="../view/register.vue">here</a>.
      </p>

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
  color: #666666;
  background-color: white;
  font-family:'Playfair Display';
  font-weight: normal;
}

h1,h2 {
  text-align: center;
  line-height: 5px;
  font-family:'Playfair Display';
  font-weight: normal;
}

p{
  text-align: center;
  font-family:'Playfair Display';
  font-weight: normal;
  font-size:18px;
  
}

.register-link{
  color:#a64d79ff;
  font-size:18px;
  font-weight: bold;
  
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
  border: 2px solid #999999;
  border-radius: 10px;
  font-size: 16px;
  text-align: center;
}

input.form-control:focus {
  border: 2px solid black;
}

#login-button{
  background-color: #a64d79ff;
  color: white;
  border:none;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size:15px;
  font-weight: bold;
  border-radius: 12px;
  width: 80%;
  padding: 12px;
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