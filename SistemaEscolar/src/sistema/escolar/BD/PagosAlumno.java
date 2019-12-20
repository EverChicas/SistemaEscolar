/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.escolar.BD;

/**
 *Detalle de los pagos realizados por cada alumno
 */
public class PagosAlumno {
    
    private Alumno alumno;
    private Pago pago;
    private String detalle;

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public PagosAlumno(Alumno alumno, Pago pago, String detalle) {
        this.alumno = alumno;
        this.pago = pago;
        this.detalle = detalle;
    }
    
}
