create database ams20241_anna;

create table ams20241_anna.usuarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255),
  senha VARCHAR(255),
  status VARCHAR(255),
  tipo VARCHAR(255),
  primary key (id));

create table ams20241_anna.veiculos (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modelo VARCHAR(255),
  cor VARCHAR(255),
  primary key (id));

create table ams20241_anna.usuarios_veiculos (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idU BIGINT NOT NULL,
  idV BIGINT NOT NULL,
  obs VARCHAR(255),
  primary key (id));

ALTER TABLE ams20241_anna.usuarios_veiculos ADD CONSTRAINT fk_usve FOREIGN KEY (idU) REFERENCES ams20241_anna.usuarios(id);
ALTER TABLE ams20241_anna.usuarios_veiculos ADD CONSTRAINT fk_veus FOREIGN KEY (idV) REFERENCES ams20241_anna.veiculos(id);

INSERT INTO `ams20241_anna`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('Anna', '123', 'ATIVO', 'ADM');
INSERT INTO `ams20241_anna`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('Carolina', '321', 'ATIVO', 'USER');

