package dosw.bitacora.Semana1.streams.ejercicio4;

import java.util.List;

public class ejercicio4  {

    public static boolean validTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .peek(t -> System.out.println(t))
                .noneMatch(t -> !t.approved);
    }

    public static void main(String[] args) {
        List<Transaction> transactionsEvalue = List.of(
                new Transaction("TXL-2024", 3000, true),
                new Transaction("TKL-2943", 5000, true),
                new Transaction("TZL-9463", 9000, true),
                new Transaction("JKL-9999", 5000, false)
        );

        boolean approveLote = validTransactions(transactionsEvalue);
        System.out.println("¿Lote válido? " + approveLote);



    }

}
