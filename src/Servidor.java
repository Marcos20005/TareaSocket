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
 System.out.println("Servidor en espera de peticiones...");
 //Se declara un while por defecto para que se mantenga el servidor activo
 while (true) { 
    //Inicializamos otro pero que sea solo de la clase Socket para establecer la conexxion
     Socket sConexion = sSocket.accept();
     System.out.println("Cliente conectado");
     //Se crea buffer para que me escriba en determinada variable la informacion que necesito para el procesar
  BufferedReader in = new BufferedReader(new InputStreamReader(sConexion.getInputStream()));
  //Se crea un dataoutputstream para que sea el archivo que voy a enviar
  DataOutputStream sCliente = new DataOutputStream(sConexion.getOutputStream());
  //Se procesa de la manera en que programemos la informacion recibida
for (int i = 0; i < 5; i++) {
    palabraTrabajo = in.readLine();
    vector[i]= Integer.parseInt(palabraTrabajo);
}
String opcion = in.readLine();
System.out.println("Opcion: "+opcion);

//Se ordena de mayor a menor
if(opcion.equals("1")){
for(int i = 0; i < 5; i++) {
for(int j = 0; j < 5; j++) {
    if(vector[i] < vector[j]) {
        int temp = vector[i];
        vector[i] = vector[j];
        vector[j] = temp;
        }
    }
}
for (int i = 0; i < 5; i++) {
    sCliente.writeBytes(vector[i]+"\n");
}

//Se ordena de menor a mayor
} else if(opcion.equals("2")){
    for(int i = 0; i < 5; i++) {
for(int j = 0; j < 5; j++) {
    if(vector[i] > vector[j]) {
        int temp = vector[i];
        vector[i] = vector[j];
        vector[j] = temp;
        }
    }
}
for (int i = 0; i < 5; i++) {
    sCliente.writeBytes(vector[i]+"\n");
}

//Se calcula la suma
} else if(opcion.equals("3")){
    int suma = 0;
    for (int i = 0; i < 5; i++) {
        suma += vector[i];
    }
    sCliente.writeBytes("La suma es: "+suma+"\n");

    //Se calcula el promedio
} else if(opcion.equals("4")){
    int suma = 0;
    for (int i = 0; i < 5; i++) {
        suma += vector[i];
    }
    double promedio = suma / 5.0;
    sCliente.writeBytes("El promedio es: "+promedio+"\n");

    //Se calcula el mayor
} else if(opcion.equals("5")){
    int mayor = vector[0];
    for (int i = 1; i < 5; i++) {
        if (vector[i] > mayor) {
            mayor = vector[i];
        }
    }
    sCliente.writeBytes("El mayor es: "+mayor+"\n");

}else{
    sCliente.writeBytes("Opcion no valida\n");

}
sConexion.close();
System.out.println("Cliente desconectado");
}
}  
}

