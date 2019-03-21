package br.com.minhaempresa.application.processoeletronico;

import br.com.minhaempresa.application.integracao.ProdutorMensagem;
import br.com.minhaempresa.domain.ProcessoEletronico;
import br.com.minhaempresa.infrastructure.messageria.WsdlTypesConverter;
import br.com.minhaempresa.infrastructure.ws.schemas.ProcessoEletronicoType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProcessoEletronicoService {

    private static final Logger Logger = LoggerFactory.getLogger(ProcessoEletronicoService.class);
    private ProdutorMensagem produtorMensagem;
    private WsdlTypesConverter converter;

    @Autowired
    public ProcessoEletronicoService(ProdutorMensagem produtorMensagem, WsdlTypesConverter converter) {
        this.produtorMensagem = produtorMensagem;
        this.converter = converter;
    }

    public String receber(ProcessoEletronicoType processoEletronicoType) {
        Logger.info("Recebendo Processo de Numero: {}.", processoEletronicoType.getNumero());
        final ProcessoEletronico processoEletronico = converter.from(processoEletronicoType);
        final String protocolo = geraProtocolo();

        Logger.info("Adicionando IDs de peças na fila para recuperá-las.");
        processoEletronico.getListaPecas().toList().forEach(
                peca ->
                {
                    RecuperarPecaProcessoEletronico mensagem = new RecuperarPecaProcessoEletronico(geraIdentificadorMensagem(), peca.getId());
                    produtorMensagem.publica(mensagem);
                    Logger.info("Peça de ID {} incluído na fila para recuperação.", peca.getId());
                }
        );

        return protocolo;
    }

    private long geraIdentificadorMensagem() {
        return System.currentTimeMillis();
    }

    private String geraProtocolo() {
        return UUID.randomUUID().toString();
    }

}
