<template>
<div class="Header">
<!--Header-->
<nav class="navbar navbar-expand-lg navbar-light bg-light ">
  <a class="navbar-brand" href="principal">
    <img src="@/assets/UNAdopcion.svg" alt="Logo UNadopcion" height="40" >
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ml-md-auto">
      <li class="nav-item" id="btnPrincipal">
        <a class="nav-link" href="principal" >Principal</a>
      </li>
      <li class="nav-item" id="btnRegisUser">
        <a class="nav-link" href="registro" >Registrarse</a>
      </li>
      <li class="nav-item" id="btnLogUser">
        <a class="nav-link" href="login" >Iniciar Sesión</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="contacto">Contactanos</a>
      </li>
    </ul>
  </div>
</nav>
</div>
</template>

<script>
export default {
  name: "Header",
  props: {
    nombre: String,
  }
}

</script>

<style>

</style>