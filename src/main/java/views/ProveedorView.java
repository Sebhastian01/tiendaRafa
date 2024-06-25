/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import model.Proveedor;
import java.util.List;

public class ProveedorView {
    
    public static void mostrarProveedores (List<Proveedor> Proveedores) {
        if (Proveedores.isEmpty()) {
            System.out.println("No hay proveedores disponibles.");
        } else {
            System.out.println("\n--- Lista de Proveedores ---");
            for (Proveedor Proveedor : Proveedores) {
                System.out.println(Proveedor.getId_proveedor()+ "." + Proveedor.getNombre() + " - Precio: " + Proveedor.getPrecio());
            }
        }
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
}
