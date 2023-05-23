package USER;

import BD.BD;

import java.util.ArrayList;
import java.util.List;


public class JPAUsersImpl implements JPAUsers {
    private static List<User> users = new ArrayList<User>();
    public static User user;

    @Override
    public void create(String body) {

        String[] data = body.split(",");

        user = new User(0, data[0], data[1], data[2]);
        String response = "Se ha creado el usuario con exito y sus datos son:\n" + "Id:" + user.getId() + ", " + " Nombres: " + user.getNames() + ", " +
                "Email: " + user.getEmail() + ", " + "Teléfono: " + user.getPhone();
        users.add(user);
        BD.storeData(String.valueOf(user.getId()),user.getNames(),user.getEmail(),user.getPhone());
        System.out.println(response);
    }


    @Override
    public List<User> readAll() {
        printUsers(users);
        return users;
    }

    @Override
    public void updateById(String body, int id) throws IndexOutOfBoundsException {


        for (User usuario : users) {
            if (usuario.getId() == id) {
                String[] data = body.split(",");
                user.setNames(data[0]);
                user.setEmail(data[1]);
                user.setPhone(data[2]);
                users.set(id-1, user);
                BD.updateDataById(String.valueOf(id),user.getNames(),user.getEmail(),user.getPhone());
                break;
            }
        }
        System.out.println("Se ha actualizado el usuario con éxito y sus datos son:\n" + "Id:" + user.getId() + ", " + " Nombres: " + user.getNames() + ", " +
                "Email: " + user.getEmail() + ", " + "Teléfono: " + user.getPhone());
    }


    @Override
    public void deleteById(int id) throws IndexOutOfBoundsException {
        boolean encontrado = false;
        users.removeIf(p -> p.getId() == id);
        System.out.println("Se ha eliminado el usuario con Id:" + id);
        printUsers(users);

    }

    @Override
    public void findAll() {

    }

    @Override
    public void findById(int id) {
        for (User usuario : users) {
            if (usuario.getId() == id) {
//                System.out.println("Se ha encontrado el usuario con Id:" + id);
//                System.out.println(usuario.toString());
            }
        }
    }

    static void printUsers(List<User> users) {
        System.out.println("Lista de usuarios:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println("\n{\n\t\"id\":" + users.get(i).getId() + "," + "\n\t\"nombres\":" + users.get(i).getNames() + "\"," +
                    "\n\t\"email\":" + "\"" + users.get(i).getEmail() + "\",\n\t\"phone\":" + "\"" + users.get(i).getPhone() + "\"\n\t\t\t\t\t\t},");
        }
    }
}
