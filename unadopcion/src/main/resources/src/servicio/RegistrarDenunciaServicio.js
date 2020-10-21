import axios from "axios";

const UNADOPCION_API_URL = "http://localhost:8080";
const CONTROLADOR = "/denunciarmaltrato";

class RegistrarDenunciaServicio {
    registrarDenuncia(info){
        return axios.post(UNADOPCION_API_URL + CONTROLADOR, {
            nombre:info.nombre,
            tipo:info.tipo,
            descripcion:info.descripcion,
        });
    }
}

export default new RegistrarDenunciaServicio();