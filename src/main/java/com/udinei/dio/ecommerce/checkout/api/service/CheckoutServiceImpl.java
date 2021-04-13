package com.udinei.dio.ecommerce.checkout.api.service;

import com.udinei.dio.ecommerce.checkout.api.entity.CheckoutEntity;
import com.udinei.dio.ecommerce.checkout.api.event.CheckoutCreatedEvent;
import com.udinei.dio.ecommerce.checkout.api.repository.CheckoutRepository;
import com.udinei.dio.ecommerce.checkout.api.resource.checkout.CheckoutRequest;
import com.udinei.dio.ecommerce.checkout.api.streaming.CheckoutCreatedSource;
import com.udinei.dio.ecommerce.checkout.api.util.UUIDUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl  implements CheckoutService {

    private final  CheckoutRepository checkoutRepository;
    private final CheckoutCreatedSource checkoutCreatedSource;
    private final UUIDUtil uuidUtil;


    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {

        // criando um checkoutEntity com dados fake para salvar (os dados ainda nao esta vindo do front)
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(uuidUtil.createUUID().toString())
                .status(CheckoutEntity.Status.CREATED)
                .build();

        final CheckoutEntity entity = checkoutRepository.save(checkoutEntity);


        // produzindo a msg apartir do evento - o checkout foi criado (entitity)
        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(entity.getCode())
                .setStatus(entity.getStatus().name())
                .build();

        // obtem o topico virtual
        // publicando no brocker a msg de que o checkout foi criado
         checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());

        return Optional.of(entity);
    }

    @Override
    public Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status) {
        final CheckoutEntity checkoutEntity = checkoutRepository.findByCode(checkoutCode).orElse(CheckoutEntity.builder().build());
        checkoutEntity.setStatus(CheckoutEntity.Status.APPROVED);
        return Optional.of(checkoutRepository.save(checkoutEntity));
    }
}
