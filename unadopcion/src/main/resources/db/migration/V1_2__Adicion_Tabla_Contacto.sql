drop table if exists contacto;

/*==============================================================*/
/* table: contacto                                             */
/*==============================================================*/
create table contacto
(
   contacto_id                int not null auto_increment,
   contacto_nombre            varchar (50) not null,
   contacto_correo            varchar (50) not null,
   contacto_tipo              varchar(30) not null,
   contacto_celular           varchar(15) not null,
   contacto_consulta          varchar(255) not null,
   primary key (contacto_id)
);