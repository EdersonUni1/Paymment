public class BoletoAdapter implements PaymentStrategy {
    private ExternalBoletoAPI boletoAPI;
    private String code;

    public BoletoAdapter(ExternalBoletoAPI boletoAPI, String code) {
        this.boletoAPI = boletoAPI;
        this.code = code;
    }

    @Override
    public void pay(double amount) {
        boletoAPI.generateBoleto(amount, code);
    }

    @Override
    public String getPaymentDetails() {
        return "Boleto - Código: " + code;
    }
}
