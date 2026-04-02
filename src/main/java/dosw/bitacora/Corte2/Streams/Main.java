package dosw.bitacora.Corte2.Streams;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        StudentExercise service = new StudentExercise();

        //Punto 1
        System.out.println("Estudiantes del equipo DORADO:");
        service.getStudentsFromDoradoTeam()
                .forEach(s -> System.out.println(s.name));

        //Punto 2
        System.out.println("\nNombres ordenados alfabeticamente:");
        service.getStudentNamesSorted()
                .forEach(System.out::println);

        //Punto 3
        double promedio = service.getAverageScore();
        System.out.println("\nPromedio general de los score del sistema: " + promedio);

        //Punto 4
        Map<String, Double> promedioMaterias = service.getAverageScoreBySubject();
        System.out.println("\nPromedio por materia de cada estudiante: ");
        promedioMaterias.forEach((subject, score) ->
                System.out.println(subject + " -> " + score));

        //Punto 5
        Student bestStudent = service.getBestStudent();
        System.out.println("\nEl mejor estudiante es: " + bestStudent.name);

        //Punto 6
        Map<String, Long> materiasPerdidas = service.getFailedSubjectsByTeam();
        System.out.println("\nMaterias perdidas por equipo: ");
        materiasPerdidas.forEach((team, count) ->
                System.out.println(team + " -> " + count));


        //Punto 7
        List<Student> topStudent = service.getTop3();
        System.out.println("\nTop 3 de los estudiantes mas agrogro");
        topStudent.forEach(student -> System.out.println(student.name));

        //Punto 8
        Map<String, List<Student>> studentStatus = service.groupStudentStatus();
        System.out.println("\nEstudiantes agrupados por estado academico:");
        studentStatus.forEach((status, students) -> {
            System.out.println(status + ":");
            students.forEach(s ->
                    System.out.println(" - " + s.name)
            );
        });

        //Punto 9
        String losses = service.getFailedSubjects();
        System.out.println("\nLa materia mas reprobadas es: " + losses);

        //Punto 10
        Map<String, Double> promedioMateriasDorado = service.getGoldenTeam();
        System.out.println("\nPromedio de materias aprobadas del equipo DORADO: ");
        promedioMateriasDorado.forEach((subject, avg) ->
                System.out.println(subject + " -> " + avg)
        );

        //Punto 11
        String bestTeam = service.getBestTeam();
        System.out.println("\nEl equipo con mejor promedio general es: " + bestTeam);

        //Punto 12
        LinkedHashMap<String, Long> topFailures = service.getTop3WorstStudents();
        System.out.println("\nTop 3 materias con más reprobaciones:");
        topFailures.forEach((subject, count) ->
                System.out.println(subject + " -> " + count));

    }
}
