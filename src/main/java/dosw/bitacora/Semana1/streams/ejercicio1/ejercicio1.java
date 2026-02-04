package dosw.bitacora.Semana1.streams.ejercicio1;

import java.util.List;

public class ejercicio1 {
    public static List<Integer> paresMayores (List<Integer> lista) {
        return lista.stream().filter(a -> a % 2 == 0)
                .filter(a -> a > 10).toList();

    }

    public static void main(String[] args) {

        List<Integer> numeros = List.of(2,5,8,10,12,14,15);

        List<Integer> resultado = paresMayores(numeros);

        resultado.forEach(System.out::println);




    }

}