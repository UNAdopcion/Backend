drop table if exists denuncia;
/*==============================================================*/
/* table: denuncia                                              */
/*==============================================================*/
create table denuncia
(
   denun_id             int not null auto_increment,
   usuario_id           int not null,
   animal_id            int not null,
   denun_fecha          varchar(32) not null,
   denun_tipo           varchar(32),
   denun_descrip        varchar(255) not null,
   detalles             varchar(255) null,
   primary key (denun_id)
);