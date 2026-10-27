
package practica3;

public class Cuenta {

    private String mNumero;
    private String nTitular;
    private double saldo;

    public Cuenta(String numero, String titular, double saldoInicial) {
        mNumero = numero;
        nTitular = titular;
        saldo = saldoInicial;
    }

    public void ingresar(double x) {
        saldo = saldo + x;
    }

    public double getSaldo() {
        return saldo;
    }
}

