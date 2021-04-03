insert into entrada (id_tipo_vehiculo, marca_vehiculo, modelo_vehiculo, placa_vehiculo, fecha, registra_salida, tarifa_dia)
values ('1', 'BMW', '123', 'PLC-VAL', '2020-06-06', '1', 1000);
insert into salida (id_entrada, valor_tarifa, fecha)
values ('1', 1000, '2020-06-06');

update comun_parqueadero set capacidad_maxima = 2 where id_tipo_vehiculo = 1;

update comun_parqueadero set capacidad_maxima = 2 where id_tipo_vehiculo = 2;