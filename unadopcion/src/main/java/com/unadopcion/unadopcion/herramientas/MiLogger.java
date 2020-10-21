package com.unadopcion.unadopcion.herramientas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiLogger {

    Logger logger;
    public MiLogger(Class clase){
        this.logger = LoggerFactory.getLogger(clase);
    }


    public void info(String mensaje){
        logger.info(mensaje);
    }

    public void cuidado(String mensaje){
        logger.warn(mensaje);
    }

    public void critico(String mensaje){
        logger.error(mensaje);
    }

    public void fatal(String mensaje){
        logger.error("ERROR FATAL:" + mensaje);

    }

}
