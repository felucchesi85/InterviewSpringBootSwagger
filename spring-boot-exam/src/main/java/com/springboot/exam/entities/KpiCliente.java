package com.springboot.exam.entities;

public class KpiCliente {

    double promedio =0 ;
    double desviacion =0;

    public KpiCliente(){

    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getDesviacion() {
        return desviacion;
    }

    public void setDesviacion(double desviacion) {
        this.desviacion = desviacion;
    }

}
