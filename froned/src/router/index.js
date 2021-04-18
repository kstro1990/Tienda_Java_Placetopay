import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/personas',
    name: 'Personas',
    component: () => import(/* webpackChunkName: "Personas" */ '../views/Personas.vue')
  },
  {
    path: '/productos',
    name: 'Productos',
    component: () => import(/* webpackChunkName: "Productos" */ '../views/Productos.vue')
  },
  {
    path: '/registrarUsuario',
    name: 'RegistrarUsuario',
    component: () => import(/* webpackChunkName: "Productos" */ '../views/RegistrarUsuario')
  },
  {
    path: '/productosDetalle',
    name: 'ProductosDetalle',
    component: () => import(/* webpackChunkName: "ProductosDetalle" */ '../views/ProductosDetalle')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
