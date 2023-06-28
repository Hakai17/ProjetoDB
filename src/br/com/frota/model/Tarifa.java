package br.com.frota.model;

public class Tarifa extends GenericModel{
	private String taxa;
	private String lei;
	private String dataInicio;
	private String dataFim;
	private String aliquotaIcms;
	private int idClasse;
	
	public Tarifa(String taxa, String lei, String dataInicio, String dataFim, String aliquotaIcms, int idClasse) {
		super();
		this.taxa = taxa;
		this.lei = lei;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.aliquotaIcms = aliquotaIcms;
		this.idClasse = idClasse;
	}
	
	public Tarifa(int id, String taxa, String lei, String dataInicio, String dataFim, String aliquotaIcms, int idClasse) {
		super.setId(id);
		this.taxa = taxa;
		this.lei = lei;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.aliquotaIcms = aliquotaIcms;
		this.idClasse = idClasse;
	}
	
	public String getTaxa() {
		return taxa;
	}

	public void setTaxa(String taxa) {
		this.taxa = taxa;
	}

	public String getLei() {
		return lei;
	}

	public void setLei(String lei) {
		this.lei = lei;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getAliquotaIcms() {
		return aliquotaIcms;
	}

	public void setAliquotaIcms(String aliquotaIcms) {
		this.aliquotaIcms = aliquotaIcms;
	}

	public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	@Override
    public String toString() {
        return "Tarifa {" +
                "id='" + this.getId() + "\'" +
                "taxa='" + taxa + "\'" +
                "lei='" + lei + "\'" +
                "aliquota_icms='" + aliquotaIcms + "\'" +
                "data_inicio='" + dataInicio + "\'" +
                "data_fim='" + dataFim + "\'" +
                "classe_id='" + idClasse + "\'" +
                '}';
    }

}
