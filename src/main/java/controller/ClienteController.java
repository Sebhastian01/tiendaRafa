/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ClienteDAO;
import model.Cliente;
import views.ClienteView;
import java.util.List;
import java.util.Scanner;


public class ClienteController {
    
    private ClienteDAO clienteDAO;
    private Scanner scanner;

    public ClienteController() {
        clienteDAO = new ClienteDAO();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de cliente ---");
            System.out.println("1. Crear cliente");
            System.out.println("2. Ver clientes");
            System.out.println("3. Actualizar clientes");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Verificar cliente");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    //crearCliente();
                    break;
                case 2:
                    //leerClientes();
                    break;
                case 3:
                    //actualizarCliente();
                    break;
                case 4:
                    //eliminarCliente();
                    break;
                case 5:
                    verificClientes();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    /* private void crearCliente() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        Cliente cliente = new Cliente(0, nombre);
        clienteDAO.crearCliente(cliente);
        ClienteView.mostrarMensaje("Cliente creado exitosamente.");
    }*/
    
    public void crearCliente(String nombre) {
        Cliente cliente = new Cliente(0, nombre);
        clienteDAO.crearCliente (cliente);
        ClienteView.mostrarMensaje("Categoría creada exitosamente.");
    }

    
    /* private void leerClientes() {
        List<Cliente> clientes = clienteDAO.leerCliente();
        ClienteView.mostrarClientes(clientes);
    }*/
    
    public List <Cliente> leerCliente() {
        List<Cliente> clientes = clienteDAO.leerCliente();
        return clientes;
    }

    /* private void actualizarCliente() {
        leerCliente();
        System.out.print("\nIngrese el ID del cliente que desea actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el nuevo nombre del cliente: ");
        String nuevoNombre = scanner.nextLine();
        Cliente cliente = new Cliente (id, nuevoNombre);
        clienteDAO.actualizarCliente(cliente);
        ClienteView.mostrarMensaje("Cliente actualizado exitosamente.");
    }*/
    
    public void actualizarCliente(int id, String nombre) {
        Cliente cliente = new Cliente(id, nombre);
        clienteDAO.actualizarCliente(cliente);
    }

    /*private void eliminarCliente() {
        leerClientes();
        System.out.print("\nIngrese el ID del cliente que desea eliminar: ");
        int id = scanner.nextInt();
        clienteDAO.eliminarCliente(id);
        ClienteView.mostrarMensaje("cliente eliminado exitosamente.");
    }*/
    
    public void eliminarCliente(int id) {
        clienteDAO.eliminarCliente(id);
    }
    
    private void verificClientes() {
        leerCliente();
        System.out.print("\nIngrese el ID del cliente que desea verificar: ");
        int id = scanner.nextInt();
        int resp = clienteDAO.verificClientes(id);
        if (resp == 1) {
            ClienteView.mostrarMensaje("Cliente verificado exitosamente.");
        } else {

            ClienteView.mostrarMensaje("Cliente no existe");
        }
    }    
    
}