/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bibliotecagui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class BibliotecaGUI {

    private JFrame frame;
    private Biblioteca biblioteca;
    private Connection connection;

//Datos de mi Base de datos en MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/sistema ?useTimezone=true&serverTimezone=UTC";
    private static final String USERNAME = "Paula";
    private static final String PASSWORD = "Pau08_Isa28";

    PreparedStatement ps;
    ResultSet rs;

//Metodo de conexion a la base de datos
    public static Connection getConection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (Exception e) {
            System.out.print(e);

        }
        return con;

    }

    public BibliotecaGUI() throws SQLException {

        frame = new JFrame("Sistema de Gestión de Biblioteca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        biblioteca = new Biblioteca();

        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Agregar el título en el centro
        JLabel titleLabel = new JLabel("Sistema de Gestión de Biblioteca");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        // Agregar la imagen
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\BibliotecaGUI\\src\\img\\biblioteca.png");
        JLabel imageLabel = new JLabel(imageIcon);
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(imageLabel, gbc);

        // Agregar botones
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(createButton("Registrar Libro", e -> registrarLibro()), gbc);

        gbc.gridx = 1;
        panel.add(createButton("Registrar Usuario", e -> registrarUsuario()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(createButton("Registrar Equipo", e -> registrarEquipo()), gbc);

        gbc.gridx = 1;
        panel.add(createButton("Ver Registro de Libros", e -> verRegistroLibros()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(createButton("Ver Registro de Equipos", e -> verRegistroEquipos()), gbc);

        gbc.gridx = 1;
        panel.add(createButton("Ver Registro de Usuarios", e -> verRegistroUsuarios()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(createButton("Préstamo/Devolución", e -> gestionarPrestamoDevolucion()), gbc);

        gbc.gridx = 1;
        panel.add(createButton("Buscar Libro", e -> buscarLibro()), gbc);

        frame.pack();
        frame.setVisible(true);
    }

    private JButton createButton(String label, ActionListener action) {
        JButton button = new JButton(label);
        button.addActionListener(action);
        return button;
    }
    /*Metodo para registar un Libro donde se obtener la informacion que se ingrese, y se va a llamar al metodo "insertarLibroEnBD(libro)" 
    en donde ve a insertar el libro en la base de datos MySQL*/
    private void registrarLibro() {
        String CodigoLibro = getInput("Ingrese el codigo del libro:");
        String titulo = getInput("Ingrese el título del libro:");
        String autor = getInput("Ingrese el autor del libro:");
        String publicacion = getInput("Ingrese el año de publicacion del libro:");
        String idioma = getInput("Ingrese el idioma del libro:");
        String genero = getInput("Ingrese el género del libro:");
        String link = getInput("Ingrese el link del libro:");

        if (CodigoLibro != null && !CodigoLibro.isEmpty() && titulo != null && !titulo.isEmpty() && autor != null && !autor.isEmpty() && publicacion != null && !publicacion.isEmpty() && idioma != null && !idioma.isEmpty() && genero != null && !genero.isEmpty() && link != null && !link.isEmpty()) {
            Libro libro = new Libro(CodigoLibro, titulo, autor, publicacion, idioma, genero, link);
            biblioteca.registrarLibro(libro);
            showMessage("Libro registrado con éxito.");
            // Insertar el libro en la base de datos MySQL
            insertarLibroEnBD(libro);
        }
    }

    /*Metodo para registar un Usuario donde se obtetener la informacion que se ingrese, y se va a llamar al metodo " insertarUsuarioEnBD(usuario)" 
    en donde ve a insertar el usuario en la base de datos MySQL*/
    private void registrarUsuario() {
        String numeroDeUsuario = getInput("Ingrese el número de usuario:");
        String nombre = getInput("Ingrese el nombre del usuario:");
        String apellido1 = getInput("Ingrese el primer apellido del usuario:");
        String apellido2 = getInput("Ingrese el segundo apellido del usuario:");
        String telefono = getInput("Ingrese el numero del telefono del usuario:");
        String correo = getInput("Ingrese el correo electronico del usuario:");

        if (numeroDeUsuario != null && !numeroDeUsuario.isEmpty() && nombre != null && !nombre.isEmpty() && apellido1 != null && !apellido1.isEmpty() && apellido2 != null && !apellido2.isEmpty() && telefono != null && !telefono.isEmpty() && correo != null && !correo.isEmpty()) {
            Usuario usuario = new Usuario(numeroDeUsuario, nombre, apellido1, apellido2, telefono, correo);
            biblioteca.registrarUsuario(usuario);
            showMessage("Usuario registrado con éxito.");
            // Insertar el usuario en la base de datos MySQL
            insertarUsuarioEnBD(usuario);

        }
    }

    /*Metodo para registar un Equipo donde se obtetener la informacion que se ingrese, y se va a llamar al metodo " insertarEquipoEnBD(equipo)" 
    en donde ve a insertar el equipo en la base de datos MySQL*/
    private void registrarEquipo() {
        String CodigoEquipo = getInput("Ingrese el Codigo del equipo:");
        String nombre = getInput("Ingrese el nombre del equipo:");
        String ubicacion = getInput("Ingrese la ubicacion del equipo:");
        String Descripcion = getInput("Ingrese la descripcion del equipo:");

        if (CodigoEquipo != null && !CodigoEquipo.isEmpty() && nombre != null && !nombre.isEmpty() && ubicacion != null && !ubicacion.isEmpty() && Descripcion != null && !Descripcion.isEmpty()) {
            Equipo equipo = new Equipo(CodigoEquipo, nombre, ubicacion, Descripcion);
            biblioteca.registrarEquipo(equipo);
            showMessage("Equipo registrado con éxito.");
            // Insertar el equipo en la base de datos MySQL
            insertarEquipoEnBD(equipo);
        }
    }

    /*
    Metodo en donde se va a tener la oportunidad de poder visualizar todos los registros de libros que se han agregado en la base de datos 
    en donde esa informacion se va a mostrar en una tabla
    */
    private void verRegistroLibros() {
        try {
            Connection con = getConection();
            String query = "SELECT * FROM libros";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            // Crear un nuevo JFrame para mostrar la tabla y el texto centrado
            JFrame resultFrame = new JFrame("Registro de Libros");
            JPanel mainPanel = new JPanel(new BorderLayout());

            // Crear un DefaultTableModel para la tabla
            DefaultTableModel model = new DefaultTableModel();
            JTable table = new JTable(model);
            
            // Agregar columnas al modelo
            model.addColumn("ID");
            model.addColumn("CodigoLibro");
            model.addColumn("Título");
            model.addColumn("Autor");
            model.addColumn("Publicacion");
            model.addColumn("Idioma");
            model.addColumn("Género");
            model.addColumn("Link");

            // Llama a la función para procesar las filas de forma recursiva
            processLibros(model, rs);

            mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

            // Crear un JPanel para contener el JLabel y centrarlo
            JPanel labelPanel = new JPanel(new GridBagLayout());
            JLabel label = new JLabel("Registros de Libros");
            label.setFont(new Font("Arial", Font.BOLD, 16)); // Ajusta la fuente según tus preferencias

            // Configurar GridBagConstraints para centrar el JLabel
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(0, 0, 10, 0); // Espacio inferior
            gbc.gridx = 0;
            gbc.gridy = 0;
            labelPanel.add(label, gbc);

            // Agregar el panel del texto al panel principal
            mainPanel.add(labelPanel, BorderLayout.NORTH);

            resultFrame.add(mainPanel);
            resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            resultFrame.pack();
            resultFrame.setVisible(true);

        } catch (SQLException e) {
            showMessage("Error al recuperar datos de la base de datos.");
            e.printStackTrace();
        }
    }

// Método para procesar las filas de forma recursiva
    private void processLibros(DefaultTableModel model, ResultSet rs) {
        try {
            if (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("CodigoLibro"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("publicacion"),
                    rs.getString("idioma"),
                    rs.getString("genero"),
                    rs.getString("link"),});
                // Llama a la función de nuevo para procesar la siguiente fila
                processLibros(model, rs);
            }
        } catch (SQLException e) {
            showMessage("Error al procesar datos de la base de datos.");
            e.printStackTrace();
        }
    }

    /*
    Metodo en donde se va a tener la oportunidad de poder visualizar todos los registros de Equipos que se han agregado en la base de datos 
    en donde esa informacion se va a mostrar en una tabla
    */
    private void verRegistroEquipos() {
        try {
            Connection con = getConection();
            String query = "SELECT * FROM equipos";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            // Crear un nuevo JFrame
            JFrame resultFrame = new JFrame("Registro de Equipos");
            resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Crear un DefaultTableModel para la tabla
            DefaultTableModel model = new DefaultTableModel();
            JTable table = new JTable(model);

            // Agregar columnas al modelo
            model.addColumn("Id");
            model.addColumn("CodigoEquipo");
            model.addColumn("Nombre");
            model.addColumn("Ubicacion");
            model.addColumn("Descripción");

            // Llena la tabla con datos del ResultSet usando el método processEquipos
            processEquipos(model, rs);

            // Agregar la tabla a un JScrollPane
            JScrollPane scrollPane = new JScrollPane(table);

            // Crear un JPanel para el título
            JPanel titlePanel = new JPanel();
            JLabel titleLabel = new JLabel("Registros de Equipos");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            titlePanel.add(titleLabel);

            // Crear un contenedor principal
            Container container = resultFrame.getContentPane();
            container.setLayout(new BorderLayout());
            container.add(titlePanel, BorderLayout.NORTH);
            container.add(scrollPane, BorderLayout.CENTER);

            // Configurar dimensiones y visibilidad del JFrame
            resultFrame.setSize(800, 400);
            resultFrame.setVisible(true);
        } catch (SQLException e) {
            showMessage("Error al recuperar datos de la base de datos.");
            e.printStackTrace();
        }
    }

// Método para procesar las filas de forma recursiva
    private void processEquipos(DefaultTableModel model, ResultSet rs) {
        try {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("ID"),
                    rs.getString("CodigoEquipo"),
                    rs.getString("Nombre"),
                    rs.getString("Ubicacion"),
                    rs.getString("Descripcion")
                });
            }
        } catch (SQLException e) {
            showMessage("Error al procesar datos de la base de datos.");
            e.printStackTrace();
        }
    }

    /*
    Metodo en donde se va a tener la oportunidad de poder visualizar todos los registros de usuaios que se han agregado en la base de datos 
    en donde esa informacion se va a mostrar en una tabla
    */
    private void verRegistroUsuarios() {
        try {
            Connection con = getConection();
            String query = "SELECT * FROM usuarios";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            // Crear un nuevo JFrame para mostrar la tabla y el texto centrado
            JFrame resultFrame = new JFrame("Registro de Usuarios");
            JPanel mainPanel = new JPanel(new BorderLayout());

            // Crear un DefaultTableModel para la tabla
            DefaultTableModel model = new DefaultTableModel();
            JTable table = new JTable(model);
            
            // Agregar columnas al modelo
            model.addColumn("Id");
            model.addColumn("NumeroUsuario");
            model.addColumn("Nombre");
            model.addColumn("Apellido1");
            model.addColumn("Apellido2");
            model.addColumn("Telefono");
            model.addColumn("Correo");

            // Llama a la función para procesar las filas de forma recursiva
            processUsuarios(model, rs);
            mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

            // Crear un JPanel para contener el JLabel y centrarlo
            JPanel labelPanel = new JPanel(new GridBagLayout());
            JLabel label = new JLabel("Registros de Usuarios");
            label.setFont(new Font("Arial", Font.BOLD, 16)); // Ajusta la fuente según tus preferencias

            // Configurar GridBagConstraints para centrar el JLabel
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(0, 0, 10, 0); // Espacio inferior
            gbc.gridx = 0;
            gbc.gridy = 0;
            labelPanel.add(label, gbc);

            // Agregar el panel del texto al panel principal
            mainPanel.add(labelPanel, BorderLayout.NORTH);

            resultFrame.add(mainPanel);
            resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            resultFrame.pack();
            resultFrame.setVisible(true);
        } catch (SQLException e) {
            showMessage("Error al recuperar datos de la base de datos.");
            e.printStackTrace();
        }
    }

// Método para procesar las filas de forma recursiva
    private void processUsuarios(DefaultTableModel model, ResultSet rs) {
        try {
            if (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("Id"),
                    rs.getInt("numeroUsuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("telefono"),
                    rs.getString("correo")
                });
                // Llama a la función de nuevo para procesar la siguiente fila
                processUsuarios(model, rs);
            }
        } catch (SQLException e) {
            showMessage("Error al procesar datos de la base de datos.");
            e.printStackTrace();
        }
    }

    /*
    Metodo en donde se va agestionar si se quiere hacer un prestamo(libro o Equipo) o devolucion (libro o Equipo).
    */
    private void gestionarPrestamoDevolucion() {
        String[] opciones = {"Préstamo", "Devolución"};
        int seleccion = showOptionDialog("Seleccione una operación:", "Préstamo/Devolución", opciones);

        if (seleccion == 0) { // Préstamo
            String[] tipoPrestamo = {"Libro", "Equipo"};
            int tipoSeleccion = showOptionDialog("Seleccione el tipo de préstamo:", "Préstamo", tipoPrestamo);

            if (tipoSeleccion == 0) { // Préstamo de Libro
                realizarPrestamoLibro();
            } else if (tipoSeleccion == 1) { // Préstamo de Equipo
                realizarPrestamoEquipo();
            }
        } else if (seleccion == 1) { // Devolución
            String[] tipoDevolucion = {"Libro", "Equipo"};
            int tipoSeleccion = showOptionDialog("Seleccione el tipo de devolución:", "Devolución", tipoDevolucion);

            if (tipoSeleccion == 0) { // Devolución de Libro
                realizarDevolucionLibro();
            } else if (tipoSeleccion == 1) { // Devolución de Equipo
                realizarDevolucionEquipo();
            }
        }
    }
    /*
    Metodo donde se va a realizar el prestamo del Libro, en donde lo primero que hace es verificar si el libro existe y que no este 
    prestado, despues verifica que el usuario exista, cuando todo este correcto le permite Insertar los datos del prestamo a la tabla prestamolibro
    */
    private void realizarPrestamoLibro() {
        String codigoLibro = getInput("Ingrese el código del libro:");
        String numeroDeUsuario = getInput("Ingrese el número de usuario:");

        Connection con = getConection();
        if (con == null) {
            showMessage("Error al conectar a la base de datos.");
            return;
        }

        try {
            // Verificar si el libro existe y no está prestado con un select, en la tabla libros
            String query = "SELECT * FROM libros AS l "
                    + "WHERE l.CodigoLibro = ? "
                    + "AND l.CodigoLibro NOT IN (SELECT CodigoLibro FROM prestamolibro WHERE numeroUsuario IS NOT NULL)";

            ps = con.prepareStatement(query);
            ps.setString(1, codigoLibro);
            rs = ps.executeQuery();

            if (!rs.next()) {
                showMessage("Libro no encontrado o ya está prestado.");
                return;
            }

            // Verificar si el usuario existe con un Select, en la tabla Usuario
            query = "SELECT * FROM usuarios WHERE numeroUsuario = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, numeroDeUsuario);
            rs = ps.executeQuery();

            if (!rs.next()) {
                showMessage("Usuario no encontrado.");
                return;
            }

            // Realizar el préstamo del libro, en donde se ingresa la informacion a la tabla prestamolibro
            String insertQuery = "INSERT INTO prestamolibro (CodigoLibro, numeroUsuario, fechaPrestamo) "
                    + "VALUES (?, ?, ?)";

            ps = con.prepareStatement(insertQuery);
            ps.setString(1, codigoLibro);
            ps.setString(2, numeroDeUsuario);
            ps.setDate(3, new java.sql.Date(System.currentTimeMillis())); // Fecha actual

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                showMessage("Préstamo de libro exitoso.");
            } else {
                showMessage("Error al realizar el préstamo.");
            }
        } catch (SQLException e) {
            showMessage("Error al realizar el préstamo.");
            e.printStackTrace();
        } finally {

        }
    }

    private void realizarDevolucionLibro() {
        String codigoLibro = getInput("Ingrese el código del libro:");
        String numeroDeUsuario = getInput("Ingrese el número de usuario:");

        Connection con = getConection();
        if (con == null) {
            showMessage("Error al conectar a la base de datos.");
            return;
        }

        try {
            // Verificar si el préstamo existe
            String query = "SELECT * FROM prestamolibro WHERE CodigoLibro = ? AND numeroUsuario = ? AND Devuelto = 0";

            ps = con.prepareStatement(query);
            ps.setString(1, codigoLibro);
            ps.setString(2, numeroDeUsuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Se encontró un préstamo activo para este libro y usuario
                // Actualizar la fecha de devolución y marcar como devuelto
                String updateQuery = "UPDATE prestamolibro SET FechaDevolucion = ?, Devuelto = 1 WHERE CodigoLibro = ? AND numeroUsuario = ?";

                ps = con.prepareStatement(updateQuery);
                ps.setDate(1, new java.sql.Date(System.currentTimeMillis())); // Fecha de devolución
                ps.setString(2, codigoLibro);
                ps.setString(3, numeroDeUsuario);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    showMessage("Devolución de libro exitosa.");
                } else {
                    showMessage("Error al realizar la devolución.");
                }
            } else {
                showMessage("No se encontró un préstamo activo para este libro y usuario.");
            }
        } catch (SQLException e) {
            showMessage("Error al realizar la devolución.");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void realizarPrestamoEquipo() {
        String codigoEquipo = getInput("Ingrese el código del equipo:");
        String numeroDeUsuario = getInput("Ingrese el número de usuario:");

        Connection con = getConection();
        if (con == null) {
            showMessage("Error al conectar a la base de datos.");
            return;
        }

        try {
            // Verificar si el libro existe y no está prestado
            String query = "SELECT * FROM equipos AS l "
                    + "WHERE l.CodigoEquipo = ? "
                    + "AND l.CodigoEquipo NOT IN (SELECT CodigoEquipo FROM prestamoequipo WHERE numeroUsuario IS NOT NULL)";

            ps = con.prepareStatement(query);
            ps.setString(1, codigoEquipo);
            rs = ps.executeQuery();

            if (!rs.next()) {
                showMessage("Libro no encontrado o ya está prestado.");
                return;
            }

            // Verificar si el usuario existe
            query = "SELECT * FROM usuarios WHERE numeroUsuario = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, numeroDeUsuario);
            rs = ps.executeQuery();

            if (!rs.next()) {
                showMessage("Usuario no encontrado.");
                return;
            }

            // Realizar el préstamo del equipo, en donde se ingresa la informacion a la tabla prestamoequipo
            String insertQuery = "INSERT INTO prestamoequipo (CodigoEquipo, numeroUsuario, fechaPrestamo) "
                    + "VALUES (?, ?, ?)";

            ps = con.prepareStatement(insertQuery);
            ps.setString(1, codigoEquipo);
            ps.setString(2, numeroDeUsuario);
            ps.setDate(3, new java.sql.Date(System.currentTimeMillis())); // Fecha actual

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                showMessage("Préstamo del equipo exitoso.");
            } else {
                showMessage("Error al realizar el préstamo.");
            }
        } catch (SQLException e) {
            showMessage("Error al realizar el préstamo.");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void realizarDevolucionEquipo() {
        String codigoEquipo = getInput("Ingrese el código del Equipo:");
        String numeroDeUsuario = getInput("Ingrese el número de usuario:");

        Connection con = getConection();
        if (con == null) {
            showMessage("Error al conectar a la base de datos.");
            return;
        }

        try {
            // Verificar si el préstamo existe
            String query = "SELECT * FROM prestamoequipo WHERE CodigoEquipo = ? AND numeroUsuario = ? AND Devuelto = 0";

            ps = con.prepareStatement(query);
            ps.setString(1, codigoEquipo);
            ps.setString(2, numeroDeUsuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Se encontró un préstamo activo para este libro y usuario
                // Actualizar la fecha de devolución y marcar como devuelto
                String updateQuery = "UPDATE prestamoequipo SET FechaDevolucion = ?, Devuelto = 1 WHERE CodigoEquipo = ? AND numeroUsuario = ?";

                ps = con.prepareStatement(updateQuery);
                ps.setDate(1, new java.sql.Date(System.currentTimeMillis())); // Fecha de devolución
                ps.setString(2, codigoEquipo);
                ps.setString(3, numeroDeUsuario);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    showMessage("Devolución de libro exitosa.");
                } else {
                    showMessage("Error al realizar la devolución.");
                }
            } else {
                showMessage("No se encontró un préstamo activo para este libro y usuario.");
            }
        } catch (SQLException e) {
            showMessage("Error al realizar la devolución.");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void buscarLibro() {
        Connection con;
        JTextField txtSearchTerm = new JTextField(20); // Crear un nuevo JTextField

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.add(new JLabel("Buscar Libro:"));
        searchPanel.add(txtSearchTerm);

        int result = JOptionPane.showConfirmDialog(null, searchPanel, "Buscar Libro",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                con = getConection();
                // Crear un nuevo JFrame para mostrar la tabla y el texto centrado
                JFrame resultFrame = new JFrame("Buscar Libro");
                JPanel mainPanel = new JPanel(new BorderLayout());
                String searchTerm = txtSearchTerm.getText(); // Obtener el término de búsqueda del campo de texto
                String query = "SELECT * FROM libros WHERE id = ? OR CodigoLibro LIKE ? OR titulo LIKE ? OR autor LIKE ? OR publicacion LIKE ? OR idioma LIKE ? OR genero LIKE ? OR link LIKE ? OR estado LIKE ?";

                ps = con.prepareStatement(query);
                ps.setString(1, searchTerm);
                ps.setString(2, "%" + searchTerm + "%"); // Búsqueda parcial en CodigoLibro
                ps.setString(3, "%" + searchTerm + "%"); // Búsqueda parcial en título
                ps.setString(4, "%" + searchTerm + "%"); // Búsqueda parcial en autor
                ps.setString(5, "%" + searchTerm + "%"); // Búsqueda parcial en publicacion
                ps.setString(6, "%" + searchTerm + "%"); // Búsqueda parcial en idioma
                ps.setString(7, "%" + searchTerm + "%"); // Búsqueda parcial en género
                ps.setString(8, "%" + searchTerm + "%"); // Búsqueda parcial en link
                ps.setString(9, "%" + searchTerm + "%"); // Búsqueda parcial en link

                rs = ps.executeQuery();

                // Crear un DefaultTableModel
                DefaultTableModel model = new DefaultTableModel();
                JTable table = new JTable(model);

                // Añadir columnas al modelo
                model.addColumn("ID");
                model.addColumn("CodigoLibro");
                model.addColumn("Título");
                model.addColumn("Autor");
                model.addColumn("Publicacion");
                model.addColumn("Idioma");
                model.addColumn("Genero");
                model.addColumn("Link");
                model.addColumn("Estado");

                // Procesar las filas de forma recursiva
                processLibros(model, rs);

                mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

                // Crear un JPanel para contener el JLabel y centrarlo
                JPanel labelPanel = new JPanel(new GridBagLayout());
                JLabel label = new JLabel("Buscar Libros");
                label.setFont(new Font("Arial", Font.BOLD, 16)); // Ajusta la fuente según tus preferencias

                // Configurar GridBagConstraints para centrar el JLabel
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(0, 0, 10, 0); // Espacio inferior
                gbc.gridx = 0;
                gbc.gridy = 0;
                labelPanel.add(label, gbc);

                // Agregar el panel del texto al panel principal
                mainPanel.add(labelPanel, BorderLayout.NORTH);

                resultFrame.add(mainPanel);
                resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                resultFrame.pack();
                resultFrame.setVisible(true);
            } catch (HeadlessException | SQLException e) {
                showMessage("Error al buscar libros en la base de datos.");
                System.err.println(e);
            }
        }
    }

    private String getInput(String message) {
        return JOptionPane.showInputDialog(frame, message);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    private int showOptionDialog(String message, String title, String[] options) {
        return JOptionPane.showOptionDialog(frame, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

    private void insertarLibroEnBD(Libro libro) {
        Connection con = null;
        try {
            con = getConection();
            ps = con.prepareStatement("INSERT INTO libros(CodigoLibro, titulo, autor,publicacion,idioma,genero,link) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, libro.getCodigoLibro());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setString(4, libro.getPublicacion());
            ps.setString(5, libro.getIdioma());
            ps.setString(6, libro.getGenero());
            ps.setString(7, libro.getLink());

            int res = ps.executeUpdate();
            if (res > 0) {
                showMessage("Libro se guardó correctamente en la base de datos.");

            } else {
                showMessage("Error: no se pudo guardar el libro en la base de datos.");

            }

            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void insertarUsuarioEnBD(Usuario usuario) {
        Connection con = null;
        try {
            con = getConection();
            ps = con.prepareStatement("INSERT INTO usuarios(numeroUsuario, nombre, apellido1,apellido2,telefono,correo) VALUES(?, ?, ?,?,?,?)");
            ps.setString(1, usuario.getNumeroDeUsuario());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido1());
            ps.setString(4, usuario.getApellido2());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getCorreo());

            int res = ps.executeUpdate();
            if (res > 0) {
                showMessage("Usuario se guardó correctamente en la base de datos.");

            } else {
                showMessage("Error: no se pudo guardar el libro en la base de datos.");

            }

            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void insertarEquipoEnBD(Equipo equipo) {
        Connection con = null;
        try {
            con = getConection();
            ps = con.prepareStatement("INSERT INTO equipos(CodigoEquipo,Nombre, Ubicacion, Descripcion) VALUES(?, ?, ?,?)");
            ps.setString(1, equipo.getCodigoEquipo());
            ps.setString(2, equipo.getNombre());
            ps.setString(3, equipo.getUbicacion());
            ps.setString(4, equipo.getDescripcion());

            int res = ps.executeUpdate();
            if (res > 0) {
                showMessage("Equipo se guardó correctamente en la base de datos.");

            } else {
                showMessage("Error: no se pudo guardar el equipo en la base de datos.");

            }

            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new BibliotecaGUI();
            } catch (SQLException ex) {
                Logger.getLogger(BibliotecaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}

class Biblioteca {

    private List<Libro> registroLibros;
    private List<Equipo> registroEquipos;
    private List<Usuario> registroUsuarios;
    private List<Prestamo> registroPrestamos;

    public Biblioteca() {
        registroLibros = new ArrayList<>();
        registroEquipos = new ArrayList<>();
        registroUsuarios = new ArrayList<>();
        registroPrestamos = new ArrayList<>();
    }

    public void registrarLibro(Libro libro) {
        registroLibros.add(libro);
    }

    public void registrarEquipo(Equipo equipo) {
        registroEquipos.add(equipo);
    }

    public void registrarUsuario(Usuario usuario) {
        registroUsuarios.add(usuario);
    }

    public void registrarPrestamo(Prestamo prestamo) {
        registroPrestamos.add(prestamo);
    }

    public List<Libro> getRegistroLibros() {
        return registroLibros;
    }

    public List<Equipo> getRegistroEquipos() {
        return registroEquipos;
    }

    public List<Usuario> getRegistroUsuarios() {
        return registroUsuarios;
    }

}

class Libro {

    private String CodigoLibro;
    private String titulo;
    private String autor;
    private String publicacion;
    private String idioma;
    private String genero;
    private String link;
    private boolean prestado;

    public Libro(String CodigoLibro, String titulo, String autor, String publicacion, String idioma, String genero, String link) {
        this.CodigoLibro = CodigoLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.idioma = idioma;
        this.genero = genero;
        this.link = link;
        this.prestado = false;
    }

    public Libro() {

    }

    public String getCodigoLibro() {
        return CodigoLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getGenero() {
        return genero;
    }

    public String getLink() {
        return link;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setCodigoLibro(String CodigoLibro) {
        this.CodigoLibro = CodigoLibro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "Libro{" + "CodigoLibro=" + CodigoLibro + ", titulo=" + titulo + ", autor=" + autor + ", publicacion=" + publicacion + ", idioma=" + idioma + ", genero=" + genero + ", link=" + link + ", prestado=" + prestado + '}';
    }

}

class Equipo {

    private String CodigoEquipo;
    private String nombre;
    private String ubicacion;
    private String Descripcion;
    private boolean prestado;

    public Equipo(String CodigoEquipo, String nombre, String ubicacion, String Descripcion) {
        this.CodigoEquipo = CodigoEquipo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.Descripcion = Descripcion;
        this.prestado = false;
    }

    public Equipo() {
        // Inicializa las variables u otros elementos necesarios aquí
    }

    public String getCodigoEquipo() {
        return CodigoEquipo;
    }

    public void setCodigoEquipo(String CodigoEquipo) {
        this.CodigoEquipo = CodigoEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", ubicacion=" + ubicacion + ", estado=" + Descripcion + ", prestado=" + prestado + '}';
    }

}

class Usuario {

    private String numeroDeUsuario;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String correo;
    private List<Libro> librosPrestados;

    Usuario(String numeroDeUsuario, String nombre, String apellido1, String apellido2, String telefono, String correo) {
        this.numeroDeUsuario = numeroDeUsuario;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.correo = correo;
        this.librosPrestados = new ArrayList<>();
    }

    public Usuario() {
        // Inicializa las variables u otros elementos necesarios aquí
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(numeroDeUsuario, usuario.numeroDeUsuario)
                && Objects.equals(nombre, usuario.nombre)
                && Objects.equals(apellido1, usuario.apellido1)
                && Objects.equals(apellido2, usuario.apellido2)
                && Objects.equals(telefono, usuario.telefono)
                && Objects.equals(correo, usuario.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroDeUsuario, nombre, apellido1, apellido2, telefono, correo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroDeUsuario() {
        return numeroDeUsuario;
    }

    public void setNumeroDeUsuario(String numeroDeUsuario) {
        this.numeroDeUsuario = numeroDeUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(List<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

}

class Prestamo {

    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = new Date();
        this.fechaDevolucion = null;
    }

    public Prestamo(Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) {
        this.libro = libro;

    }

    public Prestamo(Object object, Object object0, Date fechaPrestamo, Object object1) {

    }

    public Prestamo() {

    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void devolver() {
        fechaDevolucion = new Date();
    }

    public boolean estaPrestado() {
        return fechaDevolucion == null;
    }
}

class Devolucion {

    private Prestamo prestamo;
    private Date fechaDevolucion;

    public Devolucion(Prestamo prestamo) {
        this.prestamo = prestamo;
        this.fechaDevolucion = new Date();
    }

    public Devolucion() {

    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}

