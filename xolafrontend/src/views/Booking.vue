<template>
  <main class="form-signin">
    <form @submit.prevent="submit">
      <div class="col-12 text-center">
        <h3 class="pt-3">Create booking</h3>
      </div>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
          Category
        </a>
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" href="#">Car</a></li>
          <li><hr class="dropdown-divider"></li>
        </ul>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
          Product
        </a>
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" href="#">Bugatti Veyron</a></li>
          <li><hr class="dropdown-divider"></li>
        </ul>
      </li>

      <div class="form-floating">
        <input type="date" class="form-control" name="startdate" placeholder="11-11-2011">
        <label>Start date</label>
      </div>

      <div class="form-floating">
        <input type="date" class="form-control" name="enddate" placeholder="12-11-2011">
        <label>End date</label>
      </div>

      <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
    </form>
  </main>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Booking"
}
</script>

<style scoped>

</style>