
package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import practica3.Cuenta;

public class CuentaTest {

    @Test
    public void testIngresar() {
        Cuenta cuenta = new Cuenta("12345", "Ana", 50);

        cuenta.ingresar(100);

        assertEquals(150, cuenta.getSaldo(), 0.001);
    }

    @Test
    public void testRetirar() {
        Cuenta cuenta = new Cuenta("12345", "Ana", 50);

        cuenta.retirar(200);

        assertEquals(-150, cuenta.getSaldo(), 0.001);
    }

    @Test
    public void testLimiteDescubierto() {
        Cuenta cuenta = new Cuenta("67890", "Luis", 0);

        cuenta.retirar(350);
        cuenta.retirar(200);

        assertEquals(-350, cuenta.getSaldo(), 0.001);
    }

}
