package com.udinei.dio.ecommerce.checkout.api.streaming;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CheckoutCreatedSource {

    String OUTPUT = "checkout-created-output"; // Topico virtual

    @Output(OUTPUT)
    MessageChannel output();
}
