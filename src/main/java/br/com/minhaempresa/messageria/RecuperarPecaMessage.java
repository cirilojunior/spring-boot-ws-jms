package br.com.minhaempresa.messageria;

import java.util.StringJoiner;

public class RecuperarPecaMessage {

    private Integer idPeca;

    public RecuperarPecaMessage() {
    }

    public RecuperarPecaMessage(Integer idPeca) {
        this.idPeca = idPeca;
    }

    public Integer getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Integer idPeca) {
        this.idPeca = idPeca;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RecuperarPecaMessage.class.getSimpleName() + "[", "]")
                .add("idPeca=" + idPeca)
                .toString();
    }
}
