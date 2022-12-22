<template>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Model</th>
      <th scope="col">Price</th>
      <th scope="col">Agency</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Buatti Veyron</td>
      <td>5000</td>
      <td>Lux Auto</td>
      <td>
        <button type="button">Delete</button>
      </td>
      <td>
        <button type="button">Edit</button>
      </td>
    </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Cars"
}
</script>

<style scoped>

</style>