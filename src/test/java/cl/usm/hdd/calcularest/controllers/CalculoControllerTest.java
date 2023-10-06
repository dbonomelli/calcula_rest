package cl.usm.hdd.calcularest.controllers;

import cl.usm.hdd.calcularest.entities.CalculoRequest;
import cl.usm.hdd.calcularest.entities.CalculoResponse;
import cl.usm.hdd.calcularest.exceptions.OperacionException;
import cl.usm.hdd.calcularest.services.CalculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculoControllerTest {
    @Mock
    private CalculoService calculoService;

    private CalculoController calculoController;
    /**
     * Este metodo se ejecuta antes de cada prueba
     * (como metodos @test)
     */
    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
        this.calculoController = new CalculoController(calculoService);

    }
    /**
     * Evalua si el controlador se llama con parámetros válidos responda ResponseEntitiy.ok
     */
    @Test
    void calcularOk() throws OperacionException {
        when(calculoService.calcular(anyInt(), anyInt(), anyString())).thenReturn(1.0);
        CalculoRequest request = new CalculoRequest();
        request.setNum1(5);
        request.setNum2(7);
        request.setOperacion("*");
        ResponseEntity<CalculoResponse> res = calculoController.calcular(request);

        assertEquals(HttpStatus.OK, res.getStatusCode());
    }

    @Test
    void calcularOperacionExceptionFail() throws OperacionException{
        when(calculoService.calcular(anyInt(), anyInt(), anyString())).thenThrow(new OperacionException());

        CalculoRequest request = new CalculoRequest();
        request.setNum1(5);
        request.setNum2(7);
        request.setOperacion("*");


        ResponseEntity<CalculoResponse> res = calculoController.calcular(request);

        assertEquals(HttpStatus.BAD_REQUEST, res.getStatusCode());
    }

    @Test
    void calcularAnyOtherException() throws OperacionException{
        when(calculoService.calcular(anyInt(), anyInt(), anyString())).thenThrow(new NullPointerException());

        CalculoRequest request = new CalculoRequest();
        request.setNum1(5);
        request.setNum2(7);
        request.setOperacion("*");


        ResponseEntity<CalculoResponse> res = calculoController.calcular(request);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, res.getStatusCode());
    }

}