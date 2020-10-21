<template>
  <!--<h1>SECCION DE DENUNCIAS</h1>-->
  <div id="denuncia"><LoggedHeader></LoggedHeader>

    <br><div></div>
    <br><div class="container">
      <div class="col-sm-10">
        <h1 class="text-left">Nombre Mascota: PEPITO</h1>
      </div>
    </div>


    <br><div class="container">
      <div class="row justify-content-center"></div>
      <div class="card">
        <div class="card-header"><div class="text-center"><strong>SECCIÓN DE DENUNCIAS</strong></div></div>
        <div class="card-body">
          <form class="text-left" id="formulario">

            <br><div class="container">
            <p style="text-align: left" class="text-info"> Seleccione los detalles del tipo de maltrato con el que se encuentra relacionada la mascota: </p>
          </div>

            <br><div class="form-row">
            <strong class="control-label col-sm-2" for="animalTipo">Tipo de Maltrato:</strong>
            <div class="col-sm-10">
              <select class="browser-default custom-select" v-model="tipo" required>
                <option selected></option>
                <option>Abandono</option>
                <option>Maltrato Físico</option>
                <option>Crueldad Animal</option>
                <option>Envenenamiento</option>
                <option>Explotación Animal</option>
                <option>Tráfico Animal</option>
              </select>
            </div>
          </div>

            <br><div class="form-row">
            <strong class="control-label col-sm-2" for="animalTipo">Estado final:</strong>
            <div class="col-sm-10">
              <select class="browser-default custom-select" v-model="estadofinal" required>
                <option selected></option>
                <option>Herido</option>
                <option>Lesión Temporal</option>
                <option>Lesión Permanente</option>
                <option>Muerto</option>
              </select>
            </div>
          </div>

            <br><div class="form-row">
            <strong class="control-label col-sm-2" for="animalTipo">Testigo:</strong>
            <div class="col-sm-10">
              <select class="browser-default custom-select" v-model="testigo" required>
                <option selected></option>
                <option>Presencial</option>
                <option>Virtual</option>
                <option>Por un conocido</option>
                <option></option>
              </select>
            </div>
          </div>

          </form>
        </div>
      </div>
    </div>


    <br><button class="btn btn-success" @click="formaEnviar">Enviar</button>

    <Footer></Footer>
  </div>
</template>

<script>

import Footer from "./Footer";
import LoggedHeader from "@/components/LoggedHeader";
import RegistrarDenunciaServicio from "@/servicio/RegistrarDenunciaServicio";

export default {
  name: "Denuncia",
  components: {
    LoggedHeader, Footer,
  },

  mounted() {
    console.log('Componente Registrar Denuncia OK.')
  },

  data() {
    return {
      nombre:'pepe' ,
      tipo: '',
      estadofinal: '',
      testigo: '',
      descripcion: '',
    }
  },
  methods: {
    formaEnviar(e) {
      e.preventDefault();
      let objectoActual = this;
      this.descripcion = "El estado final de la mascota fue " + this.estadofinal + " y la persona fue testigo " + this.testigo;
      let info = {
        nombre: this.nombre,
        tipo: this.tipo,
        descripcion: this.descripcion,
      }
      console.log(info),
      this.registrarDenuncia(objectoActual, info);
    },

    registrarDenuncia(objetoActual, info) {
      RegistrarDenunciaServicio.registrarDenuncia(info)
          .then(respuesta => {
            objetoActual.probar = (respuesta.data);
            console.log(respuesta.data);
          });
    }
  }
}
</script>

<style scoped>

</style>