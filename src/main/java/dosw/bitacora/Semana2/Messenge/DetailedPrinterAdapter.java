package dosw.bitacora.Semana2.Messenge;

import java.time.LocalDate;

public class DetailedPrinterAdapter implements MessagePrinter {

    private DetailedPrinter printer;
    private String author;
    private LocalDate date;

    public DetailedPrinterAdapter(
            DetailedPrinter printer,
            String author,
            LocalDate date) {

        this.printer = printer;
        this.author = author;
        this.date = date;
    }

    @Override
    public void print(String message) {
        printer.printDetailed(message, author, date);
    }

}
