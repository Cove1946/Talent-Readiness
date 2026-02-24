package dosw.bitacora.Semana3.patrones.Decorator;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        // Barco base
        Barco barcoBase = new BarcoBase();

        Map<String, Function<Barco, Barco>> mejoras = Map.of(
                "BLINDAJE", BlindajeDecorador::new,
                "RADAR", RadarDecorador::new,
                "MISILES", MisilesDecorador::new,
                "ANTITORPEDOS", SistemaAntiTorpedos::new
        );

        List<String> configuracion = List.of(
                "BLINDAJE",
                "RADAR",
                "MISILES"
        );

        Barco barcoFinal = barcoBase;

        for (String mejora : configuracion) {
            barcoFinal = mejoras.get(mejora).apply(barcoFinal);
        }

        System.out.println(barcoFinal.getDescripcion());
        System.out.println("Ataque: " + barcoFinal.poderAtaque());
        System.out.println("Defensa: " + barcoFinal.defensa());
    }
}
