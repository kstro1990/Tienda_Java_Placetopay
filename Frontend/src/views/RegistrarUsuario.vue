<template>
  <div class="about">
    <registrarUsuarioApp/>
  </div>
</template>

<script>

import registrarUsuarioApp from '@/components/registrarUsuarioApp.vue'

export default {
  name: 'registarUsuario',
  components: {
    registrarUsuarioApp
  },
   mounted() {      
     var toma =  this.$route.params.id;
     console.log(toma);
    },
  beforeRouteUpdate(to, from, next) {
    console.log(to);
    console.log(from);
    console.log(next);
  }
}
</script>
