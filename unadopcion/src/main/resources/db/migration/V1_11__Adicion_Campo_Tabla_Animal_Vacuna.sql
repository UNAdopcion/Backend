drop table if exists animal_vacuna;

/*==============================================================*/
/* table: animal_vacuna                                         */
/*==============================================================*/
create table animal_vacuna
(
    anim_vac_id          int not null auto_increment,
    anim_vac_fecha       varchar(32) not null,
    anim_id              int not null,
    vacuna_id            int not null,
    veterinaria_id       int not null,
    vacuna_foto          longblob,
    primary key (anim_vac_id)
);

alter table animal_vacuna add constraint fk_vacunado foreign key (anim_id)
references animal (anim_id) on delete restrict on update restrict;

alter table animal_vacuna add constraint fk_vacuna_aplicada foreign key (vacuna_id)
references vacuna (vacuna_id) on delete restrict on update restrict;

alter table animal_vacuna add constraint fk_vet_vacuna_anim foreign key (veterinaria_id)
references veterinaria (veterinaria_id) on delete restrict on update restrict;