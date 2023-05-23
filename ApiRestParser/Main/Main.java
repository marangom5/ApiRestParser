package Main;


import BD.BD;
import controller.Server;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Crea una nueva instancia de la clase BD
        BD db = new BD();
        Scanner s=new Scanner(System.in);
        while (true){
            System.out.println("\n");
            // Imprime el menú
            System.out.println("¿Qué te gustaría hacer?");
            System.out.println("1. Leer usuarios existentes");
            System.out.println("2. Buscar un usuario");
            System.out.println("3. Crear un usuario");
            System.out.println("4. Editar información de un usuario existente");
            System.out.println("5. Eliminar un usuario");
            System.out.println("6. Salir");

            // Obtener la elección del usuario
            int choice = Integer.parseInt(s.nextLine());

            // Cambiar según la elección del usuario

            switch (choice) {
                case 1:
                    Server request=new Server("GET", "http://localhost:8080/api/users", "Content-Type: application/json", "");
                    break;
                case 2:
                    System.out.println("Digite el id");
                    int id = Integer.parseInt(s.nextLine());
                    Server request1=new Server("GET", "http://localhost:8080/api/users", "Content-Type: application/json", "",id);
                    break;

                case 3:
                    System.out.println("Digite el Nombre");
                    String nombre = (s.nextLine());
                    System.out.println("Digite el correo");
                    String correo=s.nextLine();
                    System.out.println("Digite el numero celular");
                    int numero= Integer.parseInt(s.nextLine());
                    Server request2 = new Server("POST", "http://localhost:8080/api/users", "Content-Type: application/json", nombre+","+correo+","+String.valueOf(numero));
                    break;

                case 4:
                    System.out.println("Digite el Nombre");
                    String nombre1 = (s.nextLine());
                    System.out.println("Digite el correo");
                    String correo1=s.nextLine();
                    System.out.println("Digite el numero celular");
                    double numero1= Double.parseDouble(s.nextLine());
                    System.out.println("Digite el Id");
                    int id1= Integer.parseInt(s.nextLine());
                    Server request4 = new Server("PUT", "http://localhost:8080/api/users", "Content-Type: application/json", nombre1+","+correo1+","+String.valueOf(numero1), id1);
                    break;

                case 5:
                    System.out.println("Digite el Id");
                    int id2= Integer.parseInt(s.nextLine());
                    Server request5 = new Server("DELETE", "http://localhost:8080/api/users", "Content-Type: application/json", "",id2);
                    break;

                case 6:
                    // Salir
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("¡Elección inválida!");
                    break;
            }
        }
        }

}