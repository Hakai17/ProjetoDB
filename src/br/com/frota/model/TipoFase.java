package br.com.frota.model;

public class TipoFase extends GenericModel{
	private String descricao;
	
	
	public TipoFase(String descricao) {
		super();
		this.descricao = descricao;
	}
	
	public TipoFase(int id, String descricao) {
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
		 return "Tipo Fase {" +
	                "id='" + this.getId() + "\'" +
	                "descricao='" + descricao + "\'" +
	                '}';
	}

}
