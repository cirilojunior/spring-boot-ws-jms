package br.com.minhaempresa.domain;

import java.time.LocalDateTime;

public class ProcessoEletronico {

    private String numero;
    private LocalDateTime data;
    private ListaPecas listaPecas;

    public ProcessoEletronico(String numero, LocalDateTime data, ListaPecas listaPecas) {
        this.numero = numero;
        this.data = data;
        this.listaPecas = listaPecas;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDateTime getData() {
        return data;
    }

    public ListaPecas getListaPecas() {
        return listaPecas;
    }
}
