package com.udinei.dio.ecommerce.checkout.api.service;

import com.udinei.dio.ecommerce.checkout.api.entity.CheckoutEntity;
import com.udinei.dio.ecommerce.checkout.api.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

 Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);
}
