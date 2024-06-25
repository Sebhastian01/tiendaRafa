/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tiendarafa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import controller.CategoriaController;
import controller.ProductoController;
import controller.ClienteController;
import controller.ProveedorController;
import javax.swing.JFrame;
import views.FormularioCategoria;

public class TiendaRafa {

    public static void main(String[] args) {
        
        /*CategoriaController categoriaController = new CategoriaController();
        categoriaController.mostrarMenu();
        
        ProductoController productoController = new ProductoController();
        productoController.mostrarMenu();
        
        ClienteController ClienteController = new ClienteController();
        ClienteController.mostrarMenu();
        
        ProveedorController ProveedorController = new ProveedorController();
        ProveedorController.mostrarMenu();
        
        System.out.println("Hello World!");*/
        
        FormularioCategoria formulariocategoria = new FormularioCategoria ();
        formulariocategoria.setVisible (true);
        JFrame frame = new JFrame ("Formulario tienda Rafa");
        frame.getContentPane().add(formulariocategoria);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
    }
}


