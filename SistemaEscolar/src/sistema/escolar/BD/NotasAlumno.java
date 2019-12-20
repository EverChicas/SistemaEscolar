/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.escolar.BD;

/**
 *Control de notas de alumno con cada uno de los cursos de su grado
 */
public class NotasAlumno {
    
    private Alumno alumno;
    private Curso curso;
    private int nota;

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public NotasAlumno(Alumno alumno, Curso curso, int nota) {
        this.alumno = alumno;
        this.curso = curso;
        this.nota = nota;
    }
    
}
