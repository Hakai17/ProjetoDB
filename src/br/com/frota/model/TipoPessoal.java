package br.com.frota.model;

public class TipoPessoal extends GenericModel{
	private String descricao;
	
	public TipoPessoal(String descricao) {
		super();
		this.descricao = descricao;
	}
	
	public TipoPessoal(int id, String descricao) {
		super.setId(id);
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		 return "Tipo Pessoal {" +
	                "id='" + this.getId() + "\'" +
	                "descricao='" + descricao + "\'" +
	                '}';
	}

}
