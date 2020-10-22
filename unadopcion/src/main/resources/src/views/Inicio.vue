<template>
  <div id="inicio"><LoggedHeader></LoggedHeader>

    <br><h3>Bienvenido "{{ mostrarUsiario() }}"</h3>

      <br><div class="container">
       <div class="card">
          <br><div class="mb-2">
         <br><b-avatar src="@/assets/profile.jpg" size="8rem"></b-avatar>
          </div>
         <div><br></div>
          <br><div class="text-center">
            <button  class="btn btn-success" @click="editarUsuario">Editar Usuario</button>
            <br>
            </div>
       <div><br></div></div>
      </div>

    <div><br></div>
    <div><br></div>
    <div><br></div>
    <div><br></div>
    <div><br></div>
    <div><br></div>
    <div><br></div>
    <div><br></div>

    <br><div card>
        <div class="form-row">

          <strong class="text-nowrap">Nombre de usuario:</strong>
          <label class="control-label col-sm-2"><input type="text" class="control-label col-sm-8" v-model="nombre"></label>
          <button class="btn btn-success" @click="enviarForma">Buscar Usuario</button>
        </div>


    <footer><Footer></Footer></footer>
    </div>
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
      nameuser: 'Juanito',
      nombre: '',
      probar: ''
    }
  },
  methods: {
     mostrarUsiario(){
       return this.nameuser
     },

    editarUsuario(e){
      e.preventDefault();
      this.$router.push('editar-usuario');
    },

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

footer,

body{
  width: 97.5%;
  position: absolute;
}

footer{
  bottom: 0.1cm;
  align-self: auto;
}

</style>