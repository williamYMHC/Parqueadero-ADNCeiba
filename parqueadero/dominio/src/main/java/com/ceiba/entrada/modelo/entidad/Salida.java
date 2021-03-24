package com.ceiba.entrada.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
public class Salida {

    private Long id;
    private Entrada entrada;
    private LocalDateTime fechaSalida;
    private float valorTotal;

    public Salida(Long id, Entrada entrada) {
        this.id=id;
        this.entrada=entrada;
        this.fechaSalida = LocalDateTime.now();
        this.calcularValorTarifa();
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void calcularValorTarifa(){
        LocalDateTime fechaEntrada = entrada.getFecha();
        float result =  ChronoUnit.MINUTES.between(fechaEntrada, this.fechaSalida);
        if((result-15)<=0){
            valorTotal=0;
        }else{
            if(result % 15==0){
                valorTotal=(result/15)*entrada.getTarifaDia();
            }else{
                float valor = (int)(result/15);
                valorTotal=(valor+1)*entrada.getTarifaDia();
            }
        }
    }

}
