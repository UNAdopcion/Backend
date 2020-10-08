<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header"><b>Bienvenido a Registro de usuario</b></div>

          <div class="card-body">
            <form @submit="formSubmit">
              <strong>Nombre de usuario:</strong>
              <input type="text" class="form-control" v-model="nombre">
              <strong>Correo:</strong>
              <input type="text" class="form-control" v-model="correo">
              <strong>Teléfono:</strong>
              <input type="text" class="form-control" v-model="telefono">
              <strong>Contraseña:</strong>
              <input type="password" class="form-control" v-model="contrasena">

              <button class="btn btn-success">Enviar</button>
            </form>
            <strong>Salida:</strong>
            <pre>
                        {{probar}}
            </pre>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import axios from 'axios'
const UNADOPCION_API_URL = "http://localhost:8080";
const CONTROLADOR = "/crearusuario";
export default {
  mounted() {
    console.log('Componente OK.')
  },
  data() {
    return {
      nombre: '',
      correo: '',
      telefono:'',
      contrasena: '',
      probar:''
    };
  },
  methods: {
    formSubmit(e) {
      e.preventDefault();
      let objectoActual = this;
      axios.post(UNADOPCION_API_URL + CONTROLADOR, {
        nombre: this.nombre,
        correo: this.correo,
        telefono: this.telefono,
        contrasena: this.contrasena
      })
          .then(function (respuesta) {
            objectoActual.probar = respuesta.data;
          })
          .catch(function (error) {
            objectoActual.probar = error;
          });
    }
  }
}
</script>

<style>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css);
</style>