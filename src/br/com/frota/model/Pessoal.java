package br.com.frota.model;

public class Pessoal extends GenericModel{
	private String nome;
	private String cpf;
	private String cnpj;
	private int idTipoPessoal;

	public Pessoal(String nome, String cpf, String cnpj, int idTipoPessoal) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.idTipoPessoal = idTipoPessoal;
	}
	
	public Pessoal(int id, String nome, String cpf, String cnpj, int idTipoPessoal) {
		super.setId(id);
		this.nome = nome;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.idTipoPessoal = idTipoPessoal;
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
	
	public int getTipoPessoal() {
		return idTipoPessoal;
	}

	public void setTipoPessoal(int idTipoPessoal) {
		this.idTipoPessoal = idTipoPessoal;
	}
	
	@Override
    public String toString() {
        return "Pessoal {" +
                "id='" + this.getId() + "\'" +
                "nome='" + nome + "\'" +
                "cpf='" + cpf + "\'" +
                "cnpj='" + cnpj + "\'" +
                "tipo_pessoal_id='" + idTipoPessoal + "\'" +
                '}';
    }
}
