<template>
  <div id="principal">
    <Header></Header>
    <div class="container-fluid">
        <div class="row">
            <img src="@/assets/HeroSection.png" alt="Banner principal" width="100%">
        </div>
    </div>
    <h1>PRINCIPAL</h1>
    <h2>Con Cabecera</h2>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "../components/Header";
import Footer from "../components/Footer";

export default {
  name: "Principal",
  components: {
    Header, Footer
  }
}
</script>
#Principal{
padding-top: 10%;
}
<style scoped>

</style>