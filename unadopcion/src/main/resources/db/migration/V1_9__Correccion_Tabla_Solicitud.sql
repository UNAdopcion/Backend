ALTER TABLE solicitud
ADD COLUMN personaid int not null;

alter table solicitud add constraint fk_solicitud_Persona foreign key (personaid)
        references  usuario(usuario_id) on delete restrict on update restrict;

alter table solicitud add constraint fk_solicitud_Animal foreign key (animid)
        references  animal(anim_id) on delete restrict on update restrict;