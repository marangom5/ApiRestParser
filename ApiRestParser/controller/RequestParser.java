package controller;

import java.util.Scanner;

public class RequestParser {

    private static final String CRLF = "\r\n";

    public static boolean isValidRequest(String request) {
        // Revisa la línea de solicitud.
        String[] requestLineParts = request.split(CRLF)[0].split(" ");
        if (requestLineParts.length != 3) {
            System.out.println("la solicitud no esta completa");
            return false;
        }
        // Obtiene el método de la solicitud.
        String method = requestLineParts[0];
        // Obtiene la URI de la solicitud.
        String uri = requestLineParts[1];

        // Obtiene la versión de la solicitud.
        String version = requestLineParts[2];

        // Verifica si el método es válido.
        if (!isValidMethod(method)) {
            System.out.println("Metodo no es valido");
            return false;
        }
        // Verifica si la URI es válida.
        if (!isValidUri(uri)) {
            System.out.println("URI no es valida");
            return false;
        }
        // Verifica si la versión es válida.
        if (!isValidVersion(version)) {
            System.out.println("La version no es valida");
            return false;
        }

        return true;
    }

    // Verifica si el método es válido.
    private static boolean isValidMethod(String method) {
        return method.equals("OPTIONS") ||
                method.equals("GET") ||
                method.equals("HEAD") ||
                method.equals("POST") ||
                method.equals("PUT") ||
                method.equals("DELETE") ||
                method.equals("TRACE") ||
                method.equals("CONNECT");
    }

    // Verifica si la URI es válida.
    private static boolean isValidUri(String uri) {
        if (!uri.startsWith("http://") && !uri.startsWith("https://")) {
            return false;
        }
        return true;
    }

    // Verifica si el host es válido.
    private static boolean isValidHost(String host) {
        if (host.length() < 1) {
            return false;
        }

        for (char c : host.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        return true;
    }

    // Verifica si el path es válido.
    private static boolean isValidPath(String path) {
        if (path.length() < 1) {
            return false;
        }

        for (char c : path.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '/') {
                return false;
            }
        }

        return true;
    }

    // Verifica si la versión es válida.
    private static boolean isValidVersion(String version) {
        return version.equals("HTTP/1.0") || version.equals("HTTP/1.1");
    }

    public static boolean isValidHeader(String header) {
        // Parsea la línea del encabezado.
        String[] headerLineParts = header.split(CRLF)[1].split(": ");
        if (headerLineParts.length != 2) {
            System.out.println("El encabezado no está completo");
            return false;
        }

        String nombre = headerLineParts[0];
        String valor = headerLineParts[1];

        // Verifica si el nombre es válido.
        if (!isValidName(nombre)) {
            System.out.println("El encabezado no tiene un nombre válido");
            return false;
        }

        // Verifica si el valor es válido.
        if (!isValidValue(valor)) {
            System.out.println("El encabezado no tiene un valor válido");
            return false;
        }

        return true;
    }

    private static boolean isValidName(String name) {
        if (name.isEmpty()) {
            return false;
        }

        for (char c : name.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '-' && c != '_') {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidValue(String value) {
        return !value.isEmpty();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String request = scanner.nextLine();

            System.out.println(isValidRequest(request) ? "Valid request" : "Invalid request");
        }
    }

}






