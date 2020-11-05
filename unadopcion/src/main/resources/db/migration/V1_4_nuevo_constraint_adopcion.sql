alter table adopcion add constraint fk_adoptado foreign key (anim_id)
      references animal (anim_id) on delete restrict on update restrict;

alter table adopcion add constraint fk_adoptador foreign key (usuario_id)
      references usuario (usuario_id) on delete restrict on update restrict;

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

alter table registro add constraint fk_registra foreign key (usuario_id)
      references usuario (usuario_id) on delete restrict on update restrict;

alter table registro add constraint fk_registrado2 foreign key (anim_id)
      references animal (anim_id) on delete restrict on update restrict;

alter table solicitud add constraint fk_solicitado foreign key (anim_id)
      references animal (anim_id) on delete restrict on update restrict;

alter table usuario add constraint fk_logeado foreign key (logeo_id)
      references logeo (logeo_id) on delete restrict on update restrict;