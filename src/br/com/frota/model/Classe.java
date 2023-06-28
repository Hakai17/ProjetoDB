package br.com.frota.model;

public class Classe extends GenericModel{
	private String descricao;
	private int idTipoFase;
	
	public Classe(String descricao, int idTipoFase) {
		super();
		this.descricao = descricao;
		this.idTipoFase = idTipoFase;
	}
	
	public Classe(int id, String descricao, int idTipoFase) {
		super.setId(id);
		this.descricao = descricao;
		this.idTipoFase = idTipoFase;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTipoFase() {
		return idTipoFase;
	}
	
	@Override
	public String toString() {
		return "Classe {" +
                "id='" + this.getId() + "\'" +
                "descrição='" + descricao + "\'" +
                "tipo_fase_id='" + idTipoFase + "\'" +
                '}';
	}
	
}
