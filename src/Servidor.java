import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6789);
            System.out.println("Servidor en espera de peticiones...");
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado");

                BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream salida = new DataOutputStream(clientSocket.getOutputStream());

                String num1 = entrada.readLine();
                String num2 = entrada.readLine();
                String num3 = entrada.readLine();
                String num4 = entrada.readLine();
                String num5 = entrada.readLine();
                
                String opcion = entrada.readLine();

                int[] numeros = new int[5];
                numeros[0] = Integer.parseInt(num1);
                numeros[1] = Integer.parseInt(num2);
                numeros[2] = Integer.parseInt(num3);
                numeros[3] = Integer.parseInt(num4);
                numeros[4] = Integer.parseInt(num5);

                String respuesta = "";

                if (opcion.equals("Ordenar de mayor a menor")) {
                    // Ordenar de mayor a menor 
                    for (int i = 0; i < numeros.length; i++) {
                        for (int j = i + 1; j < numeros.length; j++) {
                            if (numeros[i] < numeros[j]) {
                                int temp = numeros[i];
                                numeros[i] = numeros[j];
                                numeros[j] = temp;
                            }
                        }
                    }
                    respuesta = "Ordenados de mayor a menor: " + numeros[0] + ", " + numeros[1] + ", " + numeros[2] + ", " + numeros[3] + ", " + numeros[4];
               
                } else if (opcion.equals("Ordenar de menor a mayor")) {
                    // Ordenar de menor a mayor 
                    for (int i = 0; i < numeros.length; i++) {
                        for (int j = i + 1; j < numeros.length; j++) {
                            if (numeros[i] > numeros[j]) {
                                int temp = numeros[i];
                                numeros[i] = numeros[j];
                                numeros[j] = temp;
                            }
                        }
                    }
                    respuesta = "Ordenados de menor a mayor: " + numeros[0] + ", " + numeros[1] + ", " + numeros[2] + ", " + numeros[3] + ", " + numeros[4];
              
                } else if (opcion.equals("Sumatoria de los numeros")) {
                    // Calcular la sumatoria
                    int sumatoria = 0;
                    for (int i = 0; i < numeros.length; i++) {
                        sumatoria += numeros[i];
                    }
                    respuesta = "La sumatoria es: " + sumatoria;
              
                } else if (opcion.equals("Promedio de los numeros")) {
                    // Calcular el promedio
                    int total = 0;
                    for (int i = 0; i < numeros.length; i++) {
                        total += numeros[i];
                    }
                    double promedio = total / 5.0;
                    respuesta = "El promedio es: " + promedio;
               
                } else if (opcion.equals("Numero mayor")) {
                    // Encontrar el numero mayor
                    int maximo = numeros[0];
                    for (int i = 1; i < numeros.length; i++) {
                        if (numeros[i] > maximo) {
                            maximo = numeros[i];
                        }
                    }
                    respuesta = "El numero mayor es: " + maximo;
                } else {
                    respuesta = "Opcion no valida";
                }

                // Enviar la respuesta al cliente
                salida.writeBytes(respuesta + "\n");

                //clientSocket.close();
                //System.out.println("Cliente desconectado");
            }
        } catch (IOException e) {
        }
    }
}