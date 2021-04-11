<template>
  <div class="about">
    <h1>This is an Personas page</h1>
    <PersonasApp/>
  </div>
</template>


<script>
// @ is an alias to /src
import PersonasApp from '@/components/PersonasApp.vue'

export default {
  name: 'Personas',
  components: {
    PersonasApp
  }
}
</script>

