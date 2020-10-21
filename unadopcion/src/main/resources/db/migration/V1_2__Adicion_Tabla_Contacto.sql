drop table if exists contacto;

/*==============================================================*/
/* table: contacto                                             */
/*==============================================================*/
create table contacto
(
   contact_id              int not null auto_increment,
   contact_nombre              varchar (50) not null,
   contact_tipo_consulta          varchar(30) not null,
   contact_celular           varchar(15) not null,
   contact_consulta          varchar(255) not null,
   primary key (contact_id)
);