package br.com.frota.model;

public class Cliente extends GenericModel{
	private String numDocumento;
	private String numCliente;
	private int idPessoal;
	
	public Cliente(String numDocumento, String numCliente, int idPessoal) {
		super();
		this.numDocumento = numDocumento;
		this.numCliente = numCliente;
		this.idPessoal = idPessoal;
	}
	
	public Cliente(int id, String numDocumento, String numCliente, int idPessoal) {
		super.setId(id);
		this.numDocumento = numDocumento;
		this.numCliente = numCliente;
		this.idPessoal = idPessoal;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
	}

	public int getIdPessoal() {
		return idPessoal;
	}

	public void setIdPessoal(int idPessoal) {
		this.idPessoal = idPessoal;
	}
	
	@Override
	public String toString() {
		return "Cliente {" +
                "id='" + this.getId() + "\'" +
                "num_documento='" + numDocumento + "\'" +
                "num_cliente='" + numCliente + "\'" +
                "pessoal_id ='" + idPessoal + "\'" +
                '}';
	}
}
