package UI;

import Logica.Experimento;
import Datos.Archivos;
import Datos.PoblacionBacterias;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazUsuario {
    private Experimento experimento;
    private Archivos archivos;
    private JFrame frame;

    public InterfazUsuario() {
        experimento = new Experimento();
        archivos = new Archivos();
        frame = new JFrame("Interfaz de Usuario");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Establecer el administrador de diseño
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JButton button = new JButton("Mostrar Menú");

        button.setFont(new java.awt.Font("Tahoma", 0, 24));
        button.setBackground(new java.awt.Color(0, 102, 102));
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMenu();
            }
        });

        frame.getContentPane().add(button);
        frame.setVisible(true);
    }

    public void mostrarMenu() {
        String[] options = new String[] {
                "Abrir un archivo que contenga un experimento",
                "Crear un nuevo experimento",
                "Crear una población de bacterias y añadirla al experimento actual",
                "Visualizar los nombres de todas las poblaciones de bacterias del experimento actual",
                "Borrar una población de bacterias del experimento actual",
                "Ver información detallada de una población de bacterias del experimento actual",
                "Guardar",
                "Guardar como",
                "Salir"
        };

        JList<String> list = new JList<>(options);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(200, 200)); // Ajusta el tamaño según tus necesidades

        int response = JOptionPane.showOptionDialog(frame, "Por favor, elija una opción del menú:", "Menú",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        ejecutarOpcion(response + 1);
    }

    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                String nombreArchivo = JOptionPane.showInputDialog(frame, "Ingrese el nombre del archivo:");
                experimento = archivos.abrirArchivo(nombreArchivo);
                break;
            case 2:
                experimento = new Experimento();
                break;
            case 3:
                // Aquí deberías pedir al usuario los datos necesarios para crear una nueva población de bacterias
                // y luego agregarla al experimento actual.
                break;
            case 4:
                for (PoblacionBacterias poblacion : experimento.obtenerPoblaciones()) {
                    System.out.println(poblacion.getNombre());
                }
                break;
            case 5:
                String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre de la población de bacterias que desea eliminar:");
                experimento.eliminarPoblacion(nombre);
                break;
            case 6:
                nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre de la población de bacterias que desea ver:");
                PoblacionBacterias poblacion = experimento.obtenerPoblacion(nombre);
                if (poblacion != null) {
                    // Aquí deberías imprimir la información detallada de la población de bacterias
                } else {
                    JOptionPane.showMessageDialog(frame, "No se encontró la población de bacterias.");
                }
                break;
            case 7:
                nombreArchivo = JOptionPane.showInputDialog(frame, "Ingrese el nombre del archivo donde desea guardar:");
                archivos.guardarArchivo(nombreArchivo, experimento.obtenerPoblaciones());
                break;
            case 8:
                nombreArchivo = JOptionPane.showInputDialog(frame, "Ingrese el nombre del nuevo archivo donde desea guardar:");
                archivos.guardarComoArchivo(nombreArchivo, experimento.obtenerPoblaciones());
                break;
            case 9:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(frame, "Opción no válida. Por favor, elija una opción del menú.");
                break;
        }
    }

    public static void main(String[] args) {
        new InterfazUsuario();
    }
}