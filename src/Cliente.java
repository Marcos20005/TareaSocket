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
import javax.swing.JTextField;

public class Cliente{
   static JButton btn;
static JButton btn2;
static JButton btn3;
static JButton btn4;
static JButton btn5;
static JButton btn6;
static String palabra;

    public static void main(String[] args) throws Exception {
       ArrayList<Inventario> inventario = new ArrayList<>();

       JFrame frame = new JFrame("Almacenes S.A");
       Container conte = new Container();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(400, 400);
          btn = new JButton("Agregar numeros");
         btn.setBounds(80, 80, 200, 30);
         conte.add(btn);
         btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al método vIngreso() cuando se presione el botón
                vIngreso();
            }
         });
         btn2 = new JButton("Mostrar informacion");
         btn2.setBounds(80, 130, 200, 30);
         conte.add(btn2);
             btn6 = new JButton("Salir");
            btn6.setBounds(80, 180, 200, 30);
         conte.add(btn6);
         frame.add(conte);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
    
    }
   static public void vIngreso(){
    String opciones[] = {"Ordebar de mayor a menor","Ordenar de menor a mayor","Sumatoria de los numeros ", "Promedio de los numeros","Numero mayor"};
         JFrame frame = new JFrame("Ingreso de numeros");
         frame.setSize(400,400);
         Container conte = new Container();
         JLabel lBl = new JLabel("Ingrese el valor #1:");
         lBl.setBounds(60,30,200,30);
         conte.add(lBl);
         frame.add(conte);
         JTextField txt = new JTextField();
         txt.setBounds(60,70,100,30);
         conte.add(txt);
         JLabel lBl2 = new JLabel("Ingrese el valor #2:");
         lBl2.setBounds(60,120,200,30);
         conte.add(lBl2);
         JTextField txt2 = new JTextField();
            txt2.setBounds(60,160,100,30);
            conte.add(txt2);
            JLabel lBl3 = new JLabel("Ingrese el valor #3:");
            lBl3.setBounds(240,30,200,30);
            conte.add(lBl3);
            JTextField txt3 = new JTextField();
            txt3.setBounds(240,70,100,30);
            conte.add(txt3);
            JLabel lBl4 = new JLabel("Ingrese el valor #4:");
            lBl4.setBounds(240,120,200,30);
            conte.add(lBl4);
            JTextField txt4 = new JTextField();
            txt4.setBounds(240,160,100,30);
            conte.add(txt4);
            JLabel lBl5 = new JLabel("Ingrese el valor #5:");
            lBl5.setBounds(60,210,200,30);
            conte.add(lBl5);
            JTextField txt5 = new JTextField();
            txt5.setBounds(60,250,100,30);
            conte.add(txt5);
            JLabel lBl6 = new JLabel("Selecione opcion:");
            lBl6.setBounds(240, 210, 200,30);
            conte.add(lBl6);
            JComboBox txt6 = new JComboBox(opciones);
            txt6.setBounds(210,250,170,30);
            conte.add(txt6);
         JButton btn = new JButton("Guardar");
         btn.setBounds(120,300,150,30);
         conte.add(btn);
         btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               palabra = txt.getText();
             Hilo miHilo = new Hilo(txt.getText());
              miHilo.start();  
            }
         });
         btn6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            System.exit(0);   
            }
         });
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
         
    }
    
}
