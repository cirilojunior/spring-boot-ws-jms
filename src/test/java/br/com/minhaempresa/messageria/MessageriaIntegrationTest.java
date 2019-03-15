package br.com.minhaempresa.messageria;

import br.com.minhaempresa.application.config.Application;
import br.com.minhaempresa.application.integracao.PublicadorMensagem;
import br.com.minhaempresa.application.processoeletronico.RecuperarPecaProcessoEletronico;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@DirtiesContext
public class MessageriaIntegrationTest {

    @Autowired
    private PublicadorMensagem publicadorMensagem;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void testaPublicacao() throws InterruptedException {
//        jmsTemplate.setReceiveTimeout(50000);
        RecuperarPecaProcessoEletronico mensagemEnviada = new RecuperarPecaProcessoEletronico(System.currentTimeMillis(), 1);
        publicadorMensagem.publica(mensagemEnviada);

//        aguardaConsumoMensagem();
    }

//    @Test
//    public void testaConsumo() {
//        jmsTemplate.sendAndReceive()
//        RecuperarPecaProcessoEletronico mensagemEnviada = new RecuperarPecaProcessoEletronico(System.currentTimeMillis(), 1);
//        publicadorMensagem.publica(mensagemEnviada);
//    }

    private void aguardaConsumoMensagem() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.exit(-1);
    }

}
