<template>
  <main class="form-signin">
    <form @submit.prevent="submit">
      <div class="col-12 text-center">
        <h3 class="pt-3">Edit room</h3>
      </div>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
          Hotel
        </a>
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" href="#">Monaco</a></li>
          <li><hr class="dropdown-divider"></li>
        </ul>
      </li>

      <div class="form-floating">
        <input class="form-control" name="numofguests" placeholder="Number of guests">
        <label>Number of guests</label>
      </div>
      <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
    </form>
  </main>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Room'
}
</script>

<style scoped>

</style>