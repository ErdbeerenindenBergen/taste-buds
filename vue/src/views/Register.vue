<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h3 class="h3 mb-3 font-weight-normal">Create Account</h3>

      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>

      <div class="input">
      <label for="username" class="sr-only"></label>
      <input type="text"
        id="username"
        class="form-control"
        placeholder="Email"
        v-model="user.username"
        required
        autofocus/>
        </div>

        <br>
      <div class="input">
      <label for="password" class="sr-only"></label>
      <input type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required/>
        </div>
        <br>
      

      <div class="input">
      <label for="password"></label>
      <input type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required/>
        </div>

      <div id="create">
      <button id="create-account-button" class="btn btn-lg btn-primary btn-block" type="submit">Create Account</button>
      </div>

      <router-link :to="{ name: 'log-in' }">Have an account already? Log in.</router-link>
      <br>



    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
        /**---------------Adding password data rules--------------*/ 
        //rules: 8 characters, uppercase, lowercase, number, special characters
        required_characters: false
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      /**------------Setting Logic for Password Rules------------*/
      
      this.required_characters = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/.test(this.user.password);

      if (this.required_characters === false) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password must be a minimum of 8 characters ~ Must have at least 1 uppercase ~ Must have at least one number ~ Must have at least 1 special character. "
      } else if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/log-in',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'The username already exists. Pick another one.';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>
body{
  color: #666666;
  background-color: white;
  font-family:'Playfair Display';
  font-weight: normal;
}

h3 {
  font-size: 32px;
  padding-top: 130px;
  padding-bottom: 30px;
  text-align: center;
  line-height: 5px;
  font-family:'Playfair Display';
  font-weight: normal;
}

input{
  display: flex;
  padding-bottom: 40px;
  align-content: center;
  justify-content: center;
  text-align: center;
}

.input{
  display: flex;
  justify-content: center;
  align-content: center;
}

.register-link{
  display: flex;
  color:#a64d79ff;
  font-size:25px;
  font-weight: bold;
}

input.form-control {
  width: 30%;
  font-family: 'Playfair Display';
  padding: 10px 15px;
  border: 2px solid #b7b7b7;
  border-radius: 10px;
  font-size: 22px;
  text-align: center;
  align-content: center;
}

input.form-control:focus {
  border: 2px solid #666666;
}

#create-account-button{
  background-color: #a64d79ff;
  color: white;
  border:none;
  text-decoration: none;
  font-size: 22px;
  font-family: 'Playfair Display';
  font-weight: bold;
  border-radius: 10px;
  width: 20%;
  padding: 10px 15px;
}

button.submit:hover {
  background-color: plum;
  color: white;
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}

a.router-link-active{
  font-weight: bold;
}

button{
  display: flex;
  align-items: center;
  justify-content: center;
}

#create{
  display: flex;
  align-items: center;
  text-align: center;
  justify-content: center;
  padding-top: 20px;
  padding-bottom: 20px;
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
