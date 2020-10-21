import axios from "axios";

const UNADOPCION_API_URL = "http://localhost:8080";
const CONTROLADOR = "/hacer-logeo";

class RealizarLogeoServicio{
    hacerLogeo(datos){
        return axios.post(UNADOPCION_API_URL + CONTROLADOR, {
            nombre: datos.nombre,
            contrasena: datos.contrasena
        });
    }
}

export default new RealizarLogeoServicio();