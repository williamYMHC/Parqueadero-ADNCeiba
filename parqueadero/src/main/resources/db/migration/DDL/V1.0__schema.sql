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

insert into comun_parqueadero(id_tipo_vehiculo,capacidad_maxima) values ('1', '2');
insert into comun_parqueadero(id_tipo_vehiculo,capacidad_maxima) values ('2', '2');

create table comun_tarifas(
 id int(11) not null auto_increment,
 id_tipo_vehiculo int(11) not null,
 tipo_dia varchar(40) not null,
 tarifa int not null,
 primary key (id),
 FOREIGN KEY (id_tipo_vehiculo) REFERENCES tipo_vehiculo(id),
 CONSTRAINT UN_tarifa UNIQUE (id_tipo_vehiculo,tipo_dia)
);

insert into comun_tarifas(id_tipo_vehiculo, tipo_dia, tarifa) values ('1', 'LUNESAVIERNES', 1000);
insert into comun_tarifas(id_tipo_vehiculo, tipo_dia, tarifa) values ('2','LUNESAVIERNES', 600);

create table entrada (
 id int(11) not null auto_increment,
 id_tipo_vehiculo int(11) not null,
 marca_vehiculo varchar(100) not null,
 modelo_vehiculo varchar(100) not null,
 placa_vehiculo varchar(7) not null,
 fecha datetime not null,
 registra_salida TINYINT(1) null,
 tarifa_dia float not null,
 primary key (id),
 FOREIGN KEY (id_tipo_vehiculo) REFERENCES tipo_vehiculo(id)
);

create table salida (
 id int(11) not null auto_increment,
 id_entrada int(11) not null,
 valor_tarifa float not null,
 fecha datetime not null,
 primary key (id),
 FOREIGN KEY (id_entrada) REFERENCES entrada(id)
);