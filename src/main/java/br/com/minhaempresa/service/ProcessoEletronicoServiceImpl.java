package br.com.minhaempresa.service;

import br.com.minhaempresa.messageria.RecuperarPecaMessage;
import br.com.minhaempresa.processoeletronico.schemas.ProcessoEletronicoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProcessoEletronicoServiceImpl implements ProcessoEletronicoService {

    private JmsTemplate jmsTemplate;

    @Autowired
    public ProcessoEletronicoServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public String receber(ProcessoEletronicoType processoEletronico) {
        System.out.println("Processo eletronico recebido...");
        System.out.println(String.format("Recebendo Processo de Numero: %s", processoEletronico.getNumero()));
        String protocolo = UUID.randomUUID().toString();

        processoEletronico.getDocumentos().getDocumento().forEach(
                documento ->
                {
                    RecuperarPecaMessage mensagem = new RecuperarPecaMessage(documento.getId());
                    jmsTemplate.convertAndSend("fila_busca_pecas_pcerj", mensagem);
                }
        );

        return protocolo;
    }
}
