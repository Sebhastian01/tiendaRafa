/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConexionBD;
import model.Proveedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    private Connection conexion;
    private ConexionBD conexionBD;

    public ProveedorDAO() {
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
    }

    public void crearProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO proveedor (nombre, precio) VALUES (?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, proveedor.getNombre());
            statement.setFloat(2, proveedor.getPrecio());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Proveedor> leerProveedor() {
        List<Proveedor> Proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id_proveedor = resultSet.getInt("id_proveedor");
                String nombre = resultSet.getString("nombre");
                float precio = resultSet.getFloat("precio");
                Proveedor Proveedor = new Proveedor(id_proveedor, nombre, precio);
                Proveedores.add(Proveedor);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return Proveedores;
    }

    public void actualizarProveedor(Proveedor Proveedor) {
        String sql = "UPDATE proveedor SET nombre = ?, WHERE id_proveedor = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setFloat(1, Proveedor.getPrecio());
            statement.setString(2, Proveedor.getNombre());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarProveedor(int id_proveedor) {
        String sql = "DELETE FROM proveedor WHERE id_proveedor = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id_proveedor);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        conexionBD.closeConexion(conexion);
    }
    
}
