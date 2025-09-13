package com.unifor.paymment.registry;

import com.unifor.paymment.interfaces.PaymentPrototype;
import com.unifor.paymment.interfaces.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class PaymentPrototypeRegistry {
    private final Map<String, PaymentStrategy> prototypes = new HashMap<>();

    // registra um protótipo (ex: "cartao-eduardo")
    public void register(String key, PaymentStrategy prototype) {
        prototypes.put(key, prototype);
    }

    // cria uma cópia do protótipo registrado — se não for clonável, retorna a própria instância
    public PaymentStrategy createClone(String key) {
        PaymentStrategy proto = prototypes.get(key);
        if (proto == null) return null;
        if (proto instanceof PaymentPrototype) {
            return ((PaymentPrototype) proto).copy();
        }
        return proto; // fallback
    }
}
