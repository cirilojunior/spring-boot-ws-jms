package br.com.minhaempresa.messageria;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class MessageriaIntegrationTest {


    @Autowired
    private PublicadorMensagem publicadorMensagem;

    @Test
    public void testa() {
        MensagemRecuperarDocumento mensagem = new MensagemRecuperarDocumento(1);
        publicadorMensagem.publica(mensagem);
    }

}
