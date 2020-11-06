drop table if exists animal_vacuna;
drop table if exists vacuna;

/*==============================================================*/
/* table: vacuna                                              */
/*==============================================================*/
create table vacuna
(
   vacuna_id            int not null auto_increment,
   vacuna_nombre        varchar(50) not null,
   vacuna_tipo          varchar(50) not null,
   vacuna_clase         varchar(50) not null,
   primary key (vacuna_id)
);

/*==============================================================*/
/* table: animal_vacuna                                         */
/*==============================================================*/
create table animal_vacuna
(
   anim_vac_id          int not null auto_increment,
   anim_id              int not null,
   vacuna_id            int not null,
   vet_id               int not null,
   vacuna_foto          longblob,
   primary key (anim_vac_id)
);