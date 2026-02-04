import java.util.List;

public class ejercicio2 {

    public static List<String> filtroPalabras(List<String> palabras){
        return palabras.stream().filter(p -> p.length() > 4).map(String::toUpperCase)
                .sorted().toList();
    }

    public static void main(String[] args) {

        List<String> palabras = List.of(
                "Oso",
                "Streams",
                "Programación",
                "Bootcamp",
                "Ajo"
        );

        List<String>nuevasPalabras = filtroPalabras(palabras);

        nuevasPalabras.forEach(System.out::println);

        long count = nuevasPalabras.stream().count();
        System.out.println(count);






    }

}
