<template>
  <div id="contacto"><Header></Header>

    <br><br><br><br>

    <div class="row">
      <div class="col-md-1"></div>
      <div class="col md-8 ">
        <div class="col md-8 ">
          <h1 class="h12">¿Desea hablar con nosotros un caso particular?</h1>
          <h2 class="h12">¡Escribanos!</h2>
        </div>
        <br><br><br>
      </div>
    </div>

    <div class="row">
      <div class="col-md-1"></div>
      <div class="col-md-6">
        <br>
        <br>
        <form>

          <div class="row form-group">
            <label class="col-sm-2 col-form-label" for="nombreUsuario">Nombre </label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="nombreUsuario" placeholder="nombre" v-model="nombreusuario" required>
            </div>
          </div>


          <div class="row form-group">
            <label class="col-sm-2 col-form-label" for="correoUsuario">Correo</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="correoUsuario" placeholder="correo" v-model="correousuario" required>
            </div>
          </div>


          <div class="row form-group">
            <label class="col-sm-2 col-form-label" for="tipoConsulta">Tipo consulta</label>
            <div class="col-sm-10">
              <select class="custom-select" id="tipoConsulta" placeholder="tipo de consulta" v-model="tipoconsulta" required>
                <option selected>Seleccione</option>
              </select>
            </div>
          </div>

          <div class="row form-group">
            <label class="col-sm-2 col-form-label" for="celularUsuario">Celular</label>
            <div class="col-sm-10">
              <input type="number" class="form-control" id="celularUsuario" placeholder="celular" v-model="celular" required>
            </div>
          </div>


          <br>

          <div class="row form-group">
            <label class="col-sm-2 col-form-label" for="consulta">Consulta</label>
            <div class="col-sm-10">
              <textarea class="form-control" rows="6" id="consulta" placeholder="¿Cómo podemos ayudarle?" v-model="consulta" required></textarea>
            </div>
          </div>

          <div class="row">
            <div class="col-sm-5">
            </div>
            <div class="col-sm-3">
              <div class="container">
                <button v-on:click="enviarDatos" type="button" class="btn btn-primary ">Enviar</button>
              </div>
            </div>
          </div>

        </form>
      </div>


      <div class="col-md-1">
      </div>



      <div class="col-md-3">
        <br><br>
        <div class="row-md-4">
          <h4>Estamos ubicados en:</h4>
        </div>
        <div class="row-md-4">
          <iframe src="https://www.google.com/maps/embed?pb=!1m26!1m12!1m3!1d63628.03151359074!2d-74.11906618150445!3d4.638278489112571!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m11!3e6!4m5!1s0x8e3f9bd14943c13b%3A0x3de530667d9ff6b0!2sUniversidad%20Nacional%20de%20Colombia%2C%20Carrera%2045%2C%20Bogot%C3%A1!3m2!1d4.6381938!2d-74.08404639999999!4m3!3m2!1d4.638364!2d-74.0842189!5e0!3m2!1ses!2sco!4v1603212719656!5m2!1ses!2sco" width="400" height="300" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
        </div>
        <br><br><br><br><br><br><br><br><br>

        <div class="row-md-2">
          <div class="container">
            <a href="https://api.whatsapp.com/send?phone=3203427095" class="mx-2">
              <img src="@/assets/Wpp_ico.png" alt="whatsapp" height="100" width="100">
            </a>
          </div>
        </div>

        <div class="row-md-2">
          <div class="container">
            <h6>¡escribenos a whatsapp!</h6>
          </div>
        </div>


        <br><br><br><br><br><br>


        <div class="col-md-1"></div>
      </div>


    </div>

    <Footer></Footer>
  </div>

</template>

<script>
import Header from "@/components/Header";
import Footer from "@/components/Footer";
import EnviarDatosConsulta from "@/servicio/ContactoServicio";

export default {
  name: "Contacto",
  components: {
    Header, Footer
  },
  data() {
    return {
      nombreusuario: '',
      correousuario: '',
      tipoconsulta: '',
      celular: '',
      consulta: '',
    }
  },
  methods:{
    enviarDatos(e) {
      e.preventDefault();
      let objectoActual = this;
      //diccionario para ser convertido en JSON
      let infoEnvioDatos = {
        nombre: this.nombre,
        correousuario: this.correousuario,
        tipoconsulta: this.tipoconsulta,
        celular: this.celular,
        consulta: this.consulta,
      };

      this.enviar(objectoActual, infoEnvioDatos);
    },

    enviar(objetoActual, datos) {
      EnviarDatosConsulta.envioDatos(datos).then((respuesta) => {
        objetoActual.probar = respuesta.data;
        console.log(respuesta.data);
      });
    },
  }

}
</script>

