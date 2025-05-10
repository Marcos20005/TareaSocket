import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {
 static int vector[] = new int[5];
public static void main(String[] args) throws IOException {
for (int i = 0; i < 5; i++) {
    vector[i] = i;
}
  //Instancia de variables a utilizar para el proceso del servidor
String palabraTrabajo = "0";
//Creacion de socket servidor
 ServerSocket sSocket = new ServerSocket(6789); 
 //Se declara un while por defecto para que se mantenga el servidor activo
 while (true) { 
    //Inicializamos otro pero que sea solo de la clase Socket para establecer la conexxion
     Socket sConexion = sSocket.accept();
     //Se crea buffer para que me escriba en determinada variable la informacion que necesito para el prcesar
  BufferedReader in = new BufferedReader(new InputStreamReader(sConexion.getInputStream()));
  //Se crea un dataoutputstream para que sea el archivo que voy a enviar
  DataOutputStream sCliente = new DataOutputStream(sConexion.getOutputStream());
  //Se procesa de la manera en que programemos la informacion recibida
for (int i = 0; i < 5; i++) {
    palabraTrabajo = in.readLine();
    vector[i]= Integer.parseInt(palabraTrabajo);
}

palabraTrabajo = palabraTrabajo.toUpperCase()+"\n";
//A travez del dataoutputStream se emvia la informacion al cliente

for (int i = 0; i < 5; i++) {
    sCliente.writeBytes(vector[i]+"\n");
}
}  
}
}
