<template>
  <div id="registrousuario"><Header></Header>
    <br><h1 class="text-center"><strong class="text-capitalize">¡Crea tu cuenta con nosotros!</strong></h1>
    <br><div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <br><div class="card-header"><b>Registro</b></div>

          <div class="card-body">
            <form @submit="enviarForma">
              <br><strong>Nombre de usuario:</strong>
              <input required type="text" class="form-control" v-model="nombre">
              <br><strong>Correo:</strong>
              <input required type="text" class="form-control" v-model="correo">
              <br><strong>Teléfono:</strong>
              <input required type="text" class="form-control" v-model="telefono">
              <br><strong>Contraseña:</strong>
              <input required type="password" class="form-control" v-model="contrasena">

              <button class="btn btn-success">Enviar</button>
            </form>
            <strong></strong>
            <pre>
                        {{probar}}
            </pre>
          </div>
        </div>
      </div>
    </div>
  </div><footer><Footer></Footer></footer>
  </div>
</template>

<script>
import RegistrarUsuarioServicio from "../servicio/RegistrarUsuarioServicio";
import Header from "../components/Header";
import Footer from "@/components/Footer";
import swal from "sweetalert2";

export default {
  name: "RegistroUsuario",
  components: {
    Header, Footer
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
        //objetoActual.probar = (respuesta.data);
        //.log(respuesta.data);
        if(respuesta.status === 201)
        swal.fire("Registro exitoso", "Bienvenido", "success");
      }).catch(error =>{
          if(error.response.status == 400){
            swal.fire("Intente nuevamente", "El usuario o email ya existe", "error");
          }
      });
    }
  }
}
</script>

<style scoped>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css);

</style>

<style>
*{
  box-sizing: border-box;
}
body{
  margin: 10px;
  padding: 20px;
  font-family: sans-serif;
  min-height: 100vh;
  background-image: url("../assets/fondo_patitas3.jpeg");
  background-attachment: fixed;
  text-align: justify;
}

body::before{
  content: "";
  width: 100%;
  min-height:150vh;
  position: fixed;
  top: 0;
  left: 0;

  background: linear-gradient(45deg, #F3E2A9, #EFFBFB,#58FA58);
  background-attachment: scroll;
  opacity: 0.5;
  z-index: -1;
}

h1{
  color: #fff;
  text-align: center;
}

.titulo{
  background: #0EA7E7;
  color: #fff;
  padding: 20px;
  text-align: center;
  font-weight: 100;
  font-size: 30px;
  border-top-left-radius: 7px;
  border-top-right-radius: 7px;
  border-bottom: 3px solid #EA484E;
}

.form-control{
  font-family:  Arial, Helvetica, sans-serif;
  font-size: 16px;
}

p.texto {
  font-family:  Arial, Helvetica, sans-serif;
  font-size: 20px;
  text-align: justify;
}


.checkbox {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 14px;
  border-radius: 0.25em;
  align-items: center;
  cursor: pointer;
}

.imagen{
  display:block;
  margin:auto;
}

.divM{
  color: #000000;
  border:6px solid;
}

h2,h3{
  color:#000000;
  font-weight: bold;
  text-align: left;
}

.h12{
  color: #000000;
  text-align: center;
}

footer,

footer{
  bottom: 0.1cm;
  align-self: auto;
}


</style>