/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * FALTA AÑADIR EL ID AL PROVEEDOR
 */
public class Proveedor {
    private int id_proveedor;
    private String nombre;
    private Float precio;


    public Proveedor(int id_proveedor, String nombre, Float precio) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public float getId_proveedor() {
        return id_proveedor;
    }

    public void setId(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setId(Float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
