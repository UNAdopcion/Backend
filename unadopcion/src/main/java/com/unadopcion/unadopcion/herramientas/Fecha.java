package com.unadopcion.unadopcion.herramientas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {

    private String fecha;

    public Fecha() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fecha = simpleDateFormat.format(date);
    }

    public String getFecha() {
        return fecha;
    }
}
