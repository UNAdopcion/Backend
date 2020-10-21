import axios from "axios";

const UNADOPCION_API_URL = "http://localhost:8080";
const CONTROLADOR = "/contacto";

class EnviarDatosConsultaServicio{


    envioDatos(tipo){
        console.log(tipo.nombre);
        console.log(tipo.correousuario);
        return axios.post(UNADOPCION_API_URL + CONTROLADOR, {

            nombre: tipo.nombre,
            correousuario: tipo.correousuario,
            tipoconsulta: tipo.tipoconsulta,
            celular: tipo.celular,
            consulta: tipo.consulta,

        } );


    }
}

export default new EnviarDatosConsultaServicio();
