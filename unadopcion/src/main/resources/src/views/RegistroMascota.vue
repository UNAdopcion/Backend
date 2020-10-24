<template>
  <div id="registromascota"><LoggedHeader></LoggedHeader>
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-8">
          <br><div class="card">
          <div class="card-header"><b>Registra una macota!</b></div>
        </div>

          <div class="card">
            <div class="card-body">
              <form class="text-left" id="formulario" @submit="formaEnviar">
                <div class="card">
                  <div class="card-header"><div class="text-center"><strong>Datos Usuario</strong></div></div>
                  <div class="card-body">
                    <div class="form-row">
                      <label class="control-label col-sm-2" for="nombreUsuario"><strong> Usuario: </strong></label>
                      <div class="col-sm-10">
                        <input required type="text" id="nombreUsuario" class="form-control" v-model="nombreusuario">
                      </div>
                    </div>
                  </div>
                </div>

                <br><div class="card">
                <div class="card-header"><div class="text-center"><strong>Datos Mascota</strong></div></div>
                <div class="card-body">

                  <div class="form-row">
                    <label class="control-label col-sm-2" for="animalNombre"><strong>Nombre:</strong></label>
                    <div class="col-sm-10">
                      <input required type="text" id="animalNombre" class="form-control" v-model="animalnombre">
                    </div>
                  </div>

                  <br><div class="form-row">
                  <label class="control-label col-sm-2" for="animalLugar"><strong>Lugar:</strong></label>
                  <div class="col-sm-10">
                    <input required type="text" id="animalLugar" class="form-control" v-model="animallugar" >
                  </div>
                </div>

                  <br><div class="form-row">
                  <label class="control-label col-sm-2" for="animalEdad"><strong>Edad:</strong></label>
                  <div class="col-sm-10">
                    <input required type="number" id="animalEdad" class="form-control" v-model="animaledad">
                  </div>
                </div>

                  <br><div class="form-row">
                  <strong class="control-label col-sm-2" for="animalTipo">Especie:</strong>
                  <div class="col-sm-10">
                    <select required class="form-control" id="animalTipo" v-model="animaltipo">
                      <option>Perro</option>
                      <option>Gato</option>
                      <option>Ave</option>
                      <option>Roedor</option>
                      <option>Bestia</option>
                      <option>Pez</option>
                      <option>Reptil</option>
                      <option>Otro</option>
                    </select>
                  </div>
                </div>

                  <br><div class="form-row">
                  <strong class="control-label col-sm-2" for="animalSexo">Sexo:</strong>
                  <div class="col-sm-10">
                    <select required class="form-control" id="animalSexo" v-model="animalsexo">
                      <option>Hembra</option>
                      <option>Macho</option>
                    </select>
                  </div>
                </div>

                  <br><div class="form-row">
                  <br><strong class="control-label row-cols-md-2">Algo curioso sobre la mascota:<br></strong>
                  <textarea type="text" class="control-label row-cols-sm-5"  v-model="animaldescripcion"></textarea>
                </div>

                  <br><div class="form-row">
                  <br><strong class="control-label col-sm-2">Fotografia:</strong>
                  <div class="col-sm-10">
                    <input required type="file" @change="enCambioArchivo">
                  </div>
                </div>



                </div>
              </div>
                <br><div class="align-items-center">
                <br><button  class="btn btn-success">Enviar</button>
              </div>
              </form>


            </div>

          </div>
          <br><strong>Respuesta servidor:</strong>
          <pre>
                        {{probar}}
                  </pre>
        </div>
      </div>
    </div>
    <br><Footer></Footer>
  </div>
</template>

<script>
import swal from "sweetalert2";
import RegistrarMascotaServicio from "../servicio/RegistrarMascotaServicio";
import LoggedHeader from "../components/LoggedHeader";
import Footer from "../components/Footer";


export default {
  name: "RegistroMascota",
  components: {
    LoggedHeader, Footer
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
    },

    registrarMascota(objetoActual, datos){
      RegistrarMascotaServicio.registrarMascota(datos)
          .then(respuesta=>{
            //objetoActual.probar = (respuesta.data);
            //console.log(respuesta.data);
            if(respuesta.status === 201) {
              swal.fire("Registro exitoso", "Bienvenido " + this.animalnombre, "success");
            }
          }).catch(error =>{
            if(error.response.status === 400){
              swal.fire("Algo salio mal", "Verifica que estas registrado", "error");
            }
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