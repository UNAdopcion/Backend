<template>
  <div id="logeo">
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
import RealizarLogeoServicio from "../servicio/RealizarLogeoServicio";

export default {
  methods: {
    enviarDatos(e) {
      e.preventDefault();
      let objectoActual = this;
     // para ser convertido en JSON
      let info = {
        nombre: this.nombre,
        contrasena: this.contrasena,
      };

      this.hacerLogeo(objectoActual, info);
    },
    
    hacerLogeo(objetoActual, datos) {
      RealizarLogeoServicio.hacerLogeo(datos).then((respuesta) => {
        objetoActual.probar = respuesta.data;
        if (respuesta.data.lastIndexOf("Logeado") >= 0 ){
          this.$router.push('logged-header');//redireccionar a logged-header
          console.log(respuesta.data);
        }
        else {
          this.mostrarLogeoFallido(respuesta.data);
          console.log(respuesta.data);
        }
      });
    },
    
    mostrarLogeoFallido(mensaje) {
      swal.fire("Intenta nuevamente", mensaje, "error");
    },
  },
  name: "Logeo",
  components: {
    Header,
    Footer,
  },
  data() {
    return {
      nombre: "",
      contrasena: "",
      probar: ""
    };
  },
};
</script>

<style scoped>
</style>