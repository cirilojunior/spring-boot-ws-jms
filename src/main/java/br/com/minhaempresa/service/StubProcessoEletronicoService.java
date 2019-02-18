package br.com.minhaempresa.service;

import org.springframework.stereotype.Service;

@Service
public class StubProcessoEletronicoService implements ProcessoEletronicoService {

    @Override
    public void receber() {
        System.out.println("Processo eletronico recebido...");
    }
}
