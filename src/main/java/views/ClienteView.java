/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import model.Cliente;
import java.util.List;

public class ClienteView {
    
    public static void mostrarClientes(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes disponibles.");
        } else {
            System.out.println("\n--- Lista de clientes ---");
            for (Cliente cliente : clientes) {
                System.out.println(cliente.getId() + ". " + cliente.getNombre());
            }
        }
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
}
