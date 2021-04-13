package com.udinei.dio.ecommerce.checkout.api.streaming;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Essa interface é utilizada para conectar no brocker kafka, e informar que um checkout foi criado
 * atraves de um tooico virtuaL "checkout-created-output", que faz referencia no brocker
 * a um topico real, definido no application.yml ex:
 * checkout-created-output:
 *           destination: streaming.ecommerce.checkout.created
 *
 * definição padrao do topico acima de ex:
 * streaming - tipo de informação
 * ecommerce - nome do dominio
 * checkout - entidade
 * created - acao
 *
 * Nomenclatura do kafka: produtor(Sources), Consumidor (Sink), Brocker kafka INPUT/OUTPUT,
 * Processor(consome e devolve uma msg ao brocker)
 * Binder: ferramentas de messageria ou stream (ex: kafka, rabbitMQ )
 * */
public interface CheckoutCreatedSource {

    String OUTPUT = "checkout-created-output"; // Topico virtual

    @Output(OUTPUT)
    MessageChannel output();
}
