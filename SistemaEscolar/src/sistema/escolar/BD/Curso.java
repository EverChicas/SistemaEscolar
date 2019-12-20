/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.escolar.BD;

/**
 *Manejo de los cursos que tiene el sistema
 */
public class Curso {
    
    private int idCurso;
    private String Nombre;
    private Docente docente;

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Curso(int idCurso, String Nombre, Docente docente) {
        this.idCurso = idCurso;
        this.Nombre = Nombre;
        this.docente = docente;
    }

    
    
}
