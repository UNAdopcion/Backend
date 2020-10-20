<template>
  <div>
    <Header></Header>
    <h1>SECCION DE DENUNCIAS</h1>
    <DenunciaComp></DenunciaComp>
    <Footer></Footer>
  </div>
  
</template>

<script>
import Header from "../components/Header";
import Footer from "../components/Footer";
import DenunciaComp from "../components/ComponentDenuncia";

export default {
  name: "Denuncia",
  components: {
    Header, Footer, DenunciaComp
  }
}
</script>

<style scoped>

</style>