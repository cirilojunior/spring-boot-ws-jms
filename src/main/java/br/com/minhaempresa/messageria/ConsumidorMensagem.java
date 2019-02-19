package br.com.minhaempresa.messageria;

import br.com.minhaempresa.MessageriaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorMensagem {

    private static final Logger Logger = LoggerFactory.getLogger(ConsumidorMensagem.class);

    @JmsListener(destination = MessageriaConfig.FILA_RECUPERAR_PECA, containerFactory = "processoEletronicoMessageFactory")
    public void consumir(MensagemRecuperarDocumento mensagem) {
        Logger.info("Consumindo mensagem da fila...");
        Logger.info("Mensagem: {}.", mensagem);
    }
}
