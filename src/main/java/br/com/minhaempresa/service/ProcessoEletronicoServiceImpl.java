package br.com.minhaempresa.service;

import br.com.minhaempresa.processoeletronico.schemas.ProcessoEletronicoType;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProcessoEletronicoServiceImpl implements ProcessoEletronicoService {

    @Override
    public String receber(ProcessoEletronicoType processoEletronico) {
        System.out.println("Processo eletronico recebido...");
        System.out.println(String.format("Recebendo Processo de Numero: %s", processoEletronico.getNumero()));
        return UUID.randomUUID().toString();
    }
}
