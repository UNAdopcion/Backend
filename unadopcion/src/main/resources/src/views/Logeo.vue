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
                    <input required type="text" class="form-control" v-model="nombre" />
                  </div>
                </div>
                <br />
                <div class="row">
                  <div class="col-4">
                    <strong>Contraseña:</strong>
                  </div>
                  <div class="col-8">
                    <input required
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
    <footer><Footer></Footer></footer>
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
        //objetoActual.probar = respuesta.data;
        console.log(respuesta.status);
        if (respuesta.status === 200){
          this.$router.push('inicio');//redireccionar a principal

        }
      }).catch(error =>{// hay un error
        if (error.response.status === 401){
          this.mostrarLogeoFallido("Las credenciales no coinciden");//credenciales erroneas
        }else if(error.response.status === 404){
          this.mostrarLogeoFallido("No se encuentra el usuario con esas credenciales");//no existe usuario
        }else{
          this.mostrarLogeoFallido("Error de red");
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
footer,

footer{
  bottom: 0.1cm;
  align-self: auto;
}

</style>