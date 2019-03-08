package br.com.minhaempresa.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListaPecas {

    private List<Peca> pecas;

    public ListaPecas() {
        this.pecas = new ArrayList<>();
    }

    public ListaPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public ListaPecas adiciona(Peca peca) {
        pecas.add(peca);
        return this;
    }

    public ListaPecas remove(Peca peca) {
        pecas.remove(peca);
        return this;
    }

    public Peca recupera(Integer id) {
        Set<Peca> result = pecas.stream().filter(p -> p.id.equals(id)).collect(Collectors.toSet());
        if (result.isEmpty()) {
            return null;
        }
        return result.iterator().next();
    }

    public List<Peca> toList() {
        return Collections.unmodifiableList(this.pecas);
    }
}
