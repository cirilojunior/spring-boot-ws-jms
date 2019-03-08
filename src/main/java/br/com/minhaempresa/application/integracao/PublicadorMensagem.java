package br.com.minhaempresa.application.integracao;

import br.com.minhaempresa.application.config.MessageriaConfig;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class PublicadorMensagem {

    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(PublicadorMensagem.class);
    private JmsTemplate jmsTemplate;

    @Autowired
    public PublicadorMensagem(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public <T extends Mensagem> void publica(T mensagem) {
        Logger.info("Publicando mensagem da fila...");
        jmsTemplate.convertAndSend(MessageriaConfig.FILA_RECUPERAR_PECA, mensagem.valor());
        Logger.info("Mensagem '{}' publicada com sucesso.", mensagem);
    }

}
