package dosw.bitacora.Corte2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentExercise {

    // 1. Obtener todos los estudiantes del equipo DORADO
    public List<Student> getStudentsFromDoradoTeam() {
        return StudentsInfo.getStudents().stream()
                .filter(s -> s.team.equals("DORADO"))
                .toList();
    }

    // 2️. Obtener todos los nombres de estudiantes ordenados alfabéticamente
    public List<String> getStudentNamesSorted() {
        return StudentsInfo.getStudents().stream()
                .map(s -> s.name)
                .sorted()
                .toList();
    }

    // 3. Calcular el promedio general de todos los score existentes en el sistema
    public double getAverageScore (){
        return StudentsInfo.getStudents().stream()
                .flatMap(s -> s.grades.stream())
                .mapToDouble(g -> g.getScore())
                .average()
                .orElse(0.0);
    }

    // 4. Retornar por estudiante el primedio por materia -> Retornar un Map<String, Double> donde la clave es la
    // materia y el valor el promedio
    public Map<String, Double> getAverageScoreBySubject() {
        return StudentsInfo.getStudents().stream()
                .flatMap(s -> s.grades.stream())
                .collect(Collectors.groupingBy(
                        Grade::getSubject,
                        Collectors.averagingDouble(Grade::getScore)
                ));
    }

    // 5. Retornar el estudiante cuyo promedio general sea el mas alto del curso
    public Student getBestStudent() {
        return StudentsInfo.getStudents().stream()
                .max(Comparator.comparingDouble(student ->
                        student.grades.stream()
                                .mapToDouble(Grade::getScore)
                                .average()
                                .orElse(0.0)
                ))
                .orElse(null);
    }

    //6. Retornar las materias reprobadas por equipo -> Retornar Map <String, Long> donde la clave es el nombre del
    // equipo y el valor la cantidad total de materias reprobadas
    public Map<String, Long> getFailedSubjectsByTeam() {

        return StudentsInfo.getStudents().stream()
                .flatMap(student ->
                        student.getGrades().stream()
                                .filter(grade -> !grade.isPassed())
                                .map(grade -> student.getTeam())
                )
                .collect(Collectors.groupingBy(
                        team -> team,
                        Collectors.counting()
                ));
    }

    // 7. Top 3 estudiantes con mas materias aprobadas -> Retornar lista ordenada de manera descendente
    public  List<Student> getTop3(){
        return StudentsInfo.getStudents()
                .stream()
                .sorted((s1, s2) -> Long.compare(
                        s2.grades.stream().filter( g -> g.passed).count(),
                        s1.grades.stream().filter(g -> g.passed).count()
                ))
                .limit(3)
                .toList();
    }

    // 8. Agrupar estudiantes por estado academico: Clasificarlos por ALTO RENDIMIENTO -> Promedio >=4,5 ,
    // REGULAR -> Promedio entre 3,5 y 4.49, RIESGO -> promedio < 3,5
    public Map<String, List<Student>> groupStudentStatus() {
        return StudentsInfo.getStudents()
                .stream()
                .collect(Collectors.groupingBy(student -> {

                    double avg = student.grades.stream()
                            .mapToDouble(g -> g.score)
                            .average()
                            .orElse(0);

                    if (avg >= 4.5) {
                        return "\nALTO RENDIMIENTO";
                    } else if (avg >= 3.5) {
                        return "\nREGULAR";
                    } else {
                        return "\nRIESGO";
                    }

                }));
    }

    //9. Obtener la materia con mas reprobaciones
    public String getFailedSubjects(){
        return StudentsInfo.getStudents()
                .stream()
                .flatMap(student -> student.getGrades().stream())
                .filter(g -> !g.passed)
                .collect(Collectors.groupingBy(g -> g.subject, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No hay reprobaciones");
    }




}