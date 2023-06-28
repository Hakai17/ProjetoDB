package br.com.frota.model;

import java.util.Date;

public class Medicao extends GenericModel {
	private String mes;
	private String ano;
	private Date dataMedicao;
	private String consumo;
	private int idMedidor;
	private int idTimeRota;
	
	public Medicao(String mes, String ano, Date dataMedicao, String consumo,
			int idMedidor, int idTimeRota) {
		super();
		this.mes = mes;
		this.ano = ano;
		this.dataMedicao = dataMedicao;
		this.consumo = consumo;
		this.idMedidor = idMedidor;
		this.idTimeRota = idTimeRota;
	}
	
	public Medicao(int id,String mes, String ano, Date dataMedicao, String consumo,
			int idMedidor, int idTimeRota) {
		super.setId(id);
		this.mes = mes;
		this.ano = ano;
		this.dataMedicao = dataMedicao;
		this.consumo = consumo;
		this.idMedidor = idMedidor;
		this.idTimeRota = idTimeRota;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Date getDataMedicao() {
		return dataMedicao;
	}

	public void setDataMedicao(Date dataMedicao) {
		this.dataMedicao = dataMedicao;
	}

	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}

	public int getIdMedidor() {
		return idMedidor;
	}

	public void setIdMedidor(int idMedidor) {
		this.idMedidor = idMedidor;
	}

	public int getIdTimeRota() {
		return idTimeRota;
	}

	public void setIdTimeRota(int idTimeRota) {
		this.idTimeRota = idTimeRota;
	}

	@Override
	public String toString() {
		return "Medicao {" +
                "id='" + this.getId() + "\'" +
                "mes='" + mes + "\'" +
                "ano='" + ano + "\'" +
                "data_medicao='" + dataMedicao + "\'" +
                "consumo='" + consumo + "\'" +
                "medidor_id='" + idMedidor + "\'" +
                "time_rota_id='" + idTimeRota + "\'" +
                '}';
	}
	
	
	
}
