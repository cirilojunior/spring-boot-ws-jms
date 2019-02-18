package br.com.minhaempresa.ws;

import br.com.minhaempresa.processoeletronico.schemas.ProcessoEletronicoRequest;
import br.com.minhaempresa.service.ProcessoEletronicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint
public class ProcessoEletronicoEndpoint {

    private static final String NAMESPACE_URI = "http://minhaempresa.com.br/processoeletronico/schemas";

    private ProcessoEletronicoService processoEletronicoService;

    @Autowired
    public ProcessoEletronicoEndpoint(ProcessoEletronicoService processoEletronicoService) {
        this.processoEletronicoService = processoEletronicoService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "processoEletronicoRequest")
    public void recebeProcessoEletronico(@RequestPayload ProcessoEletronicoRequest processoEletronicoRequest) throws RecebimentoProcessoEletronicoFault {
        try {
            System.out.printf("Recebeu a requisição SOAP...");
            System.out.println(processoEletronicoRequest);
            processoEletronicoService.receber();
        } catch (Exception e) {
            throw new RecebimentoProcessoEletronicoFault("Erro no recebimento...");
        }
    }

}
