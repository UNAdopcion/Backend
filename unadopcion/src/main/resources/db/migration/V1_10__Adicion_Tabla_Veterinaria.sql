drop table if exists veterinaria;

/*==============================================================*/
/* table: calificacion                                          */
/*==============================================================*/
create table veterinaria
(
    veterinaria_id              int not null auto_increment,
    nombre                      varchar(200),
    latitud                     float not null,
    longitud                    float not null,
    direccion                   varchar(500),
    numero                      int(10),
    sitio_web                   varchar(200),
    descripcion                 varchar(500),
    fecha                       varchar(32) not null,
    primary key (veterinaria_id)
);

