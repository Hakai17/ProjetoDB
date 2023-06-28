package br.com.frota.model;

public class Rota extends GenericModel {
	private String descricao;
	
	
	public Rota(String descricao) {
		super();
		this.descricao = descricao;
		
	}
	
	public Rota(int id, String descricao) {
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
        return "Rota {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                '}';
    }
}
