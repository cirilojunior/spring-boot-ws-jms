package br.com.minhaempresa.application.processoeletronico;

import br.com.minhaempresa.application.integracao.Mensagem;

import java.util.StringJoiner;

public class RecuperarPecaProcessoEletronico implements Mensagem {

    private Integer idDocumento;

    public RecuperarPecaProcessoEletronico() {
    }

    public RecuperarPecaProcessoEletronico(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public RecuperarPecaProcessoEletronico(String idDocumento) {
        this.idDocumento = Integer.valueOf(idDocumento);
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RecuperarPecaProcessoEletronico.class.getSimpleName() + "[", "]")
                .add("idDocumento=" + idDocumento)
                .toString();
    }

    @Override
    public String valor() {
        return idDocumento.toString();
    }
}
