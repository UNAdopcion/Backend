
import axios from "axios";

const UNADOPCION_API_URL = "http://localhost:8080";
const CONTROLADOR = "/buscarmascota";

class BusquedaMascotaServicio{
    buscarPorTipo(tipo){
        return axios.post(UNADOPCION_API_URL + CONTROLADOR, {
            tipo:tipo//json con un campo
        } );
    }
}

export default new BusquedaMascotaServicio();