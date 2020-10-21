<template>
  <div id="Login">
    <Header></Header>
    <br /><br />
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-8">
          <div class="card">
            <div class="card-header">
              <b>¡Autenticate para obtener más beneficios!</b>
            </div>

            <div class="card-body">
              <form @submit="enviarDatos">
                <br />
                <div class="row">
                  <div class="col-4">
                    <strong>Nombre de usuario:</strong>
                  </div>
                  <div class="col-8">
                    <input type="text" class="form-control" v-model="nombre" />
                  </div>
                </div>
                <br />
                <div class="row">
                  <div class="col-4">
                    <strong>Contraseña:</strong>
                  </div>
                  <div class="col-8">
                    <input
                      type="password"
                      class="form-control"
                      v-model="contrasena"
                    />
                  </div>
                </div>
              </form>

              <br />

              <div class="row">
                <div class="col-12">
                  <div class="text-right">
                    <button class="btn btn-danger mr-4">
                      Olvidé la Contraseña
                    </button>
                    <button class="btn btn-success" @click="enviarDatos">Iniciar Sesion</button>
                  </div>
                </div>
              </div>
              <br />
              <br />
              <strong>Una mascota feliz, es una familia feliz.</strong>
            </div>
          </div>
        </div>
      </div>
    </div>
    <br /><br />
    <Footer></Footer>
  </div>
</template>

<script>
import swal from "sweetalert2";
import Header from "../components/Header";
import Footer from "../components/Footer";
import AutenticarUsuario from "../servicio/RealizarLogin"

export default {
  methods: {
    enviarDatos(e) {
      e.preventDefault();
      let objectoActual = this;
      //diccionario para ser convertido en JSON
      let infoAutenticar = {
        nombre: this.nombre,
        contrasena: this.contrasena,
      };

      this.autenticar(objectoActual, infoAutenticar);
    },
    
    autenticar(objetoActual, datos) {
      AutenticarUsuario.login(datos).then((respuesta) => {
        objetoActual.probar = respuesta.data;
        console.log(respuesta.data);
      });
    },
    
    mostrarLogeoExitoso(mensaje) {
      swal.fire("Inicio de sesion completado", mensaje, "success");
    },
  },
  name: "Login",
  components: {
    Header,
    Footer,
  },
  data() {
    return {
      nombre: "",
      contrasena: "",
    };
  },
};
</script>

<style scoped>
</style>