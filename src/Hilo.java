import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Hilo extends Thread {
    String num1, num2, num3, num4, num5, opcion;

    public Hilo(String num1, String num2, String num3, String num4, String num5, String opcion) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.opcion = opcion;
    }

    @Override
    public void run() {
        try {
            // Crear el socket cliente
            Socket clientSocket = new Socket("LocalHost", 6789);
            DataOutputStream salida = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Enviar los números ingresados
            salida.writeBytes(num1 + "\n");
            salida.writeBytes(num2 + "\n");
            salida.writeBytes(num3 + "\n");
            salida.writeBytes(num4 + "\n");
            salida.writeBytes(num5 + "\n");

            salida.writeBytes(opcion + "\n");

            // Leer la respuesta del servidor
            String respuesta;
           respuesta = entrada.readLine();
        Cliente.resultadoServidor = respuesta;
        JOptionPane.showMessageDialog(null, Cliente.resultadoServidor);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


