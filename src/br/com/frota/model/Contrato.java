package br.com.frota.model;

import java.util.Date;

public class Contrato extends GenericModel {
    private String descricao;
    private Date dataInicio;
    private Date dataCriacao;
    private int idMedidor;
    private int idClasse;
    
    public Contrato(String descricao, Date dataInicio, Date dataCriacao, int idMedidor, int idClasse, int idCliente) {
		super();
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataCriacao = dataCriacao;
		this.idMedidor = idMedidor;
		this.idClasse = idClasse;
		this.idCliente = idCliente;
	}
    
    public Contrato(int id, String descricao, Date dataInicio, Date dataCriacao, int idMedidor, int idClasse, int idCliente) {
		super.setId(id);
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataCriacao = dataCriacao;
		this.idMedidor = idMedidor;
		this.idClasse = idClasse;
		this.idCliente = idCliente;
	}

	private int idCliente;

    public Contrato(String descricao) {
        this.descricao = descricao;
    }

    public Contrato(Integer id, String descricao) {
        this.descricao = descricao;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public int getIdMedidor() {
		return idMedidor;
	}

	public void setIdMedidor(int idMedidor) {
		this.idMedidor = idMedidor;
	}

	public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	@Override
    public String toString() {
        return "Marca {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                "data_inicio='" + dataInicio + "\'" +
                "data_criacao='" + dataCriacao + "\'" +
                "medidor_id='" + idMedidor + "\'" +
                "classe_id='" + idClasse + "\'" +
                "cliente_id='" + idCliente + "\'" +
                '}';
    }
}
