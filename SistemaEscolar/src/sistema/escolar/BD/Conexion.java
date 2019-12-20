/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.escolar.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase con la que se hace la conexión a la base de datos, la consulta y cierra
 * la base de datos despues de cada opercación por motivos de seguridad.
 */
public class Conexion {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String ruta = "jdbc:mysql://localhost/basealumnos";
    private static final String usuario = "root";
    private static final String contraseña = "";

    private Connection conexion;
    private ResultSet resultados;
    private PreparedStatement consulta;

    /**
     * Constructor de la conexion tiene el driver, path, usuario y constraseñia de
     * la base de datos
     */
    public Conexion() {
        conexion = null;
        resultados = null;
        consulta = null;
    }

    /**
     * Hago la conexion a la base datos
     */
    private void conectar() {
        desconectar();
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(ruta, usuario, contraseña);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Hago que mis variables de conexion, resultset queden cerradas
     */
    private void desconectar() {
        if (conexion != null) {
            conexion.close();
            resultados.close();
            consulta.close();
        }
    }

    public int numeroDeFila(final String tabla) {
        int tmp = 0;
        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM " + tabla);
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                tmp += 1;
            }
            tmp += 1;
            desconectar();
            return tmp;
        } catch (final Exception ex) {
            return tmp;
        }

    }

    // CONSULTAS A BASE DE DATOS

    // CONSULTAS FACILES

    public List<String> cargarDatos(final String tabla, final String columna) {
        final List<String> tmp = new ArrayList<String>();
        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM " + tabla);
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                tmp.add(resultados.getString(columna));
            }
            desconectar();
            return tmp;
        } catch (final Exception ex) {
            return tmp;
        }
    }

    public Docente buscarDocente(final String nombre) {
        final Docente temp = new Docente(0, "", "", "");
        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM docente WHERE nombre = ?");
            consulta.setString(1, nombre);
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                temp.setIdDocente(resultados.getInt(1));
                temp.setNombre(resultados.getString(2));
                temp.setApellido(resultados.getString(3));
                temp.setTipoContrato(resultados.getString(4));
            }
            desconectar();
            return temp;
        } catch (final SQLException ex) {
            System.out.println(ex.getMessage());
            return temp;
        } finally {
            desconectar();
        }
    }

    public Docente buscarDocente(final int idDocente) {
        final Docente temp = new Docente(0, "", "", "");
        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM docente WHERE id_docente = ?");
            consulta.setString(1, String.valueOf(idDocente));
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                temp.setIdDocente(resultados.getInt(1));
                temp.setNombre(resultados.getString(2));
                temp.setApellido(resultados.getString(3));
            }
            desconectar();
            return temp;
        } catch (final SQLException ex) {
            System.out.println(ex.getMessage());
            return temp;
        } finally {
            desconectar();
        }
    }

    public Grado buscarGrado(final String nombre) {
        final Grado temp = new Grado(0, "");
        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM grado WHERE nombre = ?");
            consulta.setString(1, nombre);
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                temp.setIdGrado(resultados.getInt(1));
                temp.setNombre(resultados.getString(2));
            }
            desconectar();
            return temp;
        } catch (final SQLException ex) {
            System.out.println(ex.getMessage());
            return temp;
        } finally {
            desconectar();
        }
    }

    public Grado buscarGrado(final int idGrado) {
        final Grado temp = new Grado(0, "");
        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM grado WHERE id_grado = ?");
            consulta.setString(1, String.valueOf(idGrado));
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                temp.setIdGrado(resultados.getInt(1));
                temp.setNombre(resultados.getString(2));
            }
            desconectar();
            return temp;
        } catch (final SQLException ex) {
            System.out.println(ex.getMessage());
            return temp;
        } finally {
            desconectar();
        }
    }

    public Pago buscarPago(final String nombre) {
        final Pago temp = new Pago(0, "", 0);
        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM pago WHERE nombre = ?");
            consulta.setString(1, nombre);
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                temp.setIdPago(resultados.getInt(1));
                temp.setNombre(resultados.getString(2));
                temp.setCantidad(resultados.getDouble(3));
            }
            desconectar();
            return temp;
        } catch (final SQLException ex) {
            System.out.println(ex.getMessage());
            return temp;
        } finally {
            desconectar();
        }
    }

    public Pago buscarPago(final int idPago) {
        final Pago temp = new Pago(0, "", 0);
        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM pago WHERE id_pago = ?");
            consulta.setString(1, String.valueOf(idPago));
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                temp.setIdPago(resultados.getInt(1));
                temp.setNombre(resultados.getString(2));
                temp.setCantidad(resultados.getDouble(3));
            }
            desconectar();
            return temp;
        } catch (final SQLException ex) {
            System.out.println(ex.getMessage());
            return temp;
        } finally {
            desconectar();
        }
    }

    public Tutor buscarTutor(final String nombre) {
        final Tutor temp = new Tutor(0, "", "", "");
        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM tutor WHERE nombre = ?");
            consulta.setString(1, nombre);
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                temp.setIdTutor(resultados.getInt(1));
                temp.setNombre(resultados.getString(2));
                temp.setApellido(resultados.getString(3));
                temp.setTelefono(resultados.getString(4));
            }
            desconectar();
            return temp;
        } catch (final Exception ex) {
            return temp;
        }
    }

    public Tutor buscarTutor(final int IDTutor) {
        final Tutor temp = new Tutor(0, "", "", "");
        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM tutor WHERE id_tutor = ?");
            consulta.setString(1, String.valueOf(IDTutor));
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                temp.setIdTutor(resultados.getInt(1));
                temp.setNombre(resultados.getString(2));
                temp.setApellido(resultados.getString(3));
                temp.setTelefono(resultados.getString(4));
            }
            desconectar();
            return temp;
        } catch (final Exception ex) {
            return temp;
        }
    }

    // CONSULTAS CON COMPOSICION DE OTRO OBJETO
    public Alumno buscarAlumno(final String nombre) {
        final Alumno temp = new Alumno(0, "", "", 0, "", null, null);
        int IDGrado;
        int IDTutor;
        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM alumno WHERE nombre = ?");
            consulta.setString(1, nombre);
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                temp.setCarnet(resultados.getInt(1));
                temp.setNombre(resultados.getString(2));
                temp.setApellido(resultados.getString(3));
                temp.setEdad(resultados.getInt(4));
                temp.setTelefono(resultados.getString(5));

                IDTutor = resultados.getInt(6);
                IDGrado = resultados.getInt(7);

                temp.setTutor(buscarTutor(IDTutor));
                temp.setGrado(buscarGrado(IDGrado));
            }
            desconectar();
            return temp;
        } catch (final Exception ex) {
            return temp;
        }
    }

    public Alumno buscarAlumno(final int carnet) {
        final Alumno temp = new Alumno(0, "", "", 0, "", null, null);
        int IDGrado;
        int IDTutor;
        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM alumno WHERE carnet = ?");
            consulta.setString(1, String.valueOf(carnet));
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                temp.setCarnet(resultados.getInt(1));
                temp.setNombre(resultados.getString(2));
                temp.setApellido(resultados.getString(3));
                temp.setEdad(resultados.getInt(4));
                temp.setTelefono(resultados.getString(5));

                IDTutor = resultados.getInt(6);
                IDGrado = resultados.getInt(7);

                temp.setTutor(buscarTutor(IDTutor));
                temp.setGrado(buscarGrado(IDGrado));
            }
            desconectar();
            return temp;
        } catch (final Exception ex) {
            return temp;
        }
    }

    public Curso buscarCurso(final String nombre) {
        final Curso temp = new Curso(0, "", null);
        int IDDocente;
        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM curso WHERE nombre = ?");
            consulta.setString(1, nombre);
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                temp.setIdCurso(resultados.getInt(1));
                temp.setNombre(resultados.getString(2));

                IDDocente = resultados.getInt(3);
                temp.setDocente(buscarDocente(IDDocente));
            }
            desconectar();
            return temp;
        } catch (final Exception ex) {
            return temp;
        }
    }

    public Curso buscarCurso(final int idCurso) {
        final Curso temp = new Curso(0, "", null);
        int IDDocente;
        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM curso WHERE id_curso = ?");
            consulta.setString(1, String.valueOf(idCurso));
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                temp.setIdCurso(resultados.getInt(1));
                temp.setNombre(resultados.getString(2));

                IDDocente = resultados.getInt(3);
                temp.setDocente(buscarDocente(IDDocente));
            }
            desconectar();
            return temp;
        } catch (final Exception ex) {
            return temp;
        }
    }

    // CONSULTAS QUE DEVUELVEN UNA LISTA
    public List<Horario> buscarHorario(final String grado) {
        ResultSet resultado;
        final List<Horario> horarioDeGrado = new ArrayList<Horario>();
        final Grado temp1 = buscarGrado(grado);
        int IDCurso;

        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM horario WHERE id_grado = ?");
            consulta.setString(1, String.valueOf(temp1.getIdGrado()));
            resultado = consulta.executeQuery();

            while (resultado.next()) {
                IDCurso = resultado.getInt(2);
                horarioDeGrado
                        .add(new Horario(resultado.getString(3), resultado.getString(4), temp1, buscarCurso(IDCurso)));
            }
            desconectar();
            return horarioDeGrado;
        } catch (final Exception ex) {
            return horarioDeGrado;
        }
    }

    public List<PagosAlumno> buscarPagosDeAlumno(final String nombreAlumno) {
        ResultSet resultado;
        final List<PagosAlumno> listaDePagos = new ArrayList<PagosAlumno>();
        final Alumno temp1 = buscarAlumno(nombreAlumno);
        int IDPago;

        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM alumno_pago WHERE carnet = ?");
            consulta.setString(1, String.valueOf(temp1.getCarnet()));
            resultado = consulta.executeQuery();

            while (resultado.next()) {
                IDPago = resultado.getInt(2);
                listaDePagos.add(new PagosAlumno(temp1, buscarPago(IDPago), resultado.getString(3)));
            }
            desconectar();
            return listaDePagos;
        } catch (final Exception ec) {
            return listaDePagos;
        }

    }

    public List<NotasAlumno> buscarNotasDeAlumno(final String nombreAlumno) {
        ResultSet resultado;
        final List<NotasAlumno> listaDeNotas = new ArrayList<NotasAlumno>();
        final Alumno tmp = buscarAlumno(nombreAlumno);
        int IDCurso;

        try {
            conectar();
            consulta = conexion.prepareStatement("SELECT * FROM control_de_notas WHERE carnet = ?");
            consulta.setString(1, String.valueOf(tmp.getCarnet()));
            resultado = consulta.executeQuery();

            while (resultado.next()) {
                IDCurso = resultado.getInt(2);
                listaDeNotas.add(new NotasAlumno(tmp, buscarCurso(IDCurso), resultado.getInt(3)));
            }
            desconectar();
            return listaDeNotas;
        } catch (final Exception ex) {
            return listaDeNotas;
        }
    }

    public boolean insertarDocente(final Docente tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement(
                    "INSERT INTO docente " + "(id_docente,nombre,apellido,tipo_contrato)" + "VALUES (?,?,?,?)");
            consulta.setString(1, String.valueOf(tmp.getIdDocente()));
            consulta.setString(2, tmp.getNombre());
            consulta.setString(3, tmp.getApellido());
            consulta.setString(4, tmp.getTipoContrato());
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean insertarGrado(final Grado tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement("INSERT INTO grado " + "(id_grado,nombre) VALUES(?,?)");
            consulta.setString(1, String.valueOf(tmp.getIdGrado()));
            consulta.setString(2, tmp.getNombre());
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean insertarPago(final Pago tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement("INSERT INTO pago " + "(id_pago,descripcion,cantidad) VALUES(?,?,?)");
            consulta.setString(1, String.valueOf(tmp.getIdPago()));
            consulta.setString(2, tmp.getNombre());
            consulta.setString(3, String.valueOf(tmp.getCantidad()));
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean insertarTutor(final Tutor tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement(
                    "INSERT INTO tutor " + "(id_tutor,nombre,apellido,telefono) " + "VALUES(?,?,?,?)");
            consulta.setString(1, String.valueOf(tmp.getIdTutor()));
            consulta.setString(2, tmp.getNombre());
            consulta.setString(3, tmp.getApellido());
            consulta.setString(4, tmp.getTelefono());
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean insertarAlumno(final Alumno tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement("INSERT INTO alumno "
                    + "(carnet,nombre,apellido,edad,telefono,id_tutor,id_grado)" + "VALUES(?,?,?,?,?,?,?)");
            consulta.setString(1, String.valueOf(tmp.getCarnet()));
            consulta.setString(2, tmp.getNombre());
            consulta.setString(3, tmp.getApellido());
            consulta.setString(4, String.valueOf(tmp.getEdad()));
            consulta.setString(5, tmp.getTelefono());
            consulta.setString(6, String.valueOf(tmp.getTutor().getIdTutor()));
            consulta.setString(7, String.valueOf(tmp.getGrado().getIdGrado()));
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean insertarCurso(final Curso tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement("INSERT INTO curso " + "(id_curso,nombre,id_docente) VALUES(?,?,?)");
            consulta.setString(1, String.valueOf(tmp.getIdCurso()));
            consulta.setString(2, tmp.getNombre());
            consulta.setString(3, String.valueOf(tmp.getDocente().getIdDocente()));
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean insertarPagoDeAlumno(final PagosAlumno tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement("INSERT INTO alumno_pago " + "(carnet,id_pago,detalle) VALUES(?,?,?)");
            consulta.setString(1, String.valueOf(tmp.getAlumno().getCarnet()));
            consulta.setString(2, String.valueOf(tmp.getPago().getIdPago()));
            consulta.setString(3, tmp.getDetalle());
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean insertarNotaDeAlumno(final NotasAlumno tmp) {
        try {
            conectar();
            consulta = conexion
                    .prepareStatement("INSERT INTO control_de_notas " + "(carnet,id_curso,nota) VALUES(?,?,?)");
            consulta.setString(1, String.valueOf(tmp.getAlumno().getCarnet()));
            consulta.setString(2, String.valueOf(tmp.getCurso().getIdCurso()));
            consulta.setString(3, String.valueOf(tmp.getNota()));
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean insertarHorario(final Horario tmp) {
        try {
            conectar();
            consulta = conexion
                    .prepareStatement("INSERT INTO horario " + "(id_grado,id_curso,hora,dia) VALUES(?,?,?,?)");
            consulta.setString(1, String.valueOf(tmp.getGrado().getIdGrado()));
            consulta.setString(2, String.valueOf(tmp.getCurso().getIdCurso()));
            consulta.setString(3, tmp.getHora());
            consulta.setString(4, tmp.getDia());
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean actualizarDocente(final Docente tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement(
                    "UPDATE docente SET " + "nombre = ?,apellido = ?,tipo_contrato=?" + "WHERE id_docente = ?");
            consulta.setString(1, tmp.getNombre());
            consulta.setString(2, tmp.getApellido());
            consulta.setString(3, tmp.getTipoContrato());
            consulta.setString(4, String.valueOf(tmp.getIdDocente()));
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean actualizarGrado(final Grado tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement("UPDATE grado SET nombre = ? WHERE id_grado = ?");
            consulta.setString(1, tmp.getNombre());
            consulta.setString(2, String.valueOf(tmp.getIdGrado()));
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean actualiarPago(final Pago tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement("UPDATE pago SET " + "descripcion = ?,cantidad = ? WHERE id_pago = ?");
            consulta.setString(1, tmp.getNombre());
            consulta.setString(2, String.valueOf(tmp.getCantidad()));
            consulta.setString(3, String.valueOf(tmp.getIdPago()));
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean actualizarTutor(final Tutor tmp) {
        try {
            conectar();
            consulta = conexion
                    .prepareStatement("UPDATE tutor SET " + "nombre = ?,apellido = ?,telefono = ? WHERE id_tutor = ?");
            consulta.setString(1, tmp.getNombre());
            consulta.setString(2, tmp.getApellido());
            consulta.setString(3, tmp.getTelefono());
            consulta.setString(4, String.valueOf(tmp.getIdTutor()));
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean actualizarAlumno(final Alumno tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement("UPDATE alumno SET "
                    + "nombre = ?,apellido = ?,edad = ?,telefono = ?,id_tutor = ?,id_grado = ? " + "WHERE carnet = ?");
            consulta.setString(1, tmp.getNombre());
            consulta.setString(2, tmp.getApellido());
            consulta.setString(3, String.valueOf(tmp.getEdad()));
            consulta.setString(4, tmp.getTelefono());
            consulta.setString(5, String.valueOf(tmp.getTutor().getIdTutor()));
            consulta.setString(6, String.valueOf(tmp.getGrado().getIdGrado()));
            consulta.setString(7, String.valueOf(tmp.getCarnet()));
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean actualizarCurso(final Curso tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement("UPDATE curso SET " + "nombre = ?,id_docente = ? WHERE id_curso = ?");
            consulta.setString(1, tmp.getNombre());
            consulta.setString(2, String.valueOf(tmp.getDocente().getIdDocente()));
            consulta.setString(3, String.valueOf(tmp.getIdCurso()));
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean actualizarPagoDeAlumno(final PagosAlumno tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement(
                    "UPDATE alumno_pago SET " + "carnet = ?,id_pago = ? ,detalle = ? WHERE carnet = ?");
            consulta.setString(1, String.valueOf(tmp.getAlumno().getCarnet()));
            consulta.setString(2, String.valueOf(tmp.getPago().getIdPago()));
            consulta.setString(3, tmp.getDetalle());
            consulta.setString(4, String.valueOf(tmp.getAlumno().getCarnet()));
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean actualizarNotaDeAlumno(final NotasAlumno tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement(
                    "UPDATE control_de_notas SET " + "carnet = ?,id_curso = ?,nota = ? WHERE carnet = ?");
            consulta.setString(1, String.valueOf(tmp.getAlumno().getCarnet()));
            consulta.setString(2, String.valueOf(tmp.getCurso().getIdCurso()));
            consulta.setString(3, String.valueOf(tmp.getNota()));
            consulta.setString(4, String.valueOf(tmp.getAlumno().getCarnet()));
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean actualizrHorario(final Horario tmp) {
        try {
            conectar();
            consulta = conexion.prepareStatement(
                    "UPDATE horario SET " + "id_grado = ?,id_curso = ?,hora = ?,dia = ? WHERE id_grado = ?");
            consulta.setString(1, String.valueOf(tmp.getGrado().getIdGrado()));
            consulta.setString(2, String.valueOf(tmp.getCurso().getIdCurso()));
            consulta.setString(3, tmp.getHora());
            consulta.setString(4, tmp.getDia());
            consulta.setString(5, String.valueOf(tmp.getGrado().getIdGrado()));
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean existeNota(final Alumno alumno, final Curso curso) {
        try {
            conectar();
            consulta = conexion
                    .prepareStatement("SELECT * FROM control_de_notas " + "WHERE carnet = ? AND id_curso = ?");
            consulta.setString(1, String.valueOf(alumno.getCarnet()));
            consulta.setString(2, String.valueOf(String.valueOf(curso.getIdCurso())));
            resultados = consulta.executeQuery();

            if (resultados.next()) {
                desconectar();
                return true;
            }
        } catch (final Exception ex) {
            return false;
        }
        return false;
    }

}