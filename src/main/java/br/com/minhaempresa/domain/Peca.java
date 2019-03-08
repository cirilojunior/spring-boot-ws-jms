package br.com.minhaempresa.domain;

public class Peca {

    protected Integer id;
    protected String titulo;
    protected Integer ordem;
    protected String texto;

    public Peca(Integer id, String titulo, Integer ordem, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.ordem = ordem;
        this.texto = texto;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public String getTexto() {
        return texto;
    }
}
