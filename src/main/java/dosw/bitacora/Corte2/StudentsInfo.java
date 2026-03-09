package dosw.bitacora.Corte2;

import java.time.LocalDate;
import java.util.List;

public class StudentsInfo {

    public static List<Student> getStudents() {

        return List.of(
                new Student("1", "Juan Perez", "DORADO", List.of(
                        new Grade("BD", 4.5, LocalDate.of(2026,3,1), true),
                        new Grade("REDES", 3.8, LocalDate.of(2026,3,5), true)
                )),

                new Student("2", "Maria Gomez", "AZUL", List.of(
                        new Grade("BD", 3.2, LocalDate.of(2026,3,2), true),
                        new Grade("REDES", 2.9, LocalDate.of(2026,3,6), false)
                )),

                new Student("3", "Carlos Ramirez", "DORADO", List.of(
                        new Grade("BD", 4.0, LocalDate.of(2026,3,3), true),
                        new Grade("REDES", 4.2, LocalDate.of(2026,3,7), true)
                )),

                new Student("4", "Laura Torres", "VERDE", List.of(
                        new Grade("BD", 3.5, LocalDate.of(2026,3,4), true),
                        new Grade("REDES", 3.0, LocalDate.of(2026,3,8), true)
                )),

                new Student("5", "Andres Castillo", "DORADO", List.of(
                        new Grade("BD", 2.8, LocalDate.of(2026,3,2), false),
                        new Grade("REDES", 3.6, LocalDate.of(2026,3,9), true)
                ))
        );
    }
}