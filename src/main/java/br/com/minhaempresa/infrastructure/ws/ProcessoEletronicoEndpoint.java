package br.com.minhaempresa.infrastructure.ws;

import br.com.minhaempresa.infrastructure.ws.schemas.ObjectFactory;
import br.com.minhaempresa.infrastructure.ws.schemas.ProcessoEletronicoRequest;
import br.com.minhaempresa.infrastructure.ws.schemas.ProcessoEletronicoResponse;
import br.com.minhaempresa.application.processoeletronico.ProcessoEletronicoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class ProcessoEletronicoEndpoint {

    private static final Logger Logger = LoggerFactory.getLogger(ProcessoEletronicoEndpoint.class);
    private static final String NAMESPACE_URI = "http://minhaempresa.com.br/infrastructure/ws/schemas";

    private ProcessoEletronicoService processoEletronicoService;
    private ObjectFactory objectFactory;

    @Autowired
    public ProcessoEletronicoEndpoint(ProcessoEletronicoService processoEletronicoService, ObjectFactory objectFactory) {
        this.processoEletronicoService = processoEletronicoService;
        this.objectFactory = objectFactory;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ProcessoEletronicoRequest")
    @ResponsePayload
    public ProcessoEletronicoResponse recebe(@RequestPayload ProcessoEletronicoRequest processoEletronicoRequest) throws RecebimentoProcessoEletronicoFault {
        try {
            Logger.info("Recebeu a requisição SOAP...");
            String protocolo = processoEletronicoService.receber(processoEletronicoRequest.getProcessoEletronico());
            Logger.info("Protocolo gerado: {}", protocolo);

            ProcessoEletronicoResponse resposta = objectFactory.createProcessoEletronicoResponse();
            resposta.setProtocolo(protocolo);
            return resposta;
        } catch (Exception e) {
            Logger.error("Erro no recebimento.", e);
            throw new RecebimentoProcessoEletronicoFault("Erro no recebimento de processo eletronico...", e);
        }
    }

}
