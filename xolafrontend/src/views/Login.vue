<template>
  <main class="form-signin">
    <form @submit.prevent="login">
      <div class="col-12 text-center">
        <h3 class="pt-3">Sign in</h3>
      </div>
      <div class="form-floating">
        <input type="email" class="form-control" name="userName" placeholder="name@example.com">
        <label>Email</label>
      </div>

      <div class="form-floating">
        <input type="password" class="form-control" name="password" placeholder="Password">
        <label>Password</label>
      </div>

      <button class="w-100 btn btn-primary" type="submit">Submit</button>
    </form>
  </main>
</template>

<script>


import axios from "axios";
import {useRouter} from "vue-router"
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Login",
  data() {
    return {
      userName: '',
      password: ''
    }
  },
  methods: {
    login() {
      // Send a request to the server to authenticate the user
      // with the provided email and password
      const router = useRouter();
      axios.post('http://localhost:8080/login', {
        userName: this.userName,
        password: this.password
      })
          .then(response => {
            // If the login is successful, store the JWT in local storage
            localStorage.setItem('jwt', response.data.token)
            // Redirect the user to the protected route
            router.push('dashboard')
          })
          .catch(error => {
            // If there was an error, show an alert
            alert(error.response.data.message)
          })
    }
  }
}
</script>

<style scoped>

</style>