drop table if exists calificacion;

/*==============================================================*/
/* table: calificacion                                          */
/*==============================================================*/
create table calificacion
(
    usuario_calificado          int not null,
    usuario_calificador         int not null,
    puntaje                     double not null,
    fecha                       varchar(32) not null,
    comentario                  varchar(500) not null,
    primary key (usuario_calificador,usuario_calificado)
);

alter table calificacion add constraint fk_calificado foreign key (usuario_calificado)
    references usuario (usuario_id) on delete restrict on update restrict;

alter table calificacion add constraint fk_calificador foreign key (usuario_calificador)
    references usuario (usuario_id) on delete restrict on update restrict;