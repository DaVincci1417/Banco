package Model;

import java.util.ArrayList;
import java.util.Random;

public class SucursalBancaria {
    private String codigoSucursal;
    private String codigoPostal;
    private ArrayList<CuentaBancaria> cuentaBancarias = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public SucursalBancaria(String codigoSucursal, String codigoPostal){
        setCodigoSucursal(codigoSucursal);
        setCodigoPostal(codigoPostal);
    }

    //Getters
    public String getCodigoSucursal() {
        return codigoSucursal;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public ArrayList<CuentaBancaria> getCuentaBancarias() {
        return cuentaBancarias;
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    //Setters
    private void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }
    private void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    private void setCuentaBancarias(ArrayList<CuentaBancaria> cuentaBancarias) {
        this.cuentaBancarias = cuentaBancarias;
    }
    private void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente clienteAleatorio(){
        Random aleatorio = new Random();
        int numeroAleatorio = aleatorio.nextInt(clientes.size());
        return clientes.get(numeroAleatorio);
    }

    //Agregar Cuenta Bancaria
    public void agregarCuentaBancaria(CuentaBancaria cuentaBancaria){
        cuentaBancarias.add(cuentaBancaria);
    }
    //Agregar Cliente
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }
    //BuscarCuentasSegunTipo
    public ArrayList<CuentaBancaria> cuentaBancariasSegunTipo(String tipoDeCuenta){
        ArrayList<CuentaBancaria> cuentasBancariasDelTipo = new ArrayList<>();
        for(int i = 0; i < cuentaBancarias.size(); i++){
            if(cuentaBancarias.get(i).getTipo().equalsIgnoreCase(tipoDeCuenta)){
                cuentasBancariasDelTipo.add(cuentaBancarias.get(i));
            }
        }
        return cuentasBancariasDelTipo;
    }
    //Buscar Cliente
    public Cliente buscarCliente(String run){
        int posicion = -1;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getRun().equalsIgnoreCase(run)){
                posicion = i;
            }
        }
        if (posicion != -1) {
            return clientes.get(posicion);
        } else {
            return null;
        }
    }
}
