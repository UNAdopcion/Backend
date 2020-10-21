<template>
  <div id="registrousuario" onload="">
    <!--@private byte[] usuarioFoto;-->
    <Header></Header>
    <div class="container">
      <br />
      <div class="row justify-content-center">
        <div class="col-md-8">
          <div class="card">
            <div class="card-header">
              <b>EU Edita tu información para manternos al día!</b>
            </div>

            <div class="card-body">
              <form @submit="enviarDatos">
                <div class="row">
                  <div class="col-4">
                    <strong>Nombre de usuario:</strong>
                  </div>
                  <div class="col-8">
                    <input
                        type="text"
                        class="form-control"
                        @change="comprobarFormato"
                        v-model="nombre"
                    />
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
                        @change="comprobarFormato"
                        v-model="contrasena"
                    />
                  </div>
                </div>
                <br />

                <div class="row">
                  <div class="col-4">
                    <strong>Confirme su Contraseña:</strong>
                  </div>
                  <div class="col-8">
                    <input
                        type="password"
                        class="form-control"
                        @change="comprobarFormato"
                        v-model="contrasena2"
                    />
                  </div>
                </div>
                <br />

                <div class="row">
                  <div class="col-4">
                    <strong>Rol:</strong>
                  </div>
                  <div class="col-8">
                    <select
                        class="form-control form-control-sm"
                        @change="comprobarFormato"
                        v-model="rol"
                    >
                      <option>Cuidador</option>
                      <option>Adoptante</option>
                      <option>Adoptador</option>
                    </select>
                  </div>
                </div>
                <br />

                <div class="row">
                  <div class="col-4">
                    <strong>Correo:</strong>
                  </div>
                  <div class="col-8">
                    <input
                        type="text"
                        class="form-control"
                        @change="comprobarFormato"
                        v-model="correo"
                    />
                  </div>
                </div>
                <br />

                <div class="row">
                  <div class="col-4">
                    <strong>Teléfono:</strong>
                  </div>
                  <div class="col-8">
                    <input
                        type="text"
                        class="form-control"
                        @change="comprobarFormato"
                        v-model="telefono"
                    />
                  </div>
                </div>
                <br />

                <div class="row">
                  <div class="col-4">
                    <strong>Lugar donde vive:</strong>
                  </div>
                  <div class="col-8">
                    <input
                        type="text"
                        class="form-control"
                        @change="comprobarFormato"
                        v-model="lugar"
                    />
                  </div>
                </div>
                <br />

                <div class="row">
                  <div class="col-4">
                    <strong>Información adicional:</strong>
                  </div>
                  <div class="col-8">
                    <textarea type="text" class="form-control" v-model="info" />
                  </div>
                </div>
                <br />

                <div class="row">
                  <div class="col-12">
                    <div class="text-right">
                      <button class="btn btn-danger mr-4">Cancelar</button>
                      <button class="btn btn-success" id="Aceptar" @click="enviarDatos">
                        Aceptar
                      </button>
                    </div>
                  </div>
                </div>
              </form>
              <br />
              <div class="alert alert-danger" id="error-contraseña">
                Las contraseñas no coinciden, por favor vuelve a revisar.
              </div>
              <div class="alert alert-danger" id="alerta-error">
                Algún campo obligatorio de datos no posee ningún dato.
              </div>
              <br />
              <strong
              >Datos actualizados nos permiten mantenerte seguro.</strong
              >
            </div>
          </div>
        </div>
      </div>
    </div>
    <br />
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "../components/Header";
import Footer from "../components/Footer";
import EditarUsuario from "../servicio/EditarUsuarioServicio"

export default {
  data() {
    return {
      nombre: "",
      contrasena: "",
      contrasena2: "",
      rol: "",
      correo: "",
      telefono: "",
      lugar: "",
      info: "",
    };
  },
  methods: {
    enviarDatos(e) {
      e.preventDefault();
      //diccionario para ser convertido en JSON
      let infoAutenticar = {
        nombre: this.nombre,
        contrasena: this.contrasena,
        rol: this.rol,
        correo: this.correo,
        telefono: this.telefono,
        lugar: this.lugar,
        info: this.info,
      };
      this.editar(infoAutenticar);
    },

    editar(datos) {
      EditarUsuario.EditarUsuario(datos).then((respuesta) => {
        console.log(respuesta.data);
      });
    },
    comprobarContrasena() {
      if (this.contrasena != this.contrasena2) {
        document.getElementById("error-contraseña").style.display = "block";
        document.getElementById("Aceptar").disabled = true;
      } else {
        document.getElementById("error-contraseña").style.display = "none";
        document.getElementById("Aceptar").disabled = false;
      }
    },
    comprobarDatos() {
      if (
          this.nombre == "" ||
          this.contrasena == "" ||
          this.rol == "" ||
          this.correo == "" ||
          this.telefono == "" ||
          this.lugar == ""
      ) {
        document.getElementById("alerta-error").style.display = "block";
        document.getElementById("Aceptar").disabled = true;
      } else {
        document.getElementById("alerta-error").style.display = "none";
        document.getElementById("Aceptar").disabled = false;
      }
    },
    comprobarFormato() {
      this.comprobarContrasena();
      this.comprobarDatos();
    },
  },
  name: "EditarUsuario",
  components: {
    Header,
    Footer,
  },
};
</script>

<style scoped>
</style>