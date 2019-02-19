package br.com.minhaempresa.service;

import br.com.minhaempresa.messageria.PublicadorMensagem;
import br.com.minhaempresa.messageria.MensagemRecuperarDocumento;
import br.com.minhaempresa.processoeletronico.schemas.ProcessoEletronicoType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProcessoEletronicoServiceImpl implements ProcessoEletronicoService {

    private static final Logger Logger = LoggerFactory.getLogger(ProcessoEletronicoServiceImpl.class);
    private PublicadorMensagem publicadorMensagem;

    @Autowired
    public ProcessoEletronicoServiceImpl(PublicadorMensagem publicadorMensagem) {
        this.publicadorMensagem = publicadorMensagem;
    }

    @Override
    public String receber(ProcessoEletronicoType processoEletronico) {
        Logger.info("Recebendo Processo de Numero: {}.", processoEletronico.getNumero());
        String protocolo = UUID.randomUUID().toString();

        Logger.info("Adicionando IDs de documentos na fila para recuperá-los.");
        processoEletronico.getDocumentos().getDocumento().forEach(
                documento ->
                {
                    MensagemRecuperarDocumento mensagem = new MensagemRecuperarDocumento(documento.getId());
                    publicadorMensagem.publica(mensagem);
                    Logger.info("Documento de ID {} incluído na fila para recuperação.", documento.getId());
                }
        );

        return protocolo;
    }
}
