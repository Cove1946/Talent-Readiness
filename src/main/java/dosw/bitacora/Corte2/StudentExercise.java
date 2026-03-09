package dosw.bitacora.Corte2;

import java.util.List;

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


}