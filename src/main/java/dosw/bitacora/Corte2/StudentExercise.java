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

    // 4. Retornar por estudiante el primedio por materia -> Retornar un Map<String, Double> donde la clave es la materia y el valor el promedio
    public Map<String, Double> getAverageScoreBySubject() {
        return StudentsInfo.getStudents().stream()
                .flatMap(s -> s.grades.stream())
                .collect(Collectors.groupingBy(
                        Grade::getSubject,
                        Collectors.averagingDouble(Grade::getScore)
                ));
    }

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

}