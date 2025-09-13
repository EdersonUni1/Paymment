package com.unifor.paymment.adapters;

import com.unifor.paymment.exceptions.PaymentException;
import com.unifor.paymment.interfaces.PaymentStrategy;

public class PixAdapter implements PaymentStrategy {
    private ExternalPixAPI pixAPI;
    private String cpf;

    public PixAdapter(ExternalPixAPI pixAPI, String cpf) {
        this.pixAPI = pixAPI;
        this.cpf = cpf;
    }

    @Override
    public void pay(double amount) throws PaymentException {
        if (cpf == null || cpf.isEmpty()) {
            throw new PaymentException("CPF inválido para PIX");
        }
        pixAPI.transfer(amount, cpf); // chama a API externa
    }

    @Override
    public String getPaymentDetails() {
        return "Pagamento via PIX para CPF: " + cpf;
    }
}
