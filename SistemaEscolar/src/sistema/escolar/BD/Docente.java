/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.escolar.BD;

/**
 *Manejo de docuentes
 */
public class Docente{
    
    private int idDocente;
    private String Nombre;
    private String Apellido;
    private String tipoContrato;

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Docente(int idDocente, String Nombre, String Apellido, String tipoContrato) {
        this.idDocente = idDocente;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.tipoContrato = tipoContrato;
    }
    
}
