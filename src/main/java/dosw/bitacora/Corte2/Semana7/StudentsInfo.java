package dosw.bitacora.Corte2.Semana7;

import java.time.LocalDate;
import java.util.List;

public class StudentsInfo {

    public static List<Student> getStudents() {
        return List.of(

                new Student("1", "Juan Perez", "DORADO", List.of(
                        new Grade("BD", 4.8, LocalDate.of(2026, 3, 1), true),
                        new Grade("REDES", 4.5, LocalDate.of(2026, 3, 2), true),
                        new Grade("DORADO", 4.6, LocalDate.of(2026, 3, 3), true)
                )),

                new Student("2", "Maria Gomez", "AZUL", List.of(
                        new Grade("BD", 3.2, LocalDate.of(2026, 3, 1), true),
                        new Grade("REDES", 2.8, LocalDate.of(2026, 3, 2), false),
                        new Grade("DORADO", 3.7, LocalDate.of(2026, 3, 3), true)
                )),

                new Student("3", "Carlos Ramirez", "DORADO", List.of(
                        new Grade("BD", 4.9, LocalDate.of(2026, 3, 1), true),
                        new Grade("REDES", 4.7, LocalDate.of(2026, 3, 2), true),
                        new Grade("DORADO", 4.8, LocalDate.of(2026, 3, 3), true)
                )),

                new Student("4", "Laura Torres", "VERDE", List.of(
                        new Grade("BD", 3.6, LocalDate.of(2026, 3, 1), true),
                        new Grade("REDES", 3.2, LocalDate.of(2026, 3, 2), true),
                        new Grade("DORADO", 3.0, LocalDate.of(2026, 3, 3), true)
                )),

                new Student("5", "Andres Castillo", "DORADO", List.of(
                        new Grade("BD", 2.9, LocalDate.of(2026, 3, 1), false),
                        new Grade("REDES", 3.8, LocalDate.of(2026, 3, 2), true),
                        new Grade("DORADO", 3.5, LocalDate.of(2026, 3, 3), true)
                )),

                new Student("6", "Sofia Martinez", "AZUL", List.of(
                        new Grade("BD", 4.6, LocalDate.of(2026, 3, 1), true),
                        new Grade("REDES", 4.3, LocalDate.of(2026, 3, 2), true),
                        new Grade("DORADO", 4.7, LocalDate.of(2026, 3, 3), true)
                )),

                new Student("7", "Diego Fernandez", "VERDE", List.of(
                        new Grade("BD", 2.5, LocalDate.of(2026, 3, 1), false),
                        new Grade("REDES", 3.0, LocalDate.of(2026, 3, 2), true),
                        new Grade("DORADO", 2.9, LocalDate.of(2026, 3, 3), false)
                )),

                new Student("8", "Camila Rojas", "DORADO", List.of(
                        new Grade("BD", 4.2, LocalDate.of(2026, 3, 1), true),
                        new Grade("REDES", 4.0, LocalDate.of(2026, 3, 2), true),
                        new Grade("DORADO", 4.4, LocalDate.of(2026, 3, 3), true)
                )),

                new Student("9", "Felipe Navarro", "AZUL", List.of(
                        new Grade("BD", 3.4, LocalDate.of(2026, 3, 1), true),
                        new Grade("REDES", 3.1, LocalDate.of(2026, 3, 2), true),
                        new Grade("DORADO", 2.7, LocalDate.of(2026, 3, 3), false)
                )),

                new Student("10", "Valentina Cruz", "VERDE", List.of(
                        new Grade("BD", 4.7, LocalDate.of(2026, 3, 1), true),
                        new Grade("REDES", 4.8, LocalDate.of(2026, 3, 2), true),
                        new Grade("DORADO", 4.6, LocalDate.of(2026, 3, 3), true)
                ))
        );
    }
}