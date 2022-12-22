import { createRouter, createWebHistory } from 'vue-router'
import Dashboard from "@/views/Dashboard";
import SignUp from "@/views/SignUp";
import Login from "@/views/Login";
import UpdateAccount from "@/views/UpdateAccount";
import Rooms from "@/views/Rooms";
import Cars from "@/views/Cars";
import Tours from "@/views/Tours";
import Booking from "@/views/Booking";
import Room from "@/views/Room";

const routes = [
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: Dashboard
  },
  {
    path: '/rooms',
    name: 'Rooms',
    component: Rooms
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/updateAccount',
    name: 'UpdateAccount',
    component: UpdateAccount
  },
  {
    path: '/cars',
    name: 'Cars',
    component: Cars
  },
  {
    path: '/tours',
    name: 'Tours',
    component: Tours
  },
  {
    path: '/booking',
    name: 'Booking',
    component: Booking
  },
  {path: '/room',
  name: 'Room',
  component: Room}
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
