import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'
import Dashboard from '../components/Dashboard.vue'
import Author from '../components/Author.vue'
import Book from '../components/Book.vue'
import Member from '../components/Member.vue'

Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
  {
    path: '/',
    name: 'Dashboard',
    component: Dashboard
  },
  {
    path: '/author',
    name: 'Author',
    component: Author
  },
  {
    path: '/book',
    name: 'Book',
    component: Book
  },
  {
    path: '/member',
    name: 'Member',
    component: Member
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
