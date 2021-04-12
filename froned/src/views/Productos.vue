<template>
  <div class="about">
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
