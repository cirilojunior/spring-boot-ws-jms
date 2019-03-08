package br.com.minhaempresa;

import br.com.minhaempresa.messageria.RecuperarDocumentoMessageConverter;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class MessageriaConfig {

    public static final String FILA_RECUPERAR_PECA = "fila_documentos";
    private static final Logger Logger = LoggerFactory.getLogger(MessageriaConfig.class);

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(brokerUrl);
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    @Bean
    public MessageConverter documentoMessageConverter() {
        Logger.info("Criando JMS Message Converter...");
        RecuperarDocumentoMessageConverter converter = new RecuperarDocumentoMessageConverter();
        return converter;
    }

}
