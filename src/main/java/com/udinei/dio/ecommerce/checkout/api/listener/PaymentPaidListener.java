package com.udinei.dio.ecommerce.checkout.api.listener;

import com.udinei.dio.ecommerce.checkout.api.entity.CheckoutEntity;
import com.udinei.dio.ecommerce.checkout.api.service.CheckoutService;
import com.udinei.dio.ecommerce.checkout.api.streaming.PaymentPaidSink;
import com.udinei.dio.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutService checkoutService;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent paymentCreatedEvent){
         checkoutService.updateStatus(paymentCreatedEvent.getCheckoutCode().toString(),
                 CheckoutEntity.Status.APPROVED);

    }
}
