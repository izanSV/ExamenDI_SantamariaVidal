package com.example.examen_di_2;

import java.time.LocalDate;

/**
 * Representa un libro.
 */
public class Libro {
    private String idLibro;
    private String titulo;
    private String isbn;
    private String autor;
    private Tematica tematica;
    private LocalDate fechaEdicion;

    /**
     * Constructor de la clase Libro.
     *
     * @param idLibro       Identificador del libro.
     * @param titulo        Título del libro.
     * @param isbn          ISBN del libro.
     * @param autor         Autor del libro.
     * @param tematica      Temática del libro.
     * @param fechaEdicion  Fecha de edición del libro.
     */
    public Libro(String idLibro, String titulo, String isbn, String autor, Tematica tematica, LocalDate fechaEdicion) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.tematica = tematica;
        this.fechaEdicion = fechaEdicion;
    }

    /**
     * Constructor de la clase Libro para libros sin información detallada.
     *
     * @param idLibro  Identificador del libro.
     * @param titulo   Título del libro.
     * @param isbn     ISBN del libro.
     */
    public Libro(String idLibro, String titulo, String isbn) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    // Métodos getter y setter

    /**
     * Obtiene el identificador del libro.
     *
     * @return El identificador del libro.
     */
    public String getIdLibro() {
        return idLibro;
    }

    /**
     * Establece el identificador del libro.
     *
     * @param idLibro El nuevo identificador del libro.
     */
    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del libro.
     *
     * @param titulo El nuevo título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el ISBN del libro.
     *
     * @return El ISBN del libro.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establece el ISBN del libro.
     *
     * @param isbn El nuevo ISBN del libro.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return El autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro.
     *
     * @param autor El nuevo autor del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene la temática del libro.
     *
     * @return La temática del libro.
     */
    public Tematica getTematica() {
        return tematica;
    }

    /**
     * Establece la temática del libro.
     *
     * @param tematica La nueva temática del libro.
     */
    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    /**
     * Obtiene la fecha de edición del libro.
     *
     * @return La fecha de edición del libro.
     */
    public LocalDate getFechaEdicion() {
        return fechaEdicion;
    }

    /**
     * Establece la fecha de edición del libro.
     *
     * @param fechaEdicion La nueva fecha de edición del libro.
     */
    public void setFechaEdicion(LocalDate fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    /**
     * Devuelve una representación en cadena del objeto Libro.
     *
     * @return Una representación en cadena del objeto Libro.
     */
    @Override
    public String toString() {
        return "Libro{" +
                "idLibro='" + idLibro + '\'' +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                ", tematica='" + tematica + '\'' +
                ", fechaEdicion=" + fechaEdicion +
                '}';
    }
}
