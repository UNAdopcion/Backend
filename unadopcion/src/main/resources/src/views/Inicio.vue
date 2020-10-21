<template>
  <div id="inicio"><LoggedHeader></LoggedHeader>
    <br><div>
      <input type="text" v-model="nombre">
      <button class="btn btn-success" @click="enviarForma">Buscar Usuario</button>
    </div>

    <Footer></Footer>
  </div>
</template>

<script>
import LoggedHeader from "@/components/LoggedHeader";
import Footer from "@/components/Footer";
import MostarPerfil from "@/servicio/MostarPerfil";

export default {
  name: "Inicio",
  components:{
    LoggedHeader, Footer
  },
  data(){
    return{
      nombre: '',
      probar: ''
    }
  },
  methods: {
    enviarForma(e) {
      e.preventDefault();
      let objectoActual = this;

      this.mostrarPerfil(objectoActual, this.nombre);
    },

    mostrarPerfil(objetoActual, info) {
      MostarPerfil.mostrarPerfil(info)
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