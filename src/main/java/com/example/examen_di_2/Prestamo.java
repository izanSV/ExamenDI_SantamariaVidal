package com.example.examen_di_2;

import java.time.LocalDate;

/**
 * Representa un préstamo de un libro a un usuario en una biblioteca.
 */
public class Prestamo {
    private String idLibro; // Identificador del libro prestado
    private String dniUsuario; // DNI del usuario que realizó el préstamo
    private LocalDate fechaDevolucion; // Fecha prevista de devolución del libro

    /**
     * Constructor de la clase Prestamo.
     *
     * @param idLibro        Identificador del libro prestado.
     * @param dniUsuario     DNI del usuario que realizó el préstamo.
     * @param fechaDevolucion Fecha prevista de devolución del libro.
     */
    public Prestamo(String idLibro, String dniUsuario, LocalDate fechaDevolucion) {
        this.idLibro = idLibro;
        this.dniUsuario = dniUsuario;
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Obtiene el identificador del libro prestado.
     *
     * @return El identificador del libro.
     */
    public String getIdLibro() {
        return idLibro;
    }

    /**
     * Establece el identificador del libro prestado.
     *
     * @param idLibro El identificador del libro.
     */
    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * Obtiene el DNI del usuario que realizó el préstamo.
     *
     * @return El DNI del usuario.
     */
    public String getDniUsuario() {
        return dniUsuario;
    }

    /**
     * Establece el DNI del usuario que realizó el préstamo.
     *
     * @param dniUsuario El DNI del usuario.
     */
    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    /**
     * Obtiene la fecha prevista de devolución del libro.
     *
     * @return La fecha prevista de devolución.
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Establece la fecha prevista de devolución del libro.
     *
     * @param fechaDevolucion La fecha prevista de devolución.
     */
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Retorna una representación en cadena de caracteres del objeto Prestamo.
     *
     * @return Representación en cadena de caracteres del objeto Prestamo.
     */
    @Override
    public String toString() {
        return "Prestamo{" +
                "idLibro='" + idLibro + '\'' +
                ", dniUsuario='" + dniUsuario + '\'' +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
