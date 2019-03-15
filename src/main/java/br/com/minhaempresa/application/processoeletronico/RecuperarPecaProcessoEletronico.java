package br.com.minhaempresa.application.processoeletronico;

import br.com.minhaempresa.application.integracao.Mensagem;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class RecuperarPecaProcessoEletronico implements Mensagem, Serializable {

    private Long id;
    private Integer idDocumento;

    public RecuperarPecaProcessoEletronico() {
    }

    public RecuperarPecaProcessoEletronico(Long id, Integer idDocumento) {
        this.id = id;
        this.idDocumento = idDocumento;
    }

    public RecuperarPecaProcessoEletronico(Long id, String idDocumento) {
        this(id, Integer.valueOf(idDocumento));
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long id() {
        return id;
    }

    @Override
    public String valor() {
        return idDocumento.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecuperarPecaProcessoEletronico that = (RecuperarPecaProcessoEletronico) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RecuperarPecaProcessoEletronico.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("idDocumento=" + idDocumento)
                .toString();
    }

}
