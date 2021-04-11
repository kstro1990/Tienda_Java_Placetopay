<template>
  <div class="about">
    <h1>This is an productos page</h1>
    <productosApp/>
  </div>
</template>


<script>
// @ is an alias to /src
import productosApp from '@/components/ProductosApp.vue'

export default {
  name: 'productos',
  components: {
    productosApp
  }
}
</script>
