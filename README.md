#ecommerce-checkout-api-udinei
Projeto prático de uma solução de e-commerce com
arquitetura de microsserviços (EDA) Arquitetura orientada a eventos,
criando duas aplicações fazendo a integração entre elas com Apache Kafka, e compatibilidade 
de comunicação entre os microsserviços com Schema Registry. 

![](https://i1.wp.com/codingharbour.com/wp-content/uploads/2020/03/schema_registry.jpg?resize=446%2C223&ssl=1)
imagem do bog Coding Harbour

# Statck
- Java 15
- Spring Boot 2.4.4
- Spring Cloud Streams 
- Gradle 6.8
- PostGres 11
- Docker v19.03.8
- Docker-compose 
- Zookeeper
- kafka 
- schema-registry
- Jpa
- Apache Avro

Nota: Para detalhes, como versão e dependências
da stack ver arquivo build.gradle do projeto.

# Estrutura do projeto
- build (gerado pelo apache avro)
- docker
  - kafka
  - docker-compose.yml
- src
   - main
     - java
        - config
        - entity
        - listener
        - repository
        - resource.checkout
        - service
        - streaming
        - util
   - test
     - java

# Referências
* [Live Coding Daniel Hatanaka](https://github.com/hatanakadaniel)
* [Event-driven Architecture (EDA) usando microserviços ](https://medium.com/@marcelomg21/event-driven-architecture-eda-em-uma-arquitetura-de-micro-servi%C3%A7os-1981614cdd45#)
* [Google Cloud](https://cloud.google.com/solutions/capturing-change-logs-with-debezium?hl=pt-br)
* [Blog Emmanuel Neri](https://emmanuelneri.com.br/2019/06/04/kafka-no-spring-boot/)
* [Blog Atitude Reflexiva](https://atitudereflexiva.wordpress.com/2020/03/05/apache-kafka-introducao/)
