/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import config.ConexionBD;
import dao.CategoriaDAO;
import model.Categoria;
import views.CategoriaView;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CategoriaController {
    
    private CategoriaDAO categoriaDAO;
    private Scanner scanner;

    public CategoriaController() {
        categoriaDAO = new CategoriaDAO();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Categorías ---");
            System.out.println("1. Crear categoría");
            System.out.println("2. Leer categorías");
            System.out.println("3. Actualizar categoría");
            System.out.println("4. Eliminar categoría");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    //crearCategoria();
                    break;
                case 2:
                    //leerCategorias();
                    break;
                case 3:
                    //actualizarCategoria();
                    break;
                case 4:
                    //eliminarCategoria();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    /* esta private void es del formulario pero para ejecutarlo desde consola
    private void crearCategoria(String nombre) {
        System.out.print("Ingrese el nombre de la categoría: ");
        String nombre = scanner.nextLine();
        Categoria categoria = new Categoria(0, nombre);
        categoriaDAO.crearCategoria(categoria);
        CategoriaView.mostrarMensaje("Categoría creada exitosamente.");
    }*/
    
    /*este metodo es para ejecutar el formulario desde la parte gráfica
    para esto ya no se hace un private void sino que se hace como un public void, se crea
    un nuevo metodo*/
    public void crearCategoriaVista(String nombre) {
        Categoria categoria = new Categoria(0, nombre);
        categoriaDAO.crearCategoria(categoria);
        CategoriaView.mostrarMensaje("Categoría creada exitosamente.");
    }

    /*se hace lo mismo con el metodo de leer categoria que lo que hizo con crear
    private void leerCategorias() {
        List<Categoria> categorias = categoriaDAO.leerCategorias();
        CategoriaView.mostrarCategorias(categorias);
    } */
    
    public List <Categoria> leerCategoriasVista() {
        List<Categoria> categorias = categoriaDAO.leerCategorias();
        return categorias;
    }
    
    

    /*se hace lo mismo con el metodo de leer categoria que lo que hizo con crear
    private void actualizarCategoria() {
        leerCategorias();
        System.out.print("\nIngrese el ID de la categoría que desea actualizar: ");
        int categoria_id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el nuevo nombre de la categoría: ");
        String nuevoNombre = scanner.nextLine();
        Categoria categoria = new Categoria(categoria_id, nuevoNombre);
        categoriaDAO.actualizarCategoria(categoria);
        CategoriaView.mostrarMensaje("Categoría actualizada exitosamente.");
    } */
    
    public void actualizarCategoriaVista(int Id, String nuevoNombre) {
        leerCategoriasVista();
        int categoria_id = Id;
        String Nombre = nuevoNombre;
        Categoria categoria = new Categoria(categoria_id, nuevoNombre);
        categoriaDAO.actualizarCategoria(categoria);
    }
    
    
    /*se hace lo mismo con el metodo de leer categoria que lo que hizo con crear
    private void eliminarCategoria() {
        leerCategorias();
        System.out.print("\nIngrese el ID de la categoría que desea eliminar: ");
        int categoria_id = scanner.nextInt();
        categoriaDAO.eliminarCategoria(categoria_id);
        CategoriaView.mostrarMensaje("Categoría eliminada exitosamente.");
    } */
    
    public void eliminarCategoriaVista(int Id) {
        leerCategoriasVista();
        int categoria_id = Id;
        categoriaDAO.eliminarCategoria(categoria_id);
    }

}