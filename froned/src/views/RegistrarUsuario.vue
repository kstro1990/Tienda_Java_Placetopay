<template>
  <div class="about">
    <h1>Resgistro de Usuario</h1>
    <registrarUsuarioApp/>
  </div>
</template>


<script>
// @ is an alias to /src
import registrarUsuarioApp from '@/components/registrarUsuarioApp.vue'

export default {
  name: 'registarUsuario',
  components: {
    registrarUsuarioApp
  }
}
</script>
