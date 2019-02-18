# spring-ws-and-boot
Exemplo de uso de Spring WS com Spring Boot.

Baseado na documentação do produto e evoluindo para uma POC temática de um projeto real e outros sites:

OBS.: Deve rodar com JDK 7 ou 8 (Spring Web Services requires a standard Java 7 Runtime Environment. Java 8 is also supported). Algumas classes de manipulação/parse de XML (javax.activation) foram removidas do "core" da linguagem. Achei este problema rodando com Java 10.x.

1. Rodar mvn clean compile para gerar as classes a partir do XSD.
1. Rodar classe HolidaySpringWsApplication
1. Acessar http://localhost:8080/processoEletronicoService/contrato.wsdl


Referências avaliadas:

1. https://docs.spring.io/spring-ws/docs/3.0.6.RELEASE/reference/#overview
1. https://howtodoinjava.com/spring-boot/spring-boot-soap-webservice-example/
1. https://spring.io/guides/gs/producing-web-service/
