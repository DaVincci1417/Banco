package Model;

public class CuentaAhorro extends CuentaBancaria{
    private String porcentajeReajusteAnual;

    public CuentaAhorro(String numeroDeCuenta, String fechaApertura, String porcentajeReajusteAnual){
        super(numeroDeCuenta, fechaApertura);
        setPorcentajeReajusteAnual(porcentajeReajusteAnual);
    }

    @Override
    public String getTipo() {
        return "CuentaAhorro";
    }

    //Getter and Setter
    public String getPorcentajeReajusteAnual() {
        return porcentajeReajusteAnual;
    }
    private void setPorcentajeReajusteAnual(String porcentajeReajusteAnual) {
        this.porcentajeReajusteAnual = porcentajeReajusteAnual;
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "Numero de Cuenta: " + numeroDeCuenta + '\n' +
                "Fecha apertura: " + fechaApertura + '\n' +
                "Saldo: " + saldo + '\n' +
                "Porcentaje Reajuste Anual: " + porcentajeReajusteAnual+
                '}';
    }
}
