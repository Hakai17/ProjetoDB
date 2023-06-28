package br.com.frota.model;

public class Medidor extends GenericModel{
	private String descricao;
	private int idRota;
	private int idPoste;
	
	public Medidor(String descricao, int idRota, int idPoste) {
		super();
		this.descricao = descricao;
		this.idRota = idRota;
		this.idPoste = idPoste;
	}
	
	public Medidor(int id, String descricao, int idRota, int idPoste) {
		super.setId(id);
		this.descricao = descricao;
		this.idRota = idRota;
		this.idPoste = idPoste;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdRota() {
		return idRota;
	}

	public void setIdRota(int idRota) {
		this.idRota = idRota;
	}

	public int getIdPoste() {
		return idPoste;
	}

	public void setIdPoste(int idPoste) {
		this.idPoste = idPoste;
	}

	@Override
	public String toString() {
		return "Medidor {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                "rota_id='" + idRota + "\'" +
                "poste_id='" + idPoste + "\'" +
                '}';
	}
}
