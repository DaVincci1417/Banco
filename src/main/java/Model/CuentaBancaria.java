package Model;

public abstract class CuentaBancaria{
    protected String numeroDeCuenta;
    protected String fechaApertura;
    protected String saldo;

    public CuentaBancaria(String numeroDeCuenta, String fechaApertura){
        setNumeroDeCuenta(numeroDeCuenta);
        setFechaApertura(fechaApertura);
        setSaldo("0");
    }

    public abstract String getTipo();

    //Getters
    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }
    public String getFechaApertura() {
        return fechaApertura;
    }
    public String getSaldo() {
        return saldo;
    }

    //Setters
    private void setNumeroDeCuenta(String numeroDeCuenta){
        validarSaldoAndNumeroCuenta(numeroDeCuenta);
        this.numeroDeCuenta = numeroDeCuenta;
    }
    private void setFechaApertura(String fechaApertura){
        this.fechaApertura = fechaApertura;
    }
    private void setSaldo(String saldo){
        validarSaldoAndNumeroCuenta(saldo);
        this.saldo = saldo;
    }

    //Validacion
    private void validarSaldoAndNumeroCuenta(String saldo){
        try{
            Integer.parseInt(saldo);
        }catch (Exception e){
            System.out.println("Ha ingresado un monto invalido.");
        }
    }

}
