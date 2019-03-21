package br.com.minhaempresa.application.integracao;

import br.com.minhaempresa.application.config.MessageriaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProdutorMensagem {

    private static final Logger Logger = LoggerFactory.getLogger(ProdutorMensagem.class);
    private JmsTemplate jmsTemplate;

    @Autowired
    public ProdutorMensagem(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public <T extends Mensagem> void publica(T mensagem) {
        Logger.info("Publicando mensagem da fila...");
        jmsTemplate.convertAndSend(MessageriaConfig.FILA_RECUPERAR_PECA, mensagem);
        Logger.info("Mensagem '{}' publicada com sucesso.", mensagem);
    }

}
