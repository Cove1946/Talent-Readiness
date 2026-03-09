package dosw.bitacora.Corte2;

import java.util.Map;

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

        Map<String, Double> promedioMaterias = service.getAverageScoreBySubject();
        System.out.println("\nPromedio por materia de cada estudiante: ");
        promedioMaterias.forEach((subject, score) ->
                System.out.println(subject + " -> " + score));

        Student bestStudent = service.getBestStudent();
        System.out.println("\nEl mejor estudiante es: " + bestStudent.name);

    }
}
