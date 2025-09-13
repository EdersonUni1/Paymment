package com.unifor.paymment.interfaces;

public interface PaymentPrototype extends PaymentStrategy {
    /**
     * Retorna uma cópia independente desta estratégia de pagamento.
     */
    PaymentStrategy copy();
}
