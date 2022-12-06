<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>

      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>

      <label for="username" class="sr-only">Username</label>

      <input type="text"
        id="username"
        class="form-control"
        placeholder="Email"
        v-model="user.username"
        required
        autofocus/>

      <label for="password" class="sr-only">Password</label>
      <input type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required/>

      <label for="password">Confirm Password</label>
      <input type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required/>

      <router-link :to="{ name: 'login' }">Have an account?</router-link>

      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>

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
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
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

</style>
