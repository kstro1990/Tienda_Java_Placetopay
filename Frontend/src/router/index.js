import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import StatusPedido from '../views/StatusPedido.vue'

const routes = [

  {
    path: '/StatusPedido',
    name: 'StatusPedido',
    component: StatusPedido,
    
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
    path: '/',
    name: 'RegistrarUsuario',
    component: () => import(/* webpackChunkName: "Productos" */ '../views/RegistrarUsuario')
  },
  {
    path: '/productosDetalle',
    name: 'ProductosDetalle',
    component: () => import(/* webpackChunkName: "ProductosDetalle" */ '../views/ProductosDetalle')
  },
  { path: '/hi', redirect: '/producto' }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router


