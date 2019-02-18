package br.com.minhaempresa.ws;

import br.com.minhaempresa.processoeletronico.schemas.ObjectFactory;
import br.com.minhaempresa.processoeletronico.schemas.ProcessoEletronicoRequest;
import br.com.minhaempresa.processoeletronico.schemas.ProcessoEletronicoResponse;
import br.com.minhaempresa.service.ProcessoEletronicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.UUID;

@Endpoint
public class ProcessoEletronicoEndpoint {

    private static final String NAMESPACE_URI = "http://minhaempresa.com.br/processoeletronico/schemas";

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
            System.out.printf("Recebeu a requisição SOAP...");
            System.out.println(processoEletronicoRequest);
            processoEletronicoService.receber();

            ProcessoEletronicoResponse resposta = objectFactory.createProcessoEletronicoResponse();
            resposta.setProtocolo(UUID.randomUUID().toString());
            return resposta;
        } catch (Exception e) {
            throw new RecebimentoProcessoEletronicoFault("Erro no recebimento...");
        }
    }

}
