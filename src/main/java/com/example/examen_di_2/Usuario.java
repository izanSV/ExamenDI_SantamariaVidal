package com.example.examen_di_2;

import java.time.LocalDate;

/**
 * Representa un usuario de la biblioteca.
 */
public class Usuario {
    private String dniUsuario;
    private LocalDate fechaAltaSancion;

    /**
     * Constructor de la clase Usuario.
     *
     * @param dniUsuario El DNI del usuario.
     */
    public Usuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    /**
     * Constructor de la clase Usuario con la posibilidad de establecer una fecha de alta de sanción.
     *
     * @param dniUsuario         El DNI del usuario.
     * @param fechaAltaSancion   La fecha de alta de la sanción del usuario.
     */
    public Usuario(String dniUsuario, LocalDate fechaAltaSancion) {
        this.dniUsuario = dniUsuario;
        this.fechaAltaSancion = fechaAltaSancion;
    }

    /**
     * Sanciona al usuario durante 10 días si no está sancionado.
     */
    public void sancionar() {
        // Si el usuario no está sancionado, se le sanciona
        if (fechaAltaSancion == null) {
            fechaAltaSancion = LocalDate.now();
            fechaAltaSancion = fechaAltaSancion.plusDays(10); // La sanción dura 10 días
        }
    }

    /**
     * Quita la sanción al usuario si ha pasado el período de sanción.
     */
    public void quitarSancion() {
        // Si el usuario está sancionado y han pasado los 10 días de sanción, se quita la sanción
        if (fechaAltaSancion != null && LocalDate.now().isAfter(fechaAltaSancion)) {
            fechaAltaSancion = null;
        }
    }

    // Métodos getter y setter

    /**
     * Obtiene el DNI del usuario.
     *
     * @return El DNI del usuario.
     */
    public String getDniUsuario() {
        return dniUsuario;
    }

    /**
     * Establece el DNI del usuario.
     *
     * @param dniUsuario El nuevo DNI del usuario.
     */
    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    /**
     * Obtiene la fecha de alta de la sanción del usuario.
     *
     * @return La fecha de alta de la sanción del usuario.
     */
    public LocalDate getFechaAltaSancion() {
        return fechaAltaSancion;
    }

    /**
     * Establece la fecha de alta de la sanción del usuario.
     *
     * @param fechaAltaSancion La nueva fecha de alta de la sanción del usuario.
     */
    public void setFechaAltaSancion(LocalDate fechaAltaSancion) {
        this.fechaAltaSancion = fechaAltaSancion;
    }

    /**
     * Devuelve una representación en cadena del objeto Usuario.
     *
     * @return Una representación en cadena del objeto Usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "dniUsuario='" + dniUsuario + '\'' +
                ", fechaAltaSancion=" + fechaAltaSancion +
                '}';
    }
}
