select entrada.id, entrada.id_tipo_vehiculo, entrada.marca_vehiculo, entrada.modelo_vehiculo,
entrada.placa_vehiculo, entrada.fecha, entrada.registra_salida, entrada.tarifa_dia, salida.fecha as fecha_salida, salida.valor_tarifa
from entrada
inner join salida on salida.id_entrada = entrada.id
where entrada.registra_salida='1';