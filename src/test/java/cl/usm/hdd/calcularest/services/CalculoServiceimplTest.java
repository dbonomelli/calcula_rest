package cl.usm.hdd.calcularest.services;

import cl.usm.hdd.calcularest.exceptions.OperacionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculoServiceimplTest {
    CalculoService calculoService;
    @BeforeEach
    void init(){
        calculoService = new CalculoServiceimpl();
    }
    @Test
    void calcularSuma() throws OperacionException {

        double res = calculoService.calcular(1, 2, "+");
        assertEquals(3, res);
    }
    @Test
    void calcularResta() throws  OperacionException {
        double res = calculoService.calcular(1, 2, "-");
        assertEquals(-1, res);
    }
    @Test
    void calcuarMultiplicacion() throws OperacionException{
        double res = calculoService.calcular(1,2, "*");
        assertEquals(2, res);
    }

    @Test
    void calcularDivisionOk() throws OperacionException {
        double res = calculoService.calcular(4,2,"/");
        assertEquals(2, res);
    }

    @Test
    void calcularDivisionNotOk(){
        boolean ok = true;
        try{
            double res = calculoService.calcular(1,0,"/");
        }catch (Exception ex){
            ok = false;

        }
        assertFalse(ok);
    }

    @Test
    void calcularOperacionNotOk(){
        boolean ok = true;
        try{
            double res = calculoService.calcular(1,2,"ç");
        }catch (Exception ex){
            ok = false;
        }

        assertFalse(ok);
    }
}