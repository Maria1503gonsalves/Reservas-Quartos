package com.reservas_quartos.service;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    public PaymentIntent criarPagamento(double valor) throws Exception {
        Stripe.apiKey = stripeApiKey;

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount((long) (valor * 100)) // valor em centavos
                .setCurrency("brl")
                .setDescription("Pagamento da reserva")
                .build();

        return PaymentIntent.create(params);
    }
}

