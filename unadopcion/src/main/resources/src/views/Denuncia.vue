<template>
    <!--<h1>SECCION DE DENUNCIAS</h1>-->
    <div id="denuncia"><LoggedHeader></LoggedHeader>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header"><b>SECCIÓN DE DENUNCIAS</b></div>
            </div>
          </div>
        </div>
      </div>

      <br><div class="container">
        <div class="row justify-content-center">
          <div class="col-md-8">
            <div class="container">
              <div class="block">
                <p style="text-align: left" class="text-info"> Llene los campos de la persona a denuncias, a continuación escoja las opciones de acuerdo al
              caso de maltrato del cual usted ha sido testigo:</p>
              </div>
            </div>
            <div class="card">
              <div class="container">
                <form class="form-horizontal" role="form">
                  <br><div class="form-row">
                    <label class="control-label col-sm-2" for="nombreUsuario">Usuario:</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="nombreUsuario"
                                 placeholder="Ingrese el identificador del usuario a denunciar" v-model="nombreusuario" required>
                        </div>
                  </div>
                  <br><div class="form-row">
                    <label class="control-label col-sm-2" for="tipo">Tipo:</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="tipo"
                                 placeholder="Ingrese el tipo de la mascota" v-model="animaltipo" required>
                        </div>
                  </div>

                  <br><div class="form-row">
                    <label class="control-label col-sm-2" for="nombreMascota">Nombre Mascota:</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="nombreMascota"
                                 placeholder="Ingrese el nombre de la mascota" v-model="animalnombre" required>
                        </div>
                  </div>
                </form>
              </div>
            </div>

            <br><div class="container">
            <div class="block">
            <p style="text-align: left" class="text-info"> Seleccione el tipo de maltrato: </p>
            </div></div>

            <div class="card">
              <div class="container">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                      <div class="panel panel-default">
                        <div class="col-sm-offset-5 col-sm-10">
                          <br>
                          <select class="browser-default custom-select" v-model="tipomaltrato" required>
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
                  </div>
                </form>
              </div>
            </div>

            <br><div class="container">
            <div class="block">
              <p style="text-align: left" class="text-info"> Selecione el estado final del animal vinvulado a este maltrato: </p>
            </div></div>

            <div class="card">
              <div class="container">
                <form class="form-horizontal" role="form">
                  <div class="form-group">
                    <div class="panel panel-default">
                      <div class="col-sm-offset-5 col-sm-10">
                        <br>
                        <select class="browser-default custom-select" v-model="estadofinal" required>
                          <option selected></option>
                          <option>Herido</option>
                          <option>Lesión Temporal</option>
                          <option>Lesión Permanente</option>
                          <option>Muerto</option>
                        </select>
                      </div>
                    </div>
                  </div>
                </form>
              </div>
            </div>

            <br><div class="container">
            <div class="block">
              <p style="text-align: left" class="text-info"> Puede cargar una evidencia fotografica del maltrato como fotografia del maltrato,
                denuncia ante autoridades competentes ó historia clinica del animal vinculado al maltrato: </p>
            </div></div>

            <br><div class="container">
              <div class="form-group ">
                <!--Cargar imagen-->
                <div class="row my-auto">
                  <img src="@/assets/subir-imagen.png" alt="" width="200px" class="mx-auto">
                </div>
                <br><div class="row">
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Upload</span>
                    </div>
                    <div class="custom-file">
                      <input type="file" class="custom-file-input" id="inputGroupFile01">
                      <label class="custom-file-label" for="inputGroupFile01">Selecionar foto </label>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>
        </div>
      </div>
      <Footer></Footer>
    </div>
</template>

<script>

import Footer from "../components/Footer";
import LoggedHeader from "@/components/LoggedHeader";

export default {
  name: "Denuncia",
  components: {
    LoggedHeader, Footer,
  },
  data() {
    return {
      nombreusuario: '',
      animalnombre: '',
      animaltipo: '',
      tipomaltrato: '',
      estadofinal: '',
      evidencia: '',
    }
  }
}
</script>

<style scoped>

</style>