package br.com.frota.model;

public class Cobranca extends GenericModel{
	private String mesReferencia;
	private String anoReferencia;
	private int idTarifa;
	
	public Cobranca(String mesReferencia, String anoReferencia, int idTarifa) {
		super();
		this.mesReferencia = mesReferencia;
		this.anoReferencia = anoReferencia;
		this.idTarifa = idTarifa;
	}
	
	public Cobranca(int id, String mesReferencia, String anoReferencia, int idTarifa) {
		super.setId(id);
		this.mesReferencia = mesReferencia;
		this.anoReferencia = anoReferencia;
		this.idTarifa = idTarifa;
	}

	public String getMesReferencia() {
		return mesReferencia;
	}

	public void setIdVeiculo(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public String getAnoReferencia() {
		return anoReferencia;
	}

	public void setAnoReferencia(String anoReferencia) {
		this.anoReferencia = anoReferencia;
	}

	public int getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}
	
	@Override
	public String toString() {
		return "Cobranca {" +
                "id='" + this.getId() + "\'" +
                "mes_referencia='" + mesReferencia + "\'" +
                "ano_referencia='" + anoReferencia + "\'" +
                "tarifa_id='" + idTarifa + "\'" +
                '}';
	}
}
