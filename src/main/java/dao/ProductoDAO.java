/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConexionBD;
import model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    
    private Connection conexion;
    private ConexionBD conexionBD;

    public ProductoDAO() { 
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
    }

    public void crearProducto(Producto producto){
        String sql = "INSERT INTO productos (nombre, precio, categoria_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, producto.getNombre());
            statement.setFloat(2, producto.getPrecio());
            statement.setInt(3, producto.getCategoria_id());
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("categoria_id");
                String nombre = resultSet.getString("nombre");
                float precio = resultSet.getFloat("precio");
                int categoria_id = resultSet.getInt("categoria_id");
                Producto producto = new Producto(id, nombre, precio, categoria_id);
                productos.add(producto);
            }
        } catch (SQLException e) {
                System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return productos;
    }

    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, categoria_id = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, producto.getNombre());
            statement.setFloat(2, producto.getPrecio());
            statement.setInt(3, producto.getCategoria_id());
            statement.setInt(4, producto.getCategoria_id());
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al eliminar los datos: " + e.getMessage());
        }
    }
    
    public void cerrarConexion() {
        conexionBD.closeConexion(conexion);
    }
    
}
