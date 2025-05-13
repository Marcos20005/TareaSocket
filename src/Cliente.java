import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cliente {
    static JButton btn;
    static JButton btn6; 
    static String palabra;
    static String resultadoServidor = "";

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Almacenes S.A");
        Container conte = new Container();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        btn = new JButton("Agregar números");
        btn.setBounds(80, 110, 200, 30);
        conte.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vIngreso();
            }
        });

        btn6 = new JButton("Salir");
        btn6.setBounds(80, 170, 200, 30);
        conte.add(btn6);

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(conte);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static public void vIngreso() {
        String opciones[] = {"Ordenar de mayor a menor", "Ordenar de menor a mayor", "Sumatoria de los numeros", "Promedio de los numeros", "Numero mayor"};

        JFrame frame = new JFrame("Ingreso de números");
        frame.setSize(400, 400);
        Container conte = new Container();

        JLabel lBl = new JLabel("Ingrese el valor #1:");
        lBl.setBounds(60, 30, 200, 30);
        conte.add(lBl);
        JTextField txt = new JTextField();
        txt.setBounds(60, 70, 100, 30);
        conte.add(txt);

        JLabel lBl2 = new JLabel("Ingrese el valor #2:");
        lBl2.setBounds(60, 120, 200, 30);
        conte.add(lBl2);
        JTextField txt2 = new JTextField();
        txt2.setBounds(60, 160, 100, 30);
        conte.add(txt2);

        JLabel lBl3 = new JLabel("Ingrese el valor #3:");
        lBl3.setBounds(240, 30, 200, 30);
        conte.add(lBl3);
        JTextField txt3 = new JTextField();
        txt3.setBounds(240, 70, 100, 30);
        conte.add(txt3);

        JLabel lBl4 = new JLabel("Ingrese el valor #4:");
        lBl4.setBounds(240, 120, 200, 30);
        conte.add(lBl4);
        JTextField txt4 = new JTextField();
        txt4.setBounds(240, 160, 100, 30);
        conte.add(txt4);

        JLabel lBl5 = new JLabel("Ingrese el valor #5:");
        lBl5.setBounds(60, 210, 200, 30);
        conte.add(lBl5);
        JTextField txt5 = new JTextField();
        txt5.setBounds(60, 250, 100, 30);
        conte.add(txt5);

        JLabel lBl6 = new JLabel("Seleccione opción:");
        lBl6.setBounds(240, 210, 200, 30);
        conte.add(lBl6);

        JComboBox txt6 = new JComboBox(opciones);
        txt6.setBounds(210, 250, 170, 30);
        conte.add(txt6);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(120, 300, 150, 30);
        conte.add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Capturamos los valores de los campos de texto
                String num1 = txt.getText();
                String num2 = txt2.getText();
                String num3 = txt3.getText();
                String num4 = txt4.getText();
                String num5 = txt5.getText();

                String opcion = (String) txt6.getSelectedItem();

                // Llamamos al hilo con los números y la opción
                Hilo miHilo = new Hilo(num1, num2, num3, num4, num5, opcion);
                frame.dispose();
                miHilo.start();
            }
        });

        frame.add(conte);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


