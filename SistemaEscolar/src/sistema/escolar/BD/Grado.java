/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.escolar.BD;

/**
 *Manejo de grados
 */
public class Grado {
    
    private int idGrado;
    private String Nombre;

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Grado(int idGrado, String Nombre) {
        this.idGrado = idGrado;
        this.Nombre = Nombre;
    }
    
    
    
}
