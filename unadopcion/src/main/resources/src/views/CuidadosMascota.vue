<template>
<div>
  <LoggedHeader></LoggedHeader>
  <br><h2 class="text-center"><strong  class="text-black-50">¿Que cuidados debo tener en cuenta al adoptar una mascota?</strong></h2>
  <div class="container">
    <div class="row justify-content-center">
    <div class="col-md-8">
    <br><div style="border: -moz-mac-focusring" class="card">

      <div class="row justify-content-center">
       <div class="col-md-10">
        <div class="card-text">
          <div class="row justify-content-center">
            <div style="margin-left: initial" class="col-md-20">

              <br><div class="text-justify">¿Sabías que la hormona Oxitocina, que se secreta cuando el cuerpo experimenta placer, también se secreta cuando una mascota y su dueño experimentan interacciones positivas entre si?</div>
              <br><div class="text-justify">Entre más fuerte sea el vínculo entre la persona y su mascota, mayor es la posibilidad de que la persona secrete esta hormona, creando estados de felicidad y también de salud </div>
              <br><div class="text-justify">Cada animalito es un mundo pero hay una serie de cuidados básicos que en general debemos llevar a cabo
                                            para que nuestra mascota tenga una vida plena y saludable. Si a vuestra familia se ha unido recientemente un nuevo miembro,
                                            toma nota de las atenciones que debéis mostrarle.n:</div>
            </div>
          </div>
        </div>

        <div class="row justify-content-center" >
          <div class="col-md-10">
            <br><div class="card">
              <div class="accordion" role="tablist">
                <b-card no-body class="mb-1">
                  <b-card-header header-tag="header" class="p-1" role="tab">
                    <b-button block v-b-toggle.accordion-1 variant="info">Alimentación</b-button>
                  </b-card-header>
                  <b-collapse id="accordion-1" visible accordion="my-accordion" role="tabpanel">
                    <b-card-body>
                      <b-card-text class="text-justify">{{ text1 }}</b-card-text>
                    </b-card-body>
                  </b-collapse>
                </b-card>

                <b-card no-body class="mb-1">
                  <b-card-header header-tag="header" class="p-1" role="tab">
                    <b-button block v-b-toggle.accordion-2 variant="info">Higiene</b-button>
                  </b-card-header>
                  <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
                    <b-card-body>
                      <b-card-text class="text-justify">{{ text2 }}</b-card-text>
                    </b-card-body>
                  </b-collapse>
                </b-card>

                <b-card no-body class="mb-1">
                  <b-card-header header-tag="header" class="p-1" role="tab">
                    <b-button block v-b-toggle.accordion-3 variant="info">Salud</b-button>
                  </b-card-header>
                  <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
                    <b-card-body>
                      <b-card-text class="text-justify">{{ text3 }}</b-card-text>
                    </b-card-body>
                  </b-collapse>
                </b-card>
              </div>
            </div>
          </div>
        </div>
         <br></div>
        </div>
      </div>
    </div>
  </div>
</div>
  <footer><Footer></Footer></footer>
</div>
</template>

<script>
import LoggedHeader from "@/components/LoggedHeader";
import Footer from "../components/Footer";

export default {
  name: "CuidadosMascota",
  components: {
    LoggedHeader, Footer
  },
  data(){
    return {
      text1: 'Es muy importante para mantener a nuestro a animales de compañía que ingieran una dieta equilibrada que satisfaga sus necesidades energéticas y proporcione los nutrientes adecuados.',
      text2: 'Baño : Los expertos no se ponen de acuerdo en lo relativo a la frecuencia en la que se deben realizar los baños. En general esta no deberá ser inferior a una vez al mes. Algunos autores ' +
             'señalan que se debe hacer cuando lo necesitan, por ejemplo cuando el pelo está sucio. Aunque los gatos suelen ser menos tolerantes que los perros con el baño es posible hacer que el gatito lo acepte y que se acostumbre a ello. Se recomiendan geles especiales para animales de compañía.',
      text3: 'Vacunas: Lo primero que debes saber, es que si tu animal de compañía no está vacunado no puede entrar en contacto con otros animales ni con el exterior durante los dos primeros meses de vida. El plan de vacunación variará en función de la raza, estado inmunológico y estilo de vida. ' +
          'Lo diseñará nuestro veterinario y podrás comprobar lo beneficiosas que resultan para evitar enfermedades como parvovirosis, moquillo o hepatitis canina, en el caso de los perros, y otras como calicivirus, panleucopenia, rinotraqueítis, en el caso de los gatos.'
    }
  }

}
</script>

<style scoped>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css);

footer,

footer{
  bottom: 0.1cm;
  align-self: auto;
}

</style>