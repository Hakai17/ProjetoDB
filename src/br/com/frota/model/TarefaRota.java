package br.com.frota.model;

import java.util.Date;

public class TarefaRota extends GenericModel{
	private String observacao;
	private Date dataInicio;
	private Date dataFim;
	private int idRota;
	
	public TarefaRota(String observacao, Date dataInicio, Date dataFim, int idRota) {
		super();
		this.observacao = observacao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.idRota = idRota;
	}
	
	public TarefaRota(int id, String observacao, Date dataInicio, Date dataFim, int idRota) {
		super.setId(id);
		this.observacao = observacao;
		this.dataInicio = dataInicio;
		this.dataFim= dataFim;
		this.idRota = idRota;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getIdRota() {
		return idRota;
	}

	public void setIdRota(int idRota) {
		this.idRota = idRota;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	@Override
    public String toString() {
        return "Tarefa Rota {" +
                "id='" + this.getId() + "\'" +
                "observacao='" + observacao + "\'" +
                "data_inicio='" + dataInicio + "\'" +
                "data_fim='" + dataFim + "\'" +
                "rota_id='" + idRota + "\'" +
                '}';
    }

	
}
