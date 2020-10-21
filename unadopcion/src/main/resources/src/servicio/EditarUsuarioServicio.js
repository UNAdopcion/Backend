import axios from "axios";

const UNADOPCION_API_URL = "http://localhost:8080";
const CONTROLADOR = "/editar-usuario";

class EditarUsuarioServicio{
    EditarUsuario(info){
        console.log("this is Editar", info);
        return axios.post(UNADOPCION_API_URL + CONTROLADOR, {
            nombre: info.nombre,
            contrasena: info.contrasena,
            rol: info.rol,
            correo: info.correo,
            telefono: info.telefono,
            lugar: info.lugar,
            info: info.info,
        });
    }
}

export default new EditarUsuarioServicio();