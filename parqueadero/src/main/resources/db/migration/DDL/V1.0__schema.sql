create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table tipo_vehiculo (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 primary key (id)
);
insert into tipo_vehiculo(nombre) values ('carro');
insert into tipo_vehiculo(nombre) values ('moto');

create table comun_parqueadero(
 id int(11) not null auto_increment,
 id_tipo_vehiculo int(11) not null,
 capacidad_maxima int not null,
 fecha_actualizacion datetime null,
 primary key (id),
 FOREIGN KEY (id_tipo_vehiculo) REFERENCES tipo_vehiculo(id)
);

insert into comun_parqueadero(id_tipo_vehiculo,capacidad_maxima) values ('1', '1');
insert into comun_parqueadero(id_tipo_vehiculo,capacidad_maxima) values ('2', '1');



create table entrada (
 id int(11) not null auto_increment,
 id_tipo_vehiculo int(11) not null,
 marca_vehiculo varchar(100) not null,
 modelo_vehiculo varchar(100) not null,
 placa_vehiculo varchar(7) not null,
 fecha datetime not null,
 registra_salida TINYINT(1) null,
 primary key (id),
 FOREIGN KEY (id_tipo_vehiculo) REFERENCES tipo_vehiculo(id)
);