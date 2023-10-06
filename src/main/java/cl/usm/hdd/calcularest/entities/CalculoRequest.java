package cl.usm.hdd.calcularest.entities;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Generated
@Setter
@ToString

public class
CalculoRequest {
    //El cuerpo de lo que va a tener la petición
    private int num1;
    private int num2;
    private String operacion;
}
