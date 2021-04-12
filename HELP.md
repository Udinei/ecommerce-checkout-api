# Diário de DEV

### <b>Erro:</b>
O gradle não encontrou as bibliotecas do confluent em seu repositori 
e nem no repositorio do Maven.

### <b>Solução:</b>
Para não importar manualmente, foi criado um projeto Maven para importar as dependências do
confluent para o repositorio local do Maven,
codigos adicionados no pom.xmo do projoto Maven

~~~xml
 <repositories>
     ...
     <repository>
        <id>confluent</id>
         <url>http://packages.confluent.io/maven/</url>
     </repository>
     ...
  </repositories>
~~~

~~~xml
<dependency>
<groupId>io.confluent</groupId>
<artifactId>kafka-avro-serializer</artifactId>
<version>5.5.0</version>
</dependency>
~~~

e adicionado no builde.gradle
``` json
repositories {
   mavenCentral()
   mavenLocal()
}
```

### 2 - Solução : Adicionar no arquivo build.gradle o código abaixo
e comentar o mavenLocal()
``` json
repositories {
   mavenCentral()
   maven {
    url 'http://packages.confluent.io/maven/'
   }
}
```

### <b>Erro:</b>
Os arquivos do avro, são gerados na pasta build (pasta que também é criado pelo gerador do avro) do projeto, mas o  intelliJ não encontrava esses arquivos 
na estrutura de pastas do projeto, ocorrendo erros de imports, a solução foi 
informar esse caminho manualmente, usando o código abaixo:

### <b>Solução:</b>

``` json
sourceSets {
    main {
        java {
            srcDir "${buildDir.absolutePath}/generated-main-avro-java/com/udinei/dio/ecommerce/checkout/api/event"
            }
        }
}
```

### Erro ao subir a aplicação
Caused by: org.apache.kafka.common.errors.TimeoutException: Timed out waiting to send the call.

### Solução

No application.yml alterar para true

   <pre> autoCreateTopics: true </pre>pre>

# Comandos Docker
A aplicação utiliza docker-compose, para subir e configurar toda infra:
Usa 2 container com imagens de banco de dados(checkout e payment), Brocker (kafka), 
gerenciadores de mensagens (zookeeper) e schema-registry.


## Vizualizando a lista de comando do docker-compose

Digitar no prompt: docker-compose

Digitar na pasta de infra do projeto pasta - "docker"

Subir a infra da aplicação utilizando docker-compose sem liberar o terminal 
<pre>docker-compose up --build </pre>

Liberando o terminal
<pre>docker-compose up --build -d </pre>

Parar e remover toda a infra da aplicação
<pre>docker-compose down </pre>

Visualizando todos os container rodando no docker
<pre>docker ps </pre>


# Passos para rodar a aplicação 
1 - Executar o Postgres Local

2 - Executar os container docker usando docker-compose contido na pasta docker do projeto

3 - Executar a aplicação


