import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Hilo extends Thread {
String palabra;
public Hilo(String palabra){
this.palabra = palabra;
}

@Override
public void run(){

    try {
        //Creacion de socket cliente
        Socket clientSocket = new Socket("LocalHost", 6789);
        //Creacion de flujo por donde saldran los datos al servidor 
        DataOutputStream fSalida = new DataOutputStream(clientSocket.getOutputStream()); 
        BufferedReader eServidor = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //Enviamos lo que tenemos desde el servidor

        for (int i = 2; i < 8; i++){
            fSalida.writeBytes(i + "\n");
        }
        String respuesta="";
        for (int i = 0; i < 5; i++){
       respuesta += eServidor.readLine();

        }
            
        

        System.out.println("Respuesta del servidor: " + respuesta);
        clientSocket.close();
    } catch (IOException e) {
        System.err.println("Error de entrada/salida: " + e.getMessage());
    }
}
}
