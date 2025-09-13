public class CreditCardAdapter implements PaymentStrategy {
    private ExternalCreditCardAPI ccAPI;
    private String number;
    private String exp;
    private String cvv;

    public CreditCardAdapter(ExternalCreditCardAPI ccAPI, String number, String exp, String cvv) {
        this.ccAPI = ccAPI;
        this.number = number;
        this.exp = exp;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        ccAPI.process(amount, number, exp, cvv);
    }

    @Override
    public String getPaymentDetails() {
        return "Cartão - Final " + number.substring(number.length() - 4);
    }
}
