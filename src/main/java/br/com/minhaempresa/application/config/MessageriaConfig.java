package br.com.minhaempresa.application.config;

import br.com.minhaempresa.application.integracao.MessageriaErrorHandler;
import br.com.minhaempresa.infrastructure.messageria.RecuperarDocumentoMessageConverter;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class MessageriaConfig {

    public static final String FILA_RECUPERAR_PECA = "fila_pecas";
    private static final Logger Logger = LoggerFactory.getLogger(MessageriaConfig.class);

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Autowired
    private MessageriaErrorHandler messageriaErrorHandler;

    @Bean
    public ConnectionFactory connectionFactory() {
        Logger.info("Criando JMS Connection Factory...");

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
        connectionFactory.setTrustAllPackages(true); // Isso permite uso de ObjectMessages (A Serialização tem questões de segurança por pacotes).

        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(connectionFactory);
        cachingConnectionFactory.setCacheConsumers(true);
        cachingConnectionFactory.setSessionCacheSize(10);

        return cachingConnectionFactory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        Logger.info("Criando JMS Listener Container Factory...");
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setErrorHandler(messageriaErrorHandler);
        return factory;
    }

    @Bean
    public MessageConverter documentoMessageConverter() {
        Logger.info("Criando JMS Message Converter...");
        RecuperarDocumentoMessageConverter converter = new RecuperarDocumentoMessageConverter();
        return converter;
    }

}
