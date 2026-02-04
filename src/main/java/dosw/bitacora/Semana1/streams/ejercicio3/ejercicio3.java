package dosw.bitacora.Semana1.streams.ejercicio3;

import java.util.List;

public class ejercicio3 {

    public static List<String> activeUsers(List<user> users){
        return users.stream().filter(user::isActive)
                .map(e -> e.getName().toUpperCase())
                .sorted().toList();
    }

    public static void main(String[] args) {
        List<user> students = List.of(
                new user(100101455, "Cristian Guerrero", 20, true),
                new user(100102031, "Camila Guerrero", 20, false),
                new user(100201544, "Santiago Giraldo", 19, false)
        );

        List<String> activeStudents = activeUsers(students);

        activeStudents.forEach(System.out::println);
    }
}