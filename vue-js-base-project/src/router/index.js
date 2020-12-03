import Vue from 'vue'
import VueRouter from 'vue-router'
import Dashboard from '../components/Dashboard.vue'
import Author from '../components/Author.vue'
import Book from '../components/Book.vue'
import Member from '../components/Member.vue'

Vue.use(VueRouter)

const routes = [
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
  routes
})

export default router
