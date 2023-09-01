package cl.usm.hdd.calcularest.services;

import cl.usm.hdd.calcularest.exceptions.OperacionException;

public interface CalculoService {
    //La interfaz tiene el método que se va a implementar
    double calcular(int num1,int num2,String operacion) throws OperacionException;
}
