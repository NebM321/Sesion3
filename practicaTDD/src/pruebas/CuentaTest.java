
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

    @Test
    public void testTest0014() {
        Cuenta cuenta1 = new Cuenta("12345", "Ana", 50);
        Cuenta cuenta2 = new Cuenta("67890", "Luis", 0);

        // 1. Reintegro de 200 euros en la cuenta 12345
        cuenta1.retirar(200);

        // 2. Reintegro de 350 euros en la cuenta 67890
        cuenta2.retirar(350);

        // 3. Ingreso de 100 euros en la cuenta 12345
        cuenta1.ingresar(100);

        // 4. Reintegro de 200 euros en la cuenta 67890
        cuenta2.retirar(200);

        // 5. Reintegro de 150 euros en la cuenta 67890
        cuenta2.retirar(150);

        // 6. Reintegro de 200 euros en la cuenta 12345
        cuenta1.retirar(200);

        // 7. Ingreso de 50 euros en la cuenta 67890
        cuenta2.ingresar(50);

        // 8. Reintegro de 100 euros en la cuenta 67890
        cuenta2.retirar(100);

        assertEquals(-250, cuenta1.getSaldo(), 0.001);
        assertEquals(-450, cuenta2.getSaldo(), 0.001);
        

        // Comprobar el numero de movimientos de cada cuenta
        assertEquals(4, cuenta1.getMovimientos().size());
        assertEquals(3, cuenta2.getMovimientos().size());
        

        assertEquals(0, cuenta1.getErrores().size());
        assertEquals(2, cuenta2.getErrores().size());

        assertEquals(
            "Fondos insuficientes (saldo -350.0 euros) para el reintegro de 200.0 euros",
            cuenta2.getErrores().get(0)
        );

        assertEquals(
            "Fondos insuficientes (saldo -450.0 euros) para el reintegro de 100.0 euros",
            cuenta2.getErrores().get(1)
        );


    }


}
