/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.escolar.BD;

/**
 *Manejo del catalogo de pagos con los que cuenta el sistema
 */
public class Pago {
    
    private int idPago;
    private String nombre;
    private double cantidad;

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Pago(int idPago, String nombre, double cantidad) {
        this.idPago = idPago;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    
    
    
}
