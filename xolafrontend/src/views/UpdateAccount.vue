<template>
  <main class="form-signin">
    <form @submit.prevent="submit">
      <h1 class="h3 mb-3 fw-normal">Update your account</h1>

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

      <button class="w-100 btn btn-lg btn-primary" type="submit">Save</button>
    </form>
  </main>
</template>

<script>
import axios from "axios";
import {useRouter} from "vue-router"
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "UpdateAccount",
  setup(){
    const router = useRouter();
    const submit = async e =>{
      const form = new FormData(e.target);
      const inputs = Object.fromEntries(form.entries());

      const {data} = await axios.put('users', inputs, {
        withCredentials:true
      });
      axios.defaults.headers.common['Authorization'] = `Bearer ${data.token}`;

      await router.push('http://localhost:8081/dashboard');
    }
    return{
      submit,
    }
  }
}
</script>

<style scoped>

</style>