package br.com.frota.model;

public class ContaLuz {
	private String rota;
	private String medidor;
    private String poste;
    private String nome;
    private String cpf;
    private String cnpj;
    private String classe;
    private String tipoFase;
    private String numCliente;
    private String taxa;
    private String vencimento;
	private String consumo;
    private String mes;
    private String ano;
   
	public ContaLuz(String rota, String medidor, String poste, String nome, String cpf, String cnpj, String classe,
			String tipoFase, String numCliente, String taxa, String vencimento, String consumo, String mes,
			String ano) {
		super();
		this.rota = rota;
		this.medidor = medidor;
		this.poste = poste;
		this.nome = nome;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.classe = classe;
		this.tipoFase = tipoFase;
		this.numCliente = numCliente;
		this.taxa = taxa;
		this.vencimento = vencimento;
		this.consumo = consumo;
		this.mes = mes;
		this.ano = ano;
	}
	
	 
    
		public String getRota() {
			return rota;
		}


		public void setRota(String rota) {
			this.rota = rota;
		}


		public String getMedidor() {
			return medidor;
		}


		public void setMedidor(String medidor) {
			this.medidor = medidor;
		}


		public String getPoste() {
			return poste;
		}


		public void setPoste(String poste) {
			this.poste = poste;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getCpf() {
			return cpf;
		}


		public void setCpf(String cpf) {
			this.cpf = cpf;
		}


		public String getCnpj() {
			return cnpj;
		}


		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}


		public String getClasse() {
			return classe;
		}


		public void setClasse(String classe) {
			this.classe = classe;
		}


		public String getTipoFase() {
			return tipoFase;
		}


		public void setTipoFase(String tipoFase) {
			this.tipoFase = tipoFase;
		}


		public String getNumCliente() {
			return numCliente;
		}


		public void setNumCliente(String numCliente) {
			this.numCliente = numCliente;
		}


		public String getTaxa() {
			return taxa;
		}


		public void setTaxa(String taxa) {
			this.taxa = taxa;
		}


		public String getVencimento() {
			return vencimento;
		}


		public void setVencimento(String vencimento) {
			this.vencimento = vencimento;
		}


		public String getConsumo() {
			return consumo;
		}


		public void setConsumo(String consumo) {
			this.consumo = consumo;
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
}
