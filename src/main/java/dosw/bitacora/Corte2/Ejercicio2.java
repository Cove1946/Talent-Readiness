package dosw.bitacora.Corte2;

public class Ejercicio2 {

    public static void main(String[] args) {

        StudentsInfo.getStudents().stream()
                .map(s -> s.name)
                .sorted()
                .forEach(System.out::println);
    }

}
