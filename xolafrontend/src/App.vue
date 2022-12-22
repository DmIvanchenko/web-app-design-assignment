<template>
  <div id="app">
    <NavBar/>
    <router-view/>
  </div>

</template>

<script>
// import NavBar from "@/components/NavBar";
import axios from "axios";
import NavBar from "@/components/NavBar";

export default {
  components:{NavBar},
  data(){
    return{
      baseUrl:"http://localhost:8080",
      rooms: [],
      hotels: [],
      cities: [],
      tours: [],
      touragencies: [],
      cars: [],
      caragencies: []
    }
  },
  methods:{
    async fetchData(){
      await axios.get(this.baseUrl + "rooms/")
          .then(res => {
            this.rooms = res.data.rooms
          }).catch((err) => console.log('err', err));

      await axios.get(this.baseUrl + "hotels/")
          .then(res => {
        this.hotels = res.data.hotels
      }).catch((err) => console.log('err', err));

      await axios.get(this.baseUrl + "cities/")
          .then(res => {
            this.cities = res.data.cities
          }).catch((err) => console.log('err', err));

      await axios.get(this.baseUrl + "tours/")
          .then(res => {
            this.tours = res.data
          }).catch((err) => console.log('err', err));

      await axios.get(this.baseUrl + "touragencies/")
          .then(res => {
            this.touragencies = res.data
          }).catch((err) => console.log('err', err));

      await axios.get(this.baseUrl + "cars/")
          .then(res => {
            this.cars = res.data
          }).catch((err) => console.log('err', err));

      await axios.get(this.baseUrl + "caragencies/")
          .then(res => {
            this.hotels = res.data
          }).catch((err) => console.log('err', err));
    }
  },
  mounted() {
    this.fetchData();
  }
}
</script>

<style>

</style>
