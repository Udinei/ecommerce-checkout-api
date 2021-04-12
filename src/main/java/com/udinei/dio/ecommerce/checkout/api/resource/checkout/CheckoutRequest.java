package com.udinei.dio.ecommerce.checkout.api.resource.checkout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Essa classe representa o contrado de saida da API*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutRequest implements Serializable {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String complement;
    private String country;
    private String state;
    private String cep;
    private String saveAddress;
    private String saveInfo;
    private String paymentMethod;
    private String cardName;
    private String cardNumber;
    private String cardDate;
    private String cardCvv;

}
