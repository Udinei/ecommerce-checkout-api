package com.udinei.dio.ecommerce.checkout.api.service;

import com.udinei.dio.ecommerce.checkout.api.entity.CheckoutEntity;
import com.udinei.dio.ecommerce.checkout.api.event.CheckoutCreatedEvent;
import com.udinei.dio.ecommerce.checkout.api.repository.CheckoutRepository;
import com.udinei.dio.ecommerce.checkout.api.resource.checkout.CheckoutRequest;
import com.udinei.dio.ecommerce.checkout.api.streaming.CheckoutCreatedSource;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl  implements CheckoutService {

    private final  CheckoutRepository checkoutRepository;
    private final CheckoutCreatedSource checkoutCreatedSource;


    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {

        // criando um checkoutEntity com dados fake para salvar (os dados ainda nao esta vindo do front)
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .status(CheckoutEntity.Status.CREATED)
                .build();

        final CheckoutEntity entity = checkoutRepository.save(checkoutEntity);

        // criando evento pra publicar no brocker
        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(entity.getCode())
                .setStatus(entity.getStatus().name())
                .build();

        // publicando o evento no brocker
        checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());

        return Optional.of(entity);
    }
}
