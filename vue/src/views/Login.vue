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
        placeholder="Email"
        v-model="user.username"
        required
        autofocus/>
        <br/>

      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required/>

      <br/>
      <br/>
      <button id="login-button" type="submit">LOG IN</button>

      <p>New to taste buds?</p>
      <router-link :to="{name:'register'}" class="register-link">Sign up here.</router-link>
      <!-- <a class="register-link" href="../src/views/Register.vue">Sign up here.</a> -->

    </form>
    
  </body>
  
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "log-in",
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
            console.log(response.data.user);
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

h1 {
  padding-top: 120px;
  font-size: 48px;
}

h2 {
  font-size: 35px;
  padding-top: 7px;
}

h1,h2 {
  text-align: center;
  line-height: 5px;
  font-family:'Playfair Display';
  font-weight: normal;
}

p{
  text-align: center;
  display: flex;
  font-family:'Playfair Display', serif;
  font-weight: normal;
  font-size:25px;
  margin-bottom: 10px;
}

a.register-link{
  display: flex;
  color:#a64d79ff;
  font-size:25px;
  font-weight: bold;
}

form.form-signin{
  order: 2;
  justify-content: center;
  display: flex;
  flex-direction: column;
  align-items: center;
}

input.form-control {
  width: 30%;
  font-family: 'Playfair Display';
  padding: 10px 15px;
  border: 2px solid #b7b7b7;
  border-radius: 10px;
  font-size: 22px;
  text-align: center;
}

input.form-control:focus {
  border: 2px solid #666666;
}

#login-button{
  background-color: #a64d79ff;
  color: white;
  border:none;
  justify-content: center;
  text-decoration: none;
  display: flex;
  font-size: 22px;
  font-family: 'Playfair Display';
  font-weight: bold;
  border-radius: 10px;
  width: 10%;
  padding: 10px 15px;
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

.alert{
font-size: 22px;
padding-bottom: 10px;
}

a.router-link-active{
  font-weight: bold;
}


/* SCREEN DIFFERENCES */
@media screen and (max-width: 400px) {
  body {
      display:flex;
      flex-direction: column;
  }

  h1{
    font-size:30px;
    padding-top:0px;
  }

  h2{
    font-size:16px;
  }
  
  input.form-control{
    width: 50%;
  }

  #login-button{
  font-size: 20px;
  border-radius: 10px;
  width: 40%;
  }
    
}
@media screen and (max-width: 800px) and (min-width: 400px) {
  body {
    display:flex;
    flex-direction: column;
  }
  
}
</style>