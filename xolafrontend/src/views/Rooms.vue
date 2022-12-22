<template>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Hotel</th>
      <th scope="col">City</th>
      <th scope="col">Number of guests</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Kaunas</td>
      <td>Kaunas</td>
      <td>2</td>
      <td>
        <button type="button">Delete</button>
      </td>
      <td>
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8081/room">Edit</a>
        </li>
      </td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Ritz</td>
      <td>Monaco</td>
      <td>4</td>
      <td>
        <button type="button">Delete</button>
      </td>
      <td>
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8081/room">Edit</a>
        </li>
      </td>
    </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Rooms"
}
</script>

<style scoped>

</style>