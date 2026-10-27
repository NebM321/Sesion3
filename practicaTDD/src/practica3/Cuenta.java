
package practica3;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {

    private String mNumero;
    private String nTitular;
    private List<Movimiento> mMovimientos;
    private double saldo;
    

    private List<String> errores;

    public Cuenta(String numero, String titular, double saldoInicial) {
        mNumero = numero;
        nTitular = titular;
        saldo = saldoInicial;
        mMovimientos = new ArrayList<>();

        if (saldoInicial != 0) {
            mMovimientos.add(
                new Movimiento(saldoInicial, Movimiento.Signo.H, "Saldo inicial")
            );
        }
        errores = new ArrayList<>();
    }

    public void ingresar(double x) {
        saldo = saldo + x;

        mMovimientos.add(
            new Movimiento(x, Movimiento.Signo.H, "Ingreso")
        );
    }



public void retirar(double x) {
    if (saldo - x >= -500) {
        saldo = saldo - x;

        mMovimientos.add(
            new Movimiento(x, Movimiento.Signo.D, "Reintegro")
        );
    } else {
        errores.add(
            "Fondos insuficientes (saldo " + saldo
            + " euros) para el reintegro de " + x + " euros"
        );
    }
}



    public double getSaldo() {
        return saldo;
    }

    public List<Movimiento> getMovimientos() {
        return mMovimientos;
    }

public List<String> getErrores() {
    return errores;
}

}

