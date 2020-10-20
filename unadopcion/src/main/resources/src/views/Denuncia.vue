<template>
  <div>
    <Header></Header>
    <h1>SECCION DE DENUNCIAS</h1>
    <Denuncia></Denuncia>
    <Footer></Footer>
  </div>
  
</template>

<script>
import Header from "../components/Header";
import Footer from "../components/Footer";
import Denuncia from "../components/ComponentDenuncia";

export default {
  name: "Denuncia",
  components: {
    Header, Footer, Denuncia
  }
}
</script>

<style scoped>

</style>