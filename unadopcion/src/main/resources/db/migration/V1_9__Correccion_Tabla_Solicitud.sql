ALTER TABLE solicitud
ADD COLUMN persona_id int not null;

alter table solicitud add constraint fk_solicitud_Persona foreign key (persona_id)
        references  usuario(usuario_id) on delete restrict on update restrict;

alter table solicitud add constraint fk_solicitud_Animal foreign key (anim_id)
        references  animal(anim_id) on delete restrict on update restrict;