package com.example.examen_di_2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Controlador para la interfaz de la biblioteca.
 */
public class BibliotecaController {
    ObservableList<Libro> libros;

    public List<Prestamo> prestamos;
    private List<Usuario> usuarios;

    @FXML
    private Label welcomeText;

    @FXML
    private ListView<Libro> librosListView;

    /**
     * Constructor de la clase `BibliotecaController`.
     * Inicializa las listas de libros, préstamos y usuarios.
     */
    public BibliotecaController() {
        libros = FXCollections.observableArrayList();
        prestamos = FXCollections.observableArrayList();
        usuarios = FXCollections.observableArrayList();
    }

    /**
     * Método invocado al hacer clic en el botón de agregar libro.
     * Abre una ventana para agregar un nuevo libro.
     */
    @FXML
    void altaButtonClick(ActionEvent event) {
        altaLibro("", "", "");
    }

    /**
     * Método invocado al hacer clic en el botón de préstamo.
     * Abre una ventana para añadir un nuevo préstamo.
     */
    @FXML
    void prestamoButtonClick(ActionEvent event) {
        anyadirPrestamoVentana();
    }

    /**
     * Agrega un nuevo libro a la lista.
     *
     * @param idLibro ID del libro
     * @param titulo  Título del libro
     * @param isbn    ISBN del libro
     */
    public void altaLibro(String idLibro, String titulo, String isbn) {
        // Verificar si el libro ya existe en la lista
        boolean libroExistente = libros.stream()
                .anyMatch(libro -> libro.getIdLibro().equals(idLibro) || libro.getIsbn().equals(isbn));

        // Si el libro ya existe, mostrar un mensaje y salir del método
        if (libroExistente) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al agregar libro");
            alert.setHeaderText(null);
            alert.setContentText("El libro con el mismo ID o ISBN ya existe en la lista.");
            alert.showAndWait();
            return;
        }

        // Si el libro no existe, agregarlo a la lista
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Agregar Libro");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label idLibroLabel = new Label("ID Libro:");
        TextField idLibroField = new TextField();
        idLibroField.setText(String.valueOf(idLibro));

        gridPane.add(idLibroLabel, 0, 0);
        gridPane.add(idLibroField, 1, 0);

        Label tituloLabel = new Label("Título:");
        TextField tituloField = new TextField();
        tituloField.setText(titulo);
        gridPane.add(tituloLabel, 0, 1);
        gridPane.add(tituloField, 1, 1);

        Label isbnLabel = new Label("ISBN:");
        TextField isbnField = new TextField();
        isbnField.setText(isbn);
        gridPane.add(isbnLabel, 0, 2);
        gridPane.add(isbnField, 1, 2);

        Button addButton = new Button("Agregar");
        addButton.setOnAction(e -> {
            try {
                String nuevoIdLibro = idLibroField.getText();
                String nuevoTitulo = tituloField.getText();
                String nuevoIsbn = isbnField.getText();

                libros.add(new Libro(nuevoIdLibro, nuevoTitulo, nuevoIsbn));

                actualizarListViewLibros();
                stage.close();
            } catch (NumberFormatException ex) {
                // Manejar error de conversión de número
                System.out.println("error en el id");
            }
        });
        gridPane.add(addButton, 0, 3);

        Scene scene = new Scene(gridPane, 300, 150);
        stage.setScene(scene);
        stage.showAndWait();
    }

    /**
     * Abre una ventana para añadir un nuevo préstamo.
     */
    public void anyadirPrestamoVentana() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Añadir Nuevo Préstamo");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label idLibroLabel = new Label("ID Libro:");
        TextField idLibroField = new TextField();
        gridPane.add(idLibroLabel, 0, 0);
        gridPane.add(idLibroField, 1, 0);

        Label dniUsuarioLabel = new Label("DNI Usuario:");
        TextField dniUsuarioField = new TextField();
        gridPane.add(dniUsuarioLabel, 0, 1);
        gridPane.add(dniUsuarioField, 1, 1);

        Label fechaDevolucionLabel = new Label("Fecha de Devolución:");
        DatePicker fechaDevolucionPicker = new DatePicker();
        gridPane.add(fechaDevolucionLabel, 0, 2);
        gridPane.add(fechaDevolucionPicker, 1, 2);

        Button addButton = new Button("Añadir Préstamo");
        addButton.setOnAction(e -> {

            String dniUsuario = dniUsuarioField.getText();
            LocalDate fechaDevolucion = fechaDevolucionPicker.getValue();

            // Verificar si el usuario existe, si no existe, crearlo
            Optional<Usuario> usuarioExistente = usuarios.stream().filter(usuario -> usuario.getDniUsuario().equals(dniUsuario)).findFirst();
            if (!usuarioExistente.isPresent()) {
                usuarios.add(new Usuario(dniUsuario, fechaDevolucion));
            }

            // Lógica para agregar el préstamo con los datos proporcionados

            stage.close();
        });
        gridPane.add(addButton, 0, 3);

        Scene scene = new Scene(gridPane, 300, 150);
        stage.setScene(scene);
        stage.showAndWait();
    }

    /**
     * Elimina un libro de la lista.
     *
     * @param idLibro ID del libro a eliminar
     */
    public void bajaLibro(String idLibro) {
        Optional<Libro> libroEncontrado = libros.stream().filter(libro -> libro.getIdLibro() == idLibro).findFirst();
        libroEncontrado.ifPresent(libro -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText("Eliminar libro");
            alert.setContentText("¿Estás seguro de que quieres eliminar este libro?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                libros.remove(libro);
                actualizarListViewLibros();
            }
        });
    }

    /**
     * Establece el ListView de libros.
     *
     * @param librosListView ListView de libros
     */
    public void setLibrosListView(ListView<Libro> librosListView) {
        this.librosListView = librosListView;
        actualizarListViewLibros();
    }

    /**
     * Actualiza el ListView de libros.
     */
    private void actualizarListViewLibros() {
        if (librosListView != null) {
            librosListView.setItems(libros);
        }
    }

    public void prestar(String idLibro, String dniUsuario) {
        // Verificar si el libro existe en la lista de libros
        Optional<Libro> libroOptional = libros.stream().filter(libro -> libro.getIdLibro().equals(idLibro)).findFirst();
        if (libroOptional.isPresent()) {
            Libro libro = libroOptional.get();

            // Verificar si el usuario existe en la lista de usuarios, si no existe, crearlo
            Optional<Usuario> usuarioOptional = usuarios.stream().filter(usuario -> usuario.getDniUsuario().equals(dniUsuario)).findFirst();
            Usuario usuario;
            if (usuarioOptional.isPresent()) {
                usuario = usuarioOptional.get();
            } else {
                usuario = new Usuario(dniUsuario);
                usuarios.add(usuario);
            }

            // Calcular la fecha de devolución del préstamo (14 días a partir de hoy)
            LocalDate fechaPrestamo = LocalDate.now();
            LocalDate fechaDevolucion = fechaPrestamo.plusDays(14);

            // Crear el objeto Prestamo y añadirlo a la lista de préstamos
            Prestamo prestamo = new Prestamo(libro.getIdLibro(), usuario.getDniUsuario(), fechaDevolucion);
            prestamos.add(prestamo);

            // Mostrar mensaje de éxito
            mostrarMensaje("Préstamo realizado con éxito");
        } else {
            // Mostrar mensaje de error si el libro no existe
            mostrarMensaje("El libro con ID " + idLibro + " no existe");
        }
    }


    /**
     * Método para devolver un libro prestado por un usuario.
     * @param idLibro ID del libro a devolver
     * @param dniUsuario DNI del usuario que devuelve el libro
     */
    public void devolver(String idLibro, String dniUsuario) {
        // Buscar el préstamo correspondiente al libro y usuario especificados
        Optional<Prestamo> prestamoOptional = prestamos.stream()
                .filter(prestamo -> prestamo.getIdLibro().equals(idLibro) && prestamo.getDniUsuario().equals(dniUsuario))
                .findFirst();

        if (prestamoOptional.isPresent()) {
            // Remover el préstamo de la lista de préstamos
            Prestamo prestamo = prestamoOptional.get();
            prestamos.remove(prestamo);
            // Mostrar mensaje de éxito
            mostrarMensaje("Devolución realizada con éxito");
        } else {
            // Mostrar mensaje de error si el préstamo no existe
            mostrarMensaje("No se encontró un préstamo válido para el libro con ID " + idLibro + " y el usuario con DNI " + dniUsuario);
        }
    }


    /**
     * Método auxiliar para mostrar un mensaje en una ventana emergente.
     *
     * @param mensaje Mensaje a mostrar
     */
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
