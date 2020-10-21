import axios from "axios";

const UNADOPCION_API_URL = "http://localhost:8181";
const CONTROLADOR = "/hacer-login";

class LoginService{
    login(datos){
        console.log("SE HA REALIZADO EL LOGIN", datos)
        return axios.post(UNADOPCION_API_URL + CONTROLADOR, {
            nombre: datos.nombre,
            contrasena: datos.contrasena
        });
    }
}

export default new LoginService();