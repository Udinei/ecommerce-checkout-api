package com.udinei.dio.ecommerce.checkout.api.streaming;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

// interface de comunicação, que recebera o status do pagamento, para
// atualizar o status do checkout
public interface PaymentPaidSink {

    String INPUT = "payment-paid-input"; // topico virtual

    @Input(INPUT)
    SubscribableChannel input();
}
