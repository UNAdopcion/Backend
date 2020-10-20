<template>
<div>
  <Header></Header>
   <div class="row">
    <div class="col-2"></div>
    <div class="col-7 mb-4">
      <br><br>
      <div class="container">
        <h2>¿Que cuidados debo tener en cuenta al adoptar unas mascota?</h2>
        <h1></h1>
        <br>
        <p>Todas las mascotas deben tener uno cuidados minimos por parte del propietario,
          solo los principales se muestran a continuación:</p><br>
      </div>

      <div class="container">
        <ul class="list-group">
          <li class="list-group-item">Alimentación: MIN 3 veces al día</li>
          <li class="list-group-item">Vacunas al día</li>
          <li class="list-group-item">Baño Frecuente</li>
          <li class="list-group-item">Limpieza de dientes</li>
          <li class="list-group-item">Los perros deben tener paseos al parque 2 veces al día</li>
          <li class="list-group-item">Atención medica veterinaria en caso de enfermedad</li>
        </ul>
      </div>
    </div>
    <div class="col-3"></div> <br><br><br>
  </div>
  <Footer></Footer>
</div>
  
</template>

<script>
import Header from "../components/Header";
import Footer from "../components/Footer";

export default {
  name: "CuidadosMascota",
  components: {
    Header, Footer
  }
}
</script>

<style scoped>

</style>