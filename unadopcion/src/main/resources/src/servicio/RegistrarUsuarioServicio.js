import axios from "axios";

const UNADOPCION_API_URL = "http://localhost:8181";
const CONTROLADOR = "/crearusuario";

class RegistrarUsuarioServicio{
    registrarUsuario(info){
        return axios.post(UNADOPCION_API_URL + CONTROLADOR, {
            nombre:info.nombre,
            correo:info.correo,
            telefono:info.telefono,
            contrasena:info.contrasena
        });
    }
}

export default new RegistrarUsuarioServicio();