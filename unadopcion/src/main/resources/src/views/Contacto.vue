<template>
  <div id="contacto"><Header></Header>
    <h1>CONTACTANOS</h1>
    <Formulario></Formulario>
    <Footer></Footer>  
  </div>
  
</template>

<script>
import Header from "@/components/Header";
import Footer from "@/components/Footer";
import Formulario from "@/components/FormularioContact";

export default {
  name: "Contacto",
  components: {
    Header, Footer, Formulario
  }
}
</script>

<style scoped>

</style>