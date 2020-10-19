<template>
  <div id="principal">
    <Header></Header>
    <div class="container-fluid">
        <div class="row"> <img src="@/assets/HeroSection.png" alt="Banner principal" width="100%"> </div>
    </div>

    <div class="container">
      <div class="row">
          <div class="col"> <img src="@/assets/Dog.jpg" alt="Perro" width="300"></div>
          <div class="col"><img src="@/assets/cat.jpg" alt="Gato" width="300"></div>
          <div class="col"><img src="@/assets/Hams.jpg" alt="Hamster" width="300"></div>
      </div>
    </div>

    <Medio> </Medio>


    <Footer></Footer>
  </div>
</template>

<script>
import Header from "../components/Header";
import Footer from "../components/Footer";
import Medio from "../components/PprincipalMasc";

export default {
  name: "Principal",
  components: {
    Header, Footer, Medio
  }
}
</script>
#Principal{
padding-top: 10%;
}
<style scoped>

</style>