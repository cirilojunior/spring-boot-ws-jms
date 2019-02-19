package br.com.minhaempresa.messageria;

import java.util.StringJoiner;

public class MensagemRecuperarDocumento implements Mensagem {

    private Integer idDocumento;

    public MensagemRecuperarDocumento() {
    }

    public MensagemRecuperarDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public MensagemRecuperarDocumento(String idDocumento) {
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
        return new StringJoiner(", ", MensagemRecuperarDocumento.class.getSimpleName() + "[", "]")
                .add("idDocumento=" + idDocumento)
                .toString();
    }

    @Override
    public String valor() {
        return idDocumento.toString();
    }
}
