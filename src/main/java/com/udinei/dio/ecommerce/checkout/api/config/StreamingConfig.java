package com.udinei.dio.ecommerce.checkout.api.config;

import com.udinei.dio.ecommerce.checkout.api.streaming.CheckoutCreatedSource;
import com.udinei.dio.ecommerce.checkout.api.streaming.PaymentPaidSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

/**
 * Essa classe define quais interfaces serão conectadas(binder) ao
 * serviço de streaming
 *
 * */
@Configuration
@EnableBinding(value = {
        CheckoutCreatedSource.class, // interface de comunicação de stream com kafka
        PaymentPaidSink.class
})
public class StreamingConfig {
}
