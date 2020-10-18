<template>
  <div class="container">
    <componente />
  </div>
</template>

<script>
import componente from './components/BusquedaMascota'

export default {
  name: 'App',
  components: {
    componente
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
