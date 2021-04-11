<template>
  <div class="about">
    <h1>This is an productos page</h1>
    <registarUsuarioApp/>
  </div>
</template>


<script>
// @ is an alias to /src
import registarUsuarioApp from '@/components/RegistarUsuarioApp.vue'

export default {
  name: 'registarUsuario',
  components: {
    registarUsuarioApp
  }
}
</script>
