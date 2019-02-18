package br.com.minhaempresa.messageria;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorMensagem {

    @JmsListener(destination = "fila_busca_pecas_pcerj", containerFactory = "mgpeIpMessageFactory")
    public void consumir(RecuperarPecaMessage mensagem) {
        System.out.println("Lendo mensagem da fila...");
        System.out.println(mensagem);
    }
}
