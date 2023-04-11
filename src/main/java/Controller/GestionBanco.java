package Controller;

import Model.Cliente;
import Model.CuentaAhorro;
import Model.CuentaCorriente;
import Model.SucursalBancaria;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GestionBanco {
    static ArrayList<SucursalBancaria> sucursalesBancarias = new ArrayList<>();
    public static void main (String [] args){
        principal();
    }

    public static void principal(){
        SucursalBancaria sucursalBancaria = new SucursalBancaria(generarNumerosAleatorios(), generarNumerosAleatorios());
        Scanner leer = new Scanner(System.in);
        int opc = -1;
        do{
            menu();
            opc = leer.nextInt();
            seleccion(opc, sucursalBancaria);
        }while (opc !=0);
        System.out.println("Ha Salido.");
        System.exit(0);
    }

    public static void menu(){
        System.out.println(
                "0. Salir" + "\n" +
                "1. Agregar clientes" + "\n" +
                "2. Agregar cuentas bancarias y asociarla a un cliente" + "\n" +
                "3. Agregar sucursal bancaria" + "\n" +
                "4. Visualizar cuentas de un cliente" + "\n" +
                "5. Obtener todas las cuentas de ahorro de una sucursal" + "\n" +
                "6. Obtener todas las cuentas corrientes de una sucursal"
        );
    }

    public static void seleccion(int opc, SucursalBancaria sucursalBancaria){
        Scanner leer = new Scanner(System.in);

        switch (opc) {
            case 0:
                break;
            case 1:
                try{
                    Cliente clienteNuevo = new Cliente("Nombre Generico", generarNumerosAleatorios());
                    sucursalBancaria.agregarCliente(clienteNuevo);
                    System.out.println("Se ha agregado un nuevo cliente");
                }catch (Exception e){
                    System.out.println("Ha ocurrido un error la intentar agregar al cliente");
                }
                break;
            case 2:
                try{
                    agregarCuentaYAsociarla(sucursalBancaria);
                    System.out.println("Se ha creado una nueva cuenta con exito");
                }catch (Exception e){
                    System.out.println("Ha ocurrido un error la intentar crear una nueva cuenta");
                }
                break;
            case 3:
                try{
                    SucursalBancaria sucursalNueva = new SucursalBancaria(generarNumerosAleatorios(), generarNumerosAleatorios());
                    sucursalesBancarias.add(sucursalNueva);
                    System.out.println("Se ha creado una nueva sucursal");
                }catch (Exception e){
                    System.out.println("Ha ocurrido un error la intentar crear una nueva sucursal");
                }
                break;
            case 4:
                imprimirTodasLasCuentasDeUnCliente(sucursalBancaria);
                break;
            case 5:
                sucursalBancaria.cuentaBancariasSegunTipo("CuentaAhorro");
                System.out.println("Ha obtenido todas las cuentas de ahorro del banco");
                break;
            case 6:
                sucursalBancaria.cuentaBancariasSegunTipo("CuentaCorriente");
                System.out.println("Ha obtenido todas las cuentas corrientes del banco");
                break;
            default:
                System.out.println("Agregue una opción valida");
        }
    }

    public static void agregarCuentaYAsociarla(SucursalBancaria sucursalBancaria){
        Random aleatorio = new Random();
        Scanner leer = new Scanner(System.in);
        String run;
        int numeroAleatorio = aleatorio.nextInt(sucursalBancaria.getClientes().size());
        int tipoCuenta;
        System.out.println("Ingrese el run del cliente");
        run = sucursalBancaria.clienteAleatorio().getRun();
        if(run == null){
            System.out.println("No hay clientes para asociar");
        }else{
            do{
                System.out.println(
                        "¿Que cuenta quiere crear?" + "\n" +
                                "1. Cuenta Ahorro" + "\n" +
                                "2. Cuenta Corriente"
                );
                tipoCuenta = leer.nextInt();
                if(tipoCuenta == 1){
                    CuentaAhorro cuentaAhorro = new CuentaAhorro(generarNumerosAleatorios(), "22/06/23", "8");
                    sucursalBancaria.agregarCuentaBancaria(cuentaAhorro);
                    sucursalBancaria.buscarCliente(run).agregarCuentaCorriente(cuentaAhorro);
                }
                if(tipoCuenta == 2){
                    CuentaCorriente cuentaCorriente = new CuentaCorriente(generarNumerosAleatorios(), "22/06/23");
                    sucursalBancaria.agregarCuentaBancaria(cuentaCorriente);
                    sucursalBancaria.buscarCliente(run).agregarCuentaCorriente(cuentaCorriente);
                }
            }while(tipoCuenta != 1 && tipoCuenta != 2);
        }
    }
    public static void imprimirTodasLasCuentasDeUnCliente(SucursalBancaria sucursalBancaria){
        Scanner leer = new Scanner(System.in);
        String run;
        System.out.println("Ingrese el RUN del cliente");
        run = sucursalBancaria.clienteAleatorio().getRun();
        sucursalBancaria.buscarCliente(run).imprimirCuentasBancarias();
    }
    public static String generarNumerosAleatorios(){
        Random numero = new Random();
        String numeroAleatorio = "";
        for(int i = 0; i < 7; i++){
            numeroAleatorio = numeroAleatorio + Integer.toString(numero.nextInt(9)+1);
        }
        return numeroAleatorio;
    }
}
