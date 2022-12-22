<template>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
      <th scope="col">Agency</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Grand canyon</td>
      <td>5000</td>
      <td>Lux Express</td>
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
  name: "Tours"
}
</script>

<style scoped>

</style>