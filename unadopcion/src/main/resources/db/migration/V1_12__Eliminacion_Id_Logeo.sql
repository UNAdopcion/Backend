alter table logeo drop constraint fk_logeado2;
alter table logeo drop column usuario_id;
alter table animal drop constraint fk_registrado;
alter table animal drop column regis_id;
alter table animal drop constraint fk_adoptado;
alter table animal drop column adop_id;

