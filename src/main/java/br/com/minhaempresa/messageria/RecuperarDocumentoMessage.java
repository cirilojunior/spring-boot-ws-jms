package br.com.minhaempresa.messageria;

import java.util.StringJoiner;

public class RecuperarDocumentoMessage {

    private Integer idDocumento;

    public RecuperarDocumentoMessage() {
    }

    public RecuperarDocumentoMessage(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RecuperarDocumentoMessage.class.getSimpleName() + "[", "]")
                .add("idDocumento=" + idDocumento)
                .toString();
    }
}
