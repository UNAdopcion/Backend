<template>
  <div id="registrousuario"><Header></Header>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header"><b>Crea tu cuenta con nosotros!</b></div>

          <div class="card-body">
            <form @submit="enviarForma">
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
  </div>
</template>

<script>
import RegistrarUsuarioServicio from "../servicio/RegistrarUsuarioServicio";
import Header from "../components/Header";

export default {
  name: "RegistroUsuario",
  components: {
    Header
  },
  mounted() {
    console.log('Componente RegistroUsuario OK.')
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
    enviarForma(e) {
      e.preventDefault();
      let objectoActual = this;
       let info = {
         nombre:this.nombre,
         correo:this.correo,
         telefono:this.telefono,
         contrasena:this.contrasena
      }
       this.registrarUsuario(objectoActual, info);
    },

    registrarUsuario(objetoActual, info){
      RegistrarUsuarioServicio.registrarUsuario(info)
      .then(respuesta=>{
        objetoActual.probar = (respuesta.data);
        console.log(respuesta.data);
      });
    }
  }
}
</script>

<style scoped>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css);
</style>