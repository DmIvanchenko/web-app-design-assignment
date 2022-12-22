<template>
  <main class="form-signin">
    <form @submit.prevent="submit">
      <div class="col-12 text-center">
        <h3 class="pt-3">Sign up</h3>
      </div>
      <div class="form-floating">
        <input class="form-control" name="firstname" placeholder="First name">
        <label>First name</label>
      </div>

      <div class="form-floating">
        <input class="form-control" name="lastname" placeholder="Last name">
        <label>Last name</label>
      </div>

      <div class="form-floating">
        <input type="email" class="form-control" name="email" placeholder="name@example.com">
        <label>Email address</label>
      </div>

      <div class="form-floating">
        <input type="password" class="form-control" name="password" placeholder="Password">
        <label>Password</label>
      </div>

      <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
    </form>
  </main>
</template>

<script>
import axios from "axios";
import {useRouter} from "vue-router"
export default {
  name: "SignUp",
  setup(){
    const router = useRouter();
    const submit = async e =>{
      const form = new FormData(e.target);
      const inputs = Object.fromEntries(form.entries());
      await axios.post('users', inputs);
      await router.push('/login');
    }
    return{
      submit
    }
  }

}
</script>

<style scoped>

</style>