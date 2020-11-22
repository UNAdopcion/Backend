
drop table if exists adopcion;

drop table if exists animal;

drop table if exists animal_vacuna;

drop table if exists denuncia;

drop table if exists logeo;

drop table if exists registro;

drop table if exists solicitud;

drop table if exists usuario;

drop table if exists vacuna;

drop table if exists veterinaria;

/*==============================================================*/
/* table: adopcion                                              */
/*==============================================================*/
create table adopcion
(
   adop_id              int not null auto_increment,
   anim_id              int not null,
   usuario_id           int not null,
   adop_fecha           varchar(32) not null,
   adop_estado          varchar(32) NOT NULL,
   primary key (adop_id)
);

/*==============================================================*/
/* table: animal                                                */
/*==============================================================*/
create table animal
(
   anim_id              int not null auto_increment,
   adop_id              int,
   regis_id             int not null,
   anim_nombre          varchar(100) not null,
   anim_tipo            varchar(100) not null,
   anim_lugar           varchar(255) not null,
   anim_descrip         varchar(255) not null,
   anim_foto            longblob not null,
   anim_edad            int,
   anim_sexo            varchar(10),
   primary key (anim_id)
);

/*==============================================================*/
/* table: animal_vacuna                                         */
/*==============================================================*/
create table animal_vacuna
(
   anim_vac_id          int not null auto_increment,
   anim_id              int not null,
   vacuna_id            varchar(32) not null,
   vet_id               int not null,
   primary key (anim_vac_id)
);

/*==============================================================*/
/* table: denuncia                                              */
/*==============================================================*/
create table denuncia
(
   denun_id             int not null auto_increment,
   usuario_id           int not null,
   denun_fecha          varchar(32) not null,
   denun_tipo           varchar(32),
   denun_descrip        varchar(255) not null,
   primary key (denun_id)
);

/*==============================================================*/
/* table: logeo                                                 */
/*==============================================================*/
create table logeo
(
   logeo_id             int not null auto_increment,
   usuario_id           int,
   logeo_nombre         varchar(100) not null,
   logeo_contra         varchar(255) not null,
   primary key (logeo_id)
);

/*==============================================================*/
/* table: registro                                              */
/*==============================================================*/
create table registro
(
   regis_id             int not null auto_increment,
   usuario_id           int not null,
   anim_id              int,
   regis_fecha          varchar(32) not null,
   primary key (regis_id)
);

create table solicitud
(
   id           int not null auto_increment,
   animid       int not null,
   fecha        varchar(32) not null,
   estado       varchar(32) not null,
   primary key (id)
);

/*==============================================================*/
/* table: usuario                                               */
/*==============================================================*/
create table usuario
(
   usuario_id           int not null auto_increment,
   logeo_id             int not null,
   usuario_nombre       varchar(100) not null,
   usuario_rol          varchar(32) not null,
   usuario_puntos       float(8,0) not null,
   usuario_email        varchar(32),
   usuario_telefono     varchar(15) not null,
   usuario_lugar        varchar(255),
   usuario_info         varchar(255),
   usuario_foto         longblob,
   primary key (usuario_id)
);

/*==============================================================*/
/* table: vacuna                                                */
/*==============================================================*/
create table vacuna
(
   vacuna_id            varchar(32) not null,
   vacuna_foto          longblob,
   primary key (vacuna_id)
);

/*==============================================================*/
/* table: veterinaria                                           */
/*==============================================================*/
create table veterinaria
(
   vet_id               int not null auto_increment,
   vet_lugar            varchar(255) not null,
   primary key (vet_id)
);

create table hibernate_sequence ( next_val bigint not null); 

alter table adopcion add constraint fk_adoptado2 foreign key (anim_id)
      references animal (anim_id) on delete restrict on update restrict;

alter table adopcion add constraint fk_adoptador foreign key (usuario_id)
      references usuario (usuario_id) on delete restrict on update restrict;

alter table animal add constraint fk_adoptado foreign key (adop_id)
      references adopcion (adop_id) on delete restrict on update restrict;

alter table animal add constraint fk_registrado foreign key (regis_id)
      references registro (regis_id) on delete restrict on update restrict;

alter table animal_vacuna add constraint fk_vacunado foreign key (anim_id)
      references animal (anim_id) on delete restrict on update restrict;

alter table animal_vacuna add constraint fk_vacuna_aplicada foreign key (vacuna_id)
      references vacuna (vacuna_id) on delete restrict on update restrict;

alter table animal_vacuna add constraint fk_vet_vacuna_anim foreign key (vet_id)
      references veterinaria (vet_id) on delete restrict on update restrict;

alter table denuncia add constraint fk_denunciado foreign key (usuario_id)
      references usuario (usuario_id) on delete restrict on update restrict;

alter table logeo add constraint fk_logeado2 foreign key (usuario_id)
      references usuario (usuario_id) on delete restrict on update restrict;

alter table registro add constraint fk_registrado2 foreign key (anim_id)
      references animal (anim_id) on delete restrict on update restrict;

alter table solicitud add constraint fk_solicitado foreign key (animid)
      references animal (anim_id) on delete restrict on update restrict;

alter table usuario add constraint fk_logeado foreign key (logeo_id)
      references logeo (logeo_id) on delete restrict on update restrict;


