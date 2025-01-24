CREATE TABLE IF NOT EXISTS moneda_cambio (
 id INT NOT NULL AUTO_INCREMENT,
 codigo varchar(5),
 moneda VARCHAR(50),
 tasa_conversion numeric(20,2),
 PRIMARY KEY (id));

 CREATE TABLE IF NOT EXISTS usuario (
  id INT NOT NULL AUTO_INCREMENT,
  username varchar(100),
  password VARCHAR(250),
  roles varchar(20),
  PRIMARY KEY (id));

  CREATE TABLE IF NOT EXISTS auditoria_cambio (
   id INT NOT NULL AUTO_INCREMENT,
   id_usuario INT,
   moneda_base varchar(20),
   tasa_moneda_base numeric(20,2),
   monto_base numeric(20,2),
   moneda_objetivo varchar(20),
   tasa_moneda_objetivo numeric(20,2),
   monto_resultado numeric(20,2),
   fecha_conversion timestamp,
   PRIMARY KEY (id),
   foreign key (id_usuario) references usuario(id));