 # spring-boot-ws-jms
Exemplo de uso de Spring Boot com Spring WS e Messageria.

Baseado na documentação do produto e evoluindo para uma POC temática de um projeto real e outros sites:

Objetivo: Fluxo onde um Parceiro envia um Processo Eletrônico com ids de Documento que preciso buscar em outro momento. Em um determinado momento eu envio um Movimento relacionado a um Processo Eletrônico recebido e o Parceiro busca Documentos que informei.

OBS.: Deve rodar com JDK 7 ou 8 (Spring Web Services requires a standard Java 7 Runtime Environment. Java 8 is also supported). Algumas classes de manipulação/parse de XML (javax.activation) foram removidas do "core" da linguagem. Achei este problema rodando com Java 10.x.

Executando:

1. Rodar mvn clean compile para gerar as classes a partir do XSD.
1. Rodar classe Application
1. Acessar http://localhost:8080/processoEletronicoService/contrato.wsdl para ver o WSDL
1. Com um client, enviar mensagem para o serviço (existe um projeto SoapUI pronto no fonte para isso).

Resultado Esperado:

1. Exibir em logs no console mensagens indicando o recebimento e tratamento do Processo Eletrônico onde para cada Documento enviado uma mensagem na fila é colocada para ir "buscá-lo" no serviço do Parceiro.

Roadmap:

1. Implementar testes.
1. Implementar Mock Client do Parceiro.
1. Implementar Endpoint do Parceiro já com testes.
1. Implementar Mock Client da Minha Empresa.

Referências avaliadas:

1. https://docs.spring.io/spring-ws/docs/3.0.6.RELEASE/reference/#overview
1. https://howtodoinjava.com/spring-boot/spring-boot-soap-webservice-example/
1. https://spring.io/guides/gs/producing-web-service/
1. https://memorynotfound.com/spring-jms-setting-reading-header-properties-example/


1. https://spring.io/guides/gs/messaging-jms/
1. https://www.baeldung.com/spring-jms
1. https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-messaging.html
1. https://examples.javacodegeeks.com/enterprise-java/jms/java-jms-helloworld-on-jboss-example/
1. https://codenotfound.com/spring-jms-tutorials
1. http://activemq.apache.org/how-to-unit-test-jms-code.html

1. https://bsnyderblog.blogspot.com/2010/02/using-spring-jmstemplate-to-send-jms.html
1. https://bsnyderblog.blogspot.com/2010/02/using-spring-to-receive-jms-messages.html
1. https://bsnyderblog.blogspot.com/2010/05/tuning-jms-message-consumption-in.html

1. https://singztechmusings.wordpress.com/2011/04/24/problem-with-creating-jms-messageproducer-using-spring-jmstemplate-how-to-solve/
1. https://singztechmusings.wordpress.com/2011/06/21/pooledconnectionfactory-vs-cachingconnectionfactory-which-one-is-a-perfect-match-for-spring-jmstemplate/
1. https://stackoverflow.com/questions/5916638/autoreconnect-problem-with-activemq-and-cachingconnectionfactory
1. https://stackoverflow.com/questions/19560479/which-is-better-pooledconnectionfactory-or-cachingconnectionfactory
1. https://svn.apache.org/repos/asf/activemq/trunk/activemq-unit-tests/src/test/java/org/apache/activemq/spring/ActiveMQConnectionFactoryFactoryBeanTest.java
