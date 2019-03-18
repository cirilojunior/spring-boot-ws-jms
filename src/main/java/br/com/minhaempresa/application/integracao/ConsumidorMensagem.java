package br.com.minhaempresa.application.integracao;

import br.com.minhaempresa.application.config.MessageriaConfig;
import br.com.minhaempresa.application.processoeletronico.RecuperarPecaProcessoEletronico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.JmsHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorMensagem {

    private static final Logger Logger = LoggerFactory.getLogger(ConsumidorMensagem.class);

    @JmsListener(destination = MessageriaConfig.FILA_RECUPERAR_PECA)
    public void consumir(@Payload RecuperarPecaProcessoEletronico mensagem,
                         @Header(JmsHeaders.MESSAGE_ID) String messageId) {
        Logger.info("Consumindo mensagem da fila...");
        Logger.info("Mensagem ID {}: {}.", messageId, mensagem);
    }

}
