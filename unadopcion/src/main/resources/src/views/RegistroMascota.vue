<template>
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-8">
          <div class="card">
            <div class="card-header"><b>Registra una macota!</b></div>
            <!--<img :src="probar"  width="100px" height="100px" alt="yahoo">!-->
            <div class="card-body">
              <form id="formulario" @submit="formaEnviar">
                <strong>Nombre de usuario de quien registra</strong>
                <input required type="text" class="form-control" v-model="nombreusuario">

                <strong>Nombre de la mascota</strong>
                <input required type="text" class="form-control" v-model="animalnombre">

                <strong>Lugar donde se encuentra la mascota</strong>
                <input required type="text" class="form-control" v-model="animallugar" >

                <strong>Edad de la mascota:</strong>
                <input required type="number" class="form-control" v-model="animaledad">

                <strong >Especie del animal</strong>
                <select required class="form-control" v-model="animaltipo">
                  <option>Perro</option>
                  <option>Gato</option>
                  <option>Ave</option>
                  <option>Roedor</option>
                  <option>Bestia</option>
                  <option>Pez</option>
                  <option>Reptil</option>
                  <option>Otro</option>
                </select>

                <strong>Sexo:</strong>
                <select required class="form-control" v-model="animalsexo">
                  <option>Hembra</option>
                  <option>Macho</option>
                </select>

                <strong>Algo curioso sobre la mascota</strong>
                <input type="text" class="form-control" v-model="animaldescripcion">

                <input required type="file" @change="enCambioArchivo">

                <button class="btn btn-success">Enviar</button>
              </form>
              <strong>Respuesta servidor:</strong>
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
import swal from "sweetalert2";
import RegistrarMascotaServicio from "../servicio/RegistrarMascotaServicio";
//import LoggedHeader from "../components/LoggedHeader";


export default {
  name: "RegistroMascota",
  components: {

  },
  mounted() {
    console.log('Componente Registro OK.')
  },
  data() {
    return {
      nombreusuario: '',
      animalnombre: '',
      animaltipo:'',
      animallugar: '',
      animalsexo:'',
      animaledad:'',
      animaldescripcion:'',
      imagenSeleccionada: null,
      probar:'',
      imagen:''
    };
  },
  methods: {

    enCambioArchivo (event) {
      this.imagenSeleccionada = event.target.files[0];
    },

    mostrarRegistroExitoso(mensaje){
      swal.fire('Registro exitoso!', mensaje, 'success')
    },

    formaEnviar(e) {
      e.preventDefault();
      let objectoActual = this;
      let datos = new FormData();
      //diccionario para ser convertido en JSON
      let infoRegistro = {
        nombreusuario: this.nombreusuario,
        animalnombre: this.animalnombre,
        animaltipo: this.animaltipo,
        animallugar: this.animallugar,
        animalsexo: this.animalsexo,
        animaledad: this.animaledad,
        animaldescripcion: this.animaldescripcion
      }
      //diccionario a JSON
      let json = JSON.stringify(infoRegistro);
      datos.append("imagen", this.imagenSeleccionada);
      datos.append("info", json);
      this.registrarMascota(objectoActual, datos);
      /*axios.post(UNADOPCION_API_URL + CONTROLADOR, datos)
          .then(function (respuesta) {
            objectoActual.probar = respuesta.data;
            //hay que verificar que el servido responde OK con un if
           // this.mostrarRegistroExitoso(respuesta.data)



          })
          .catch(function (error) {
            objectoActual.probar = error;
          });*/
    },

    registrarMascota(objetoActual, datos){
      RegistrarMascotaServicio.registrarMascota(datos)
          .then(respuesta=>{
            objetoActual.probar = (respuesta.data);
            console.log(respuesta.data);
          });
    }
  },

  created(){
    //this.mostrarRegistroExitoso("Mensaje de exito")
  }
}
</script>

<style>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css);
</style>