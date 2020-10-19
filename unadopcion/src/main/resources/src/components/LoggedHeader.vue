<template>
  <div class="LoggedHeader">
    <!--Header-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light ">
      <a class="navbar-brand" href="index.html">
        <img src="img/UNAdopcion.svg" alt="Logo UNadopcion" height="80" >
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-md-auto">
          <li class="nav-item" id="btnPrincipal">
            <a class="nav-link" href="principal" >Principal <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item" id="btnRegisPet">
            <a class="nav-link" href="registro-mascota">Registrar mascota <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="buscar-mascota">Buscar Mascota<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="denuncia">Denunciar <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="cuidados">Cuidados <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contacto">Contactanos <span class="sr-only">(current)</span></a>
          </li>
        </ul>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: "LoggedHeader",
  props: {
    nombre: String,
  }
}



</script>

<style>

</style>