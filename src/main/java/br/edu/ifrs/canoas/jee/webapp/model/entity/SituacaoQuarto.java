package br.edu.ifrs.canoas.jee.webapp.model.entity;

public enum SituacaoQuarto {
	
	DISPONIVEL("Disponível"), INDISPONIVEL("Indisponível");
	
	private String descricao;
	
    SituacaoQuarto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
