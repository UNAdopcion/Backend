<template>
    <div>
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-6">
                <br>
                <br>
                <form>
                    <div class="row form-group">
                        <label class="col-sm-2 col-form-label">Nombre</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nombre" placeholder="Nombre">
                        </div>
                    </div>

                    <div class="row form-group">
                        <label class="col-sm-2 col-form-label">Correo</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="correo" placeholder="Correo">
                        </div>
                    </div>

                    <div class="row form-group">
                        <label class="col-sm-2 col-form-label">Tipo consulta</label>
                        <div class="col-sm-10">
                            <select class="custom-select" id="tipo de consulta" placeholder="Tipo de consulta">
                                <option selected>Seleccione</option>
                            </select>
                        </div>
                    </div>

                    <div class="row form-group">
                        <label class="col-sm-2 col-form-label">Celular</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="celular" placeholder="Celular (+57)">
                        </div>
                    </div>


                    <br>

                    <div class="row form-group">
                        <label class="col-sm-2 col-form-label">Consulta</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" rows="6" id="consulta" placeholder="¿Cómo podemos ayudarle?"></textarea>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-5"></div>
                        <div class="col-sm-3">
                            <div class="container">
                                <button type="button" class="btn btn-primary ">Enviar</button>
                            </div>
                        </div>
                    </div>

                </form>
        </div>


            <div class="col-md-1"></div>

            <div class="col-md-3"><!--Cargar imagen-->
                <br><br>
                <div class="row-md-4">
                    <h4>Estamos ubicados en:</h4>
                </div>
                <div class="row-md-4">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3976.7524163956505!2d-74.08623508505343!3d4.638199143487372!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8e3f9bd14943c13b%3A0x3de530667d9ff6b0!2sUniversidad%20Nacional%20de%20Colombia!5e0!3m2!1ses!2sco!4v1603042662423!5m2!1ses!2sco"
                    width="400" height="300" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                </div>

                <br><br><br>

                <div class="row-md-2">
                    <a href="https://api.whatsapp.com/send?phone=3203427095" class="mx-2">
                        <img src="@/assets/Wpp_ico.png" alt="whatsapp" height="100" width="100">
                    </a>
                </div>

                <div class="row-md-2">
                    <div class="container">
                        <h6>¡Escribenos a whatsapp!</h6>
                    </div>
                </div>
                <br><br><br><br>
                <div class="col-md-1"></div>
            </div>

        </div>
    </div>
</template>