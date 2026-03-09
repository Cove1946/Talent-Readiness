package dosw.bitacora.Corte1.streams.ejercicio5;

import java.util.List;

public class ejercicio5 {

    public static List<String> filterAges(List<user> users){
        return users.stream().filter(e -> e.getAge() > 18)
                .map(user::getName)
                .toList();
    }

    public static void main(String[] args) {
        List<user> students = List.of(
                new user(1013592501, "Cristian Guerrero", 20, true),
                new user(1014591201, "Camila Flores", 21, true),
                new user(1013592501, "Natalia Ramos", 17, true)
        );

        List<String> studentsAge = filterAges(students);

        studentsAge.forEach(System.out::println);
    }



}
