package dosw.bitacora.Corte2.Patrones.ProcesamientoPagos;

public class BankTransferAdapter implements PaymentProcessor {

    private BankTransferAPI bankAPI;

    public BankTransferAdapter(BankTransferAPI bankAPI) {
        this.bankAPI = bankAPI;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("[BankTransferAdapter] Adaptando llamada a BankTransfer...");
        bankAPI.transferFunds(amount);
        return true;
    }
}