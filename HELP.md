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
informar esse caminho no arquivo <b>build.gradle</b> manualmente, usando o código abaixo:

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


# Schema Registry API no browser 
<b>Nota:</b>

Pode acontecer do registry schema não subir no docker, durante a execução do docker-compose,
exibindo o erro : 

Connection refused: no further information

indicando que registry esta fora do ar. Subir o registry schema no dasbord do docker (windows),
ou reiniciar o docker-compose: docker-compose down, e depois pra reiniciar 
docker-compose up -builder -d
###Após a execução do Produtor: checkout

<b>Porta:</b> 8081

<b>Browser:</b> Chrome

<b>Endereços API request:</b>

<pre>localhost:8081/subjects</pre>

Saida, tópico registrado:

<pre>["streaming.ecommerce.checkout.created-value"]</pre>

###Visualizando o registry schema:

http://localhost:8081/subjects/streaming.ecommerce.checkout.created-value/versions/latest

# Help GIT
### Criar uma branch a partir do master e mudar pra nova branch

<pre>git checkout -b main</pre>

#### removendo branch local:

<pre>git branch -D nomedobranch;</pre>

#### Apagando branch remota

<pre>git push nomedoorigin dobranch --delete </pre>

# Help Postgres
### Acessar o banco postgres com o usuario postgres

<pre>psql -U postgres checkout</pre>

### Listar tabelas do banco

<pre>postgres# \dt</pre>

### Remover tabela do BD

<pre>postgres#</pre>pre>

### Conectar no mesmo BD com outro usuario

<pre>postgres=# \c outrouser</pre>

### Removendo tabela do BD

<pre>DROP TABLE table_name;</pre>

# Help Docker
### Acessando banco de dados payment, no docker

<pre>psql -h localhost -p 5433 -U admin payment</pre>

Acessando o banco de dados no docker via um teminal dedicado
Uso: Quando o banco local já esta usando a porta do banco padrão
db-checkout = nomeDaImagem

<pre>docker exec -it db-checkout psql -U admin checkout</pre>

#### Listando dados da tabela

<pre>select * from public.payment_entity;</pre>

