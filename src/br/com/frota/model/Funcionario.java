package br.com.frota.model;

public class Funcionario extends GenericModel {
    private String codigoFuncionario;
    private int idPessoal;

    public Funcionario(String codigoFuncionario, int idPessoal) {
        this.codigoFuncionario = codigoFuncionario;
        this.idPessoal = idPessoal;
    }

    public Funcionario(int id, String codigoFuncionario, int idPessoal) {
    	super.setId(id);
    	this.codigoFuncionario = codigoFuncionario;
        this.idPessoal = idPessoal;
        
    }

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }
    
    public int getIdPessoal() {
		return idPessoal;
	}

	public void setIdPessoal(int idPessoal) {
		this.idPessoal = idPessoal;
	}

    @Override
    public String toString() {
        return "Funcionario {" +
                "id='" + this.getId() + "\'" +
                "codigo_funcionario='" + codigoFuncionario + "\'" +
                "pessoal_id='" + idPessoal + "\'" +
                '}';
    }

	
}
