/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ProveedorDAO;
import model.Proveedor;
import views.ProveedorView;
import java.util.List;
import java.util.Scanner;

public class ProveedorController {
    
    private ProveedorDAO ProveedorDAO;
    private Scanner scanner;

    public ProveedorController() {
        ProveedorDAO = new ProveedorDAO();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Proveedores ---");
            System.out.println("1. Crear Proveedor");
            System.out.println("2. Ver Proveedores");
            System.out.println("3. Actualizar Proveedor");
            System.out.println("4. Eliminar Proveedor");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    //crearProveedor();
                    break;
                case 2:
                    //leerProveedores();
                    break;
                case 3:
                    //actualizarProveedor();
                    break;
                case 4:
                    //eliminarProveedor();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

   /* private void crearProveedor() {
        System.out.print("Ingrese el nombre del Proveedor: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del Proveedor: ");
        float precio = scanner.nextFloat();
        Proveedor Proveedor = new Proveedor(0, nombre, precio);
        ProveedorDAO.crearProveedor(Proveedor);
        ProveedorView.mostrarMensaje("Proveedor creado exitosamente.");
    }*/
    
    public void crearProveedor(String nombre, float precio) {
        Proveedor proveedor = new Proveedor(0, nombre, precio);
        ProveedorDAO.crearProveedor(proveedor);
    }

    /* private void leerProveedores() {
        List<Proveedor> Proveedores = ProveedorDAO.leerProveedor();
        ProveedorView.mostrarProveedores(Proveedores);
    }*/
    
    public List <Proveedor> leerProveedor() {
        List<Proveedor> proveedor = ProveedorDAO.leerProveedor();
        return proveedor;
    }

    /*private void actualizarProveedor() {
        leerProveedor();
        System.out.print("\nIngrese el ID del proveedor que desea actualizar: ");
        int id_proveedor = scanner.nextInt();
        System.out.print("Ingrese el nuevo nombre del Proveedor: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese el precio del proveedor ");
        float nuevoPrecio = scanner.nextFloat();
        scanner.nextLine(); // Limpiar el buffer del scanner
        Proveedor Proveedor = new Proveedor (id_proveedor, nuevoNombre, nuevoPrecio);
        ProveedorDAO.actualizarProveedor(Proveedor);
        ProveedorView.mostrarMensaje("Proveedor actualizado exitosamente.");
    }*/
    
    public void actualizarProveedor(int id_proveedor, String nombre, float precio) {
        Proveedor proveedor = new Proveedor(id_proveedor, nombre, precio);
        ProveedorDAO.actualizarProveedor(proveedor);
    }

    /*private void eliminarProveedor() {
        leerProveedor();
        System.out.print("\nIngrese el id del proveedor que desea eliminar: ");
        int id_proveedor = scanner.nextInt();
        ProveedorDAO.eliminarProveedor(id_proveedor);
        ProveedorView.mostrarMensaje("proveedor eliminado exitosamente.");
    }*/
    
    public void eliminarProveedor(int id_proveedor) {
        ProveedorDAO.eliminarProveedor(id_proveedor);
    }
    
}
