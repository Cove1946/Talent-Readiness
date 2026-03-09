package dosw.bitacora.Corte2;

public class Main {

    public static void main(String[] args) {

        StudentExercise service = new StudentExercise();

        System.out.println("Estudiantes del equipo DORADO:");
        service.getStudentsFromDoradoTeam()
                .forEach(s -> System.out.println(s.name));

        System.out.println("\nNombres ordenados alfabeticamente:");
        service.getStudentNamesSorted()
                .forEach(System.out::println);

        double promedio = service.getAverageScore();
        System.out.println("\nPromedio general de los score del sistema: " + promedio);

    }
}
