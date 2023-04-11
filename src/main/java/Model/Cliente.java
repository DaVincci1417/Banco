package Model;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String run;
    private ArrayList<CuentaBancaria> cuentasBancarias = new ArrayList<>();

    public Cliente(String nombre, String run){
        setNombre(nombre);
        setRun(run);
    }

    public void agregarCuentaCorriente(CuentaBancaria cuentaBancaria){
        cuentasBancarias.add(cuentaBancaria);
    }

    //Getters
    public String getNombre() {
        return nombre;
    }
    public String getRun() {
        return run;
    }
    public ArrayList<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }

    //Setters
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private void setRun(String run) {
        this.run = run;
    }
    private void setCuentasBancarias(ArrayList<CuentaBancaria> cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }

    public void imprimirCuentasBancarias(){
        if(cuentasBancarias == null){
            System.out.println("El cliente no cuenta con cuentas bancarias");
        }else{
            for(int i = 0; i < cuentasBancarias.size(); i++){
                System.out.println(cuentasBancarias.get(i));
            }
        }
    }
}
