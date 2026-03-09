package dosw.bitacora.Corte2;

public class Ejercicio1 {

    public static void main(String[] args) {

        StudentsInfo.getStudents().stream()
                .filter(s -> s.team.equals("DORADO"))
                .forEach(s -> System.out.println(s.name));

    }
}
