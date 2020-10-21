import axios from "axios";

const UNADOPCION_API_URL = "http://localhost:8080";
const CONTROLADOR = "/mostrar-perfil";

class MostrarPerfil{
    mostrarPerfil(nombreUsuario){
        return axios.post(UNADOPCION_API_URL + CONTROLADOR, {
            nombre:nombreUsuario//json con un campo
        } );
    }
}

export default new MostrarPerfil();