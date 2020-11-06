ALTER TABLE usuario
ADD COLUMN usuario_nombre_real varchar(255) not null;

ALTER TABLE usuario
ADD COLUMN usuario_google_id varchar(255) not null;

ALTER TABLE usuario
ADD COLUMN usuario_url_foto varchar(5000) not null;

