package UI;

import Logica.Experimento;
import Datos.Archivos;
import Datos.PoblacionBacterias;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InterfazUsuario {
    private Experimento experimento;
    private Archivos archivos;
    private JFrame frame;

    public InterfazUsuario() {
        experimento = new Experimento("Experimento", "Descripción del experimento");
        archivos = new Archivos();
        frame = new JFrame("Interfaz de Usuario");
        frame.setSize(200, 100);
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

        button.setForeground(new java.awt.Color(255, 255, 255));
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
        list.setFixedCellWidth(400);
        list.setFixedCellHeight(20);
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (c instanceof JLabel) {
                    JLabel label = (JLabel) c;
                    label.setText("<html>" + value.toString() + "</html>"); // Permite el ajuste de línea
                }
                return c;
            }
        });

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(400, 200)); // Ajusta el tamaño según tus necesidades

        int response = JOptionPane.showOptionDialog(frame, scrollPane, "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
        if (response != JOptionPane.CLOSED_OPTION) {
            ejecutarOpcion(list.getSelectedIndex() + 1);
        }
    }

    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                String nombreArchivo = JOptionPane.showInputDialog(frame, "Ingrese el nombre del archivo:");
                experimento = archivos.abrirArchivo(nombreArchivo);
                if (experimento != null) {
                    JOptionPane.showMessageDialog(frame, "Se ha abierto el archivo correctamente.", "Archivo Abierto", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "No se pudo abrir el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 2:
                String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre del nuevo experimento:");
                String descripcion = JOptionPane.showInputDialog(frame, "Ingrese una descripción para el nuevo experimento:");
                experimento = new Experimento(nombre, descripcion);
                JOptionPane.showMessageDialog(frame, "Se ha creado un nuevo experimento.", "Nuevo Experimento", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3:
                String nombrePoblacion = JOptionPane.showInputDialog(frame, "Ingrese el nombre de la población de bacterias:");
                Date fechaInicio = parseDate("Ingrese la fecha de inicio del experimento (dd/mm/yyyy):");
                Date fechaFin = parseDate("Ingrese la fecha de fin del experimento (dd/mm/yyyy):");
                int cantidadInicial = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la cantidad inicial de bacterias:"));
                double temperatura = Double.parseDouble(JOptionPane.showInputDialog(frame, "Ingrese la temperatura:"));
                String condicionesLuz = JOptionPane.showInputDialog(frame, "Ingrese las condiciones de luz:");
                int dosisInicialAlimento = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la dosis inicial de alimento:"));
                int dosisFinalAlimento = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la dosis final de alimento:"));

                PoblacionBacterias nuevaPoblacion = new PoblacionBacterias(nombrePoblacion, fechaInicio, fechaFin, cantidadInicial, temperatura, condicionesLuz, dosisInicialAlimento, 10, 100);
                JOptionPane.showMessageDialog(frame, "Población de bacterias añadida con éxito al experimento actual.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                experimento.agregarPoblacion(nuevaPoblacion);
                break;
            case 4:
                for (PoblacionBacterias poblacion : experimento.obtenerPoblaciones()) {
                    System.out.println(poblacion.getNombre());
                }
                break;
            case 5:
                String nombrePoblacioneliminar = JOptionPane.showInputDialog(frame, "Ingrese el nombre de la población de bacterias que desea eliminar:");
                experimento.eliminarPoblacion(nombrePoblacioneliminar);
                break;
            case 6:
                nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre de la población de bacterias de la que desea ver la información detallada:");
                PoblacionBacterias poblacion = experimento.obtenerPoblacion(nombre);
                if (poblacion != null) {
                String informacionDetallada = "Nombre: " + poblacion.getNombre() + "\n" +
                            "Fecha de inicio: " + poblacion.getFechaInicio() + "\n" +
                            "Fecha de fin: " + poblacion.getFechaFin() + "\n" +
                            "Cantidad inicial de bacterias: " + poblacion.getCantidadInicialBacterias() + "\n" +
                            "Temperatura: " + poblacion.getTemperatura() + "\n" +
                            "Condiciones de luz: " + poblacion.getCondicionesLuz() + "\n" +
                            "Dosis inicial de alimento: " + poblacion.getDosisInicialAlimento() + "\n" +
                            "Dosis final de alimento: " + poblacion.getDosisFinalAlimento() + "\n" +
                            "Incrementar hasta el día: " + poblacion.getIncrementarHastaDia() + "\n" +
                            "Dosis diaria de alimento:\n";
                    int[] dosisDiariaAlimento = poblacion.getDosisDiariaAlimento();
                    for (int i = 0; i < dosisDiariaAlimento.length; i++) {
                        informacionDetallada += "Día " + (i + 1) + ": " + dosisDiariaAlimento[i] + "\n";
                    }
                    JOptionPane.showMessageDialog(frame, informacionDetallada, "Información detallada de la población de bacterias", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "No se encontró la población de bacterias.");
                }
                break;
            case 7:
                nombreArchivo = JOptionPane.showInputDialog(frame, "Ingrese el nombre del archivo donde desea guardar:");
                archivos.guardarArchivo(nombreArchivo, experimento);
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

    private Date parseDate(String mensaje) {
        Date date = null;
        while (date == null) {
            String fechaStr = JOptionPane.showInputDialog(frame, mensaje);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                date = formatter.parse(fechaStr);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(frame, "Fecha no válida. Por favor, ingrese la fecha en el formato correcto (dd/mm/yyyy).");
            }
        }
        return date;
    }

    public static void main(String[] args) {
        new InterfazUsuario();
    }
}