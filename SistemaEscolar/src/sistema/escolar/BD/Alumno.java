/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.escolar.BD;

/**
 *Manejo de la informacion de alumno
 */
public class Alumno {
    
    private int carnet;
    private String Nombre;
    private String Apellido;
    private int edad;
    private String telefono;
    private Tutor tutor;
    private Grado grado;

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Alumno(int carnet, String Nombre, String Apellido, int edad, String telefono, Tutor tutor, Grado grado) {
        this.carnet = carnet;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.tutor = tutor;
        this.grado = grado;
    }
    
}
