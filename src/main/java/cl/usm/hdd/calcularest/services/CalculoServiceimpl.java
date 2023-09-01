package cl.usm.hdd.calcularest.services;

import org.springframework.stereotype.Service;

@Service
public class CalculoServiceimpl implements CalculoService{
    //El servicio impl tiene la implementación del servicio y finalmente la lógica de negocio
    @Override
    public double calcular(int num1, int num2, String operacion) {
        switch (operacion){
            case "+": return num1 + num2;
            case "*": return num1 * num2;
            case "-": return num1 - num2;
            case "/": return (double)num1 / (double)num2;
            default: return 0;
        }
    }
}
