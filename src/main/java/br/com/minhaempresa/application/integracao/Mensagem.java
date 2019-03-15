package br.com.minhaempresa.application.integracao;

import java.io.Serializable;

public interface Mensagem extends Serializable {

    Long id();

    String valor();

}
