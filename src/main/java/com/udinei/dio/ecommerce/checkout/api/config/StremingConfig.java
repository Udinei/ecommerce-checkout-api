package com.udinei.dio.ecommerce.checkout.api.config;

import com.udinei.dio.ecommerce.checkout.api.streaming.CheckoutCreatedSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value =
        CheckoutCreatedSource.class
        //PaymentPaidSink.class
)
class StreamingConfig {
}
