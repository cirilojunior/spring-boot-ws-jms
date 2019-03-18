package br.com.minhaempresa.messageria;

import br.com.minhaempresa.application.config.Application;
import br.com.minhaempresa.application.integracao.PublicadorMensagem;
import br.com.minhaempresa.application.processoeletronico.RecuperarPecaProcessoEletronico;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@DirtiesContext
public class MessageriaIntegrationTest {

    @Autowired
    private PublicadorMensagem publicadorMensagem;

    @Test
    public void testaPublicacao() {
        RecuperarPecaProcessoEletronico mensagemEnviada = new RecuperarPecaProcessoEletronico(System.currentTimeMillis(), 1);
        publicadorMensagem.publica(mensagemEnviada);
    }
}
