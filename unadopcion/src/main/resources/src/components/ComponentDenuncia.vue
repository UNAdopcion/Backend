<template>
  <div class="row">
    <div class="col-3"></div>
    <div class="col-6 mb-4">
      <br><br>
      <div class="container">
        <h2 class="titulo">Sección de Denuncias</h2>
        <br>
        <p class="texto"> Llene los campos de la persona a denuncias, a continuación escoja las opciones de acuerdo al
          caso de maltrato del cual usted ha sido testigo:</p><br>
        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label class="control-label col-sm-2" for="usuario">Usuario:</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="usuario"
                placeholder="Ingrese el identificador del usuario a denunciar">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2" for="nombre">Nombre:</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="nombre" placeholder="Ingrese nombres y apellidos">
            
            </div>
          </div>
          </form>
      </div>
      <br>
      <div class="container">
        <p class="texto"> Ingrese el tipo de maltrato: </p>
        <div class="form-group">
          <div class="panel panel-default">
            <div class="col-sm-offset-5 col-sm-10">
              <div class="checkbox">
                <label><input type="checkbox"> Abandono</label>
              </div>
              <div class="checkbox">
                <label><input type="checkbox"> Maltrato físico</label>
              </div>
              <div class="checkbox">
                <label><input type="checkbox"> Crueldad animal</label>
              </div>
              <div class="checkbox">
                <label><input type="checkbox"> Envenenamiento</label>
              </div>
              <div class="checkbox">
                <label><input type="checkbox"> Explotación animal</label>
              </div>
              <div class="checkbox">
                <label><input type="checkbox"> Trafico animal</label>
              </div>
            </div>
          </div>
        </div>
      </div><br>

      <div class="row">
        <div class="col-12">
          <div class="container">
            <p class="texto">Puede cargar una evidencia fotografica del maltrato como fotografia del maltrato,
              fotografia animal ó historia clinica: </p>
            <div class="container">
              <div class="form-group ">
                <!--Cargar imagen-->
                <div class="row my-auto">
                  <img src="@/assets/subir-imagen.png" alt="" width="200px" class="mx-auto">
                </div>
                <div class="row">
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
          </div><br>
        </div>
      </div>
      <div class="row">
        <div class="col-12">
          <div class="container">
            <p class="texto"> Ingrese el tipo de maltrato: </p>
            <div class="form-group">
              <div class="panel panel-default">
                <div class="col-sm-offset-5 col-sm-10">
                  <div class="checkbox">
                    <label><input type="checkbox">¿Hubo complices?</label>
                  </div>
                  <div class="checkbox">
                    <label><input type="checkbox">¿Golpes contundentes?</label>
                  </div>
                  <div class="checkbox">
                    <label><input type="checkbox">¿Causó traumas?</label>
                  </div>
                  <div class="checkbox">
                    <label><input type="checkbox">¿Estuvo en el lugar?</label>
                  </div>
                  <div class="checkbox">
                    <label><input type="checkbox">¿Hubo armas?</label>
                  </div>
                  <div class="checkbox">
                    <label><input type="checkbox">¿Es reincidente?</label>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-12 text-right">
          <button type="submit" class="btn btn-primary">Enviar</button>
        </div>
      </div>
    </div>
    <div class="col-3"></div>

  </div>
</template>