package Model;

public class CuentaCorriente extends CuentaBancaria {
    private String lineaSobregiro;

    public CuentaCorriente(String numeroDeCuenta, String fechaApertura) {
        super(numeroDeCuenta, fechaApertura);
    }

    @Override
    public String getTipo() {
        return "CuentaCorriente";
    }

    //Getter and Setter
    public String getLineaSobregiro() {
        return lineaSobregiro;
    }
    private void setLineaSobregiro(String lineaSobregiro) {
        this.lineaSobregiro = lineaSobregiro;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "Numero de Cuenta: " + numeroDeCuenta + '\n' +
                "Fecha apertura: " + fechaApertura + '\n' +
                "Saldo: " + saldo + '\n' +
                "Linea de Sobregiro: " + lineaSobregiro +
                '}';
    }
}
