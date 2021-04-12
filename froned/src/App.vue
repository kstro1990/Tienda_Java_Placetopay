<template>
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link to="/personas">Personas</router-link> |
      <router-link to="/productos">productos</router-link> |
      <router-link to="/registrarUsuario">Registrar</router-link> |
      <router-link to="/productosDetalle">ProductosDetalle</router-link>
      
    </div>
    
  <router-view />
</template>

<style>

body {
  background-color: rgb(245, 250, 255);
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #4258b9;
}
</style>
