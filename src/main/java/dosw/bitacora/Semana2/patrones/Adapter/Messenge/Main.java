package dosw.bitacora.Semana2.patrones.Adapter.Messenge;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        MessagePrinter simple = new SimplePrinter();

        MessagePrinter detailed = new DetailedPrinterAdapter(new DetailedPrinter(), "Cristian", LocalDate.now());

        simple.print("Hola mundo");
        detailed.print("Hola mundo");
    }
}

