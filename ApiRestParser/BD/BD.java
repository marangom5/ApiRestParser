package BD;

import java.util.Arrays;

public class BD {

    private static String[][] data=new String[0][0];

    public static void storeData(String id, String nombre, String email, String phone) {
        // Crear una nueva fila en la matriz multidimensional
        String[] row = new String[4];
        row[0] = id;
        row[1] = nombre;
        row[2] = email;
        row[3] = phone;

        // Agregar la nueva fila a la matriz multidimensional
        data = Arrays.copyOf(data, data.length + 1);
        data[data.length - 1] = row;
    }

    public static void deleteDataById(String id) {
        // Buscar la fila que coincida con el id
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i][0].equals(id)) {
                index = i;
                break;
            }
        }

        // Si se encontró la fila, eliminarla
        if (index != -1) {
            data = Arrays.copyOfRange(data, 0, index);
        }
    }

    public static void printData() {
        System.out.println("id  nombre  correo  numero");
        for (String[] row : data) {
            System.out.println(row[0] + "   " + row[1] + "  " + row[2] + "  " + row[3]);
        }
    }

    public static void updateDataById(String id, String nombre, String email, String phone) {
        // Buscar la fila que coincida con el id
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i][0].equals(id)) {
                index = i;
                break;
            }
        }

        // Si se encontró la fila, actualizarla
        if (index != -1) {
            data[index][1] = nombre;
            data[index][2] = email;
            data[index][3] = phone;
        } else {
            System.out.println("No se encontró ningún dato con el id " + id);
        }
    }

}