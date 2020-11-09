package com.unadopcion.unadopcion.herramientas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {

    private String fechaA;

    public Fecha() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fechaA = simpleDateFormat.format(date);
    }

    public String getFecha() {
        return fechaA;
    }
}
