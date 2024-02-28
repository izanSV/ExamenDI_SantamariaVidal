package com.example.examen_di_2;

import com.example.examen_di_2.BibliotecaController;
import javafx.application.Platform;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BibliotecaAppTest {

    @BeforeAll
    public static void setUpClass() {
        // Inicializar JavaFX Toolkit
        BibliotecaApp.launch(BibliotecaApp.class);
    }

    @AfterAll
    public static void tearDownClass() {
        // Detener JavaFX Toolkit
        Platform.exit();
    }

    @Test
    public void testPrestamo() {
        // Crear una instancia de BibliotecaController
        BibliotecaController bibliotecaController = new BibliotecaController();

        // Agregar un libro de ejemplo
        bibliotecaController.altaLibro("1", "El Quijote", "9780142437230");

        // Agregar un usuario de ejemplo
        bibliotecaController.anyadirPrestamoVentana();

        // Realizar un préstamo
        bibliotecaController.prestar("1", "12345678A");

        // Verificar que se haya realizado el préstamo
        assertTrue(bibliotecaController.prestamos.size() == 1);
    }

    @Test
    public void testDevolucion() {
        // Crear una instancia de BibliotecaController
        BibliotecaController bibliotecaController = new BibliotecaController();

        // Agregar un libro de ejemplo
        bibliotecaController.altaLibro("1", "El Quijote", "9780142437230");

        // Agregar un usuario de ejemplo
        bibliotecaController.anyadirPrestamoVentana();

        // Realizar un préstamo
        bibliotecaController.prestar("1", "12345678A");

        // Devolver el libro prestado
        bibliotecaController.devolver("1", "12345678A");

        // Verificar que se haya realizado la devolución
        assertTrue(bibliotecaController.prestamos.isEmpty());
    }

    @Test
    public void testAltaLibro() {


        // Crear una instancia de BibliotecaController
        BibliotecaController bibliotecaController = new BibliotecaController();
        // Datos de ejemplo
        String idLibro = "1";
        String titulo = "El Quijote";
        String isbn = "9780142437230";

        // Llamar al método altaLibro
        bibliotecaController.altaLibro(idLibro, titulo, isbn);


        // Verificar si el libro se agregó correctamente
        assertEquals(1, bibliotecaController.libros.size());
        assertEquals(idLibro, bibliotecaController.libros.get(0).getIdLibro());
        assertEquals(titulo, bibliotecaController.libros.get(0).getTitulo());
        assertEquals(isbn, bibliotecaController.libros.get(0).getIsbn());
    }
}
