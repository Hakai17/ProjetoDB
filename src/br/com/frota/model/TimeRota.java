package br.com.frota.model;

public class TimeRota extends GenericModel{
	private int idFuncionario;
	private int idTarefaRota;

	public TimeRota(int idFuncionario, int idTarefaRota) {
		super();
		this.idFuncionario = idFuncionario;
		this.idTarefaRota = idTarefaRota;
	}
	
	public TimeRota(int id, int idFuncionario, int idTarefaRota) {
		super.setId(id);
		this.idFuncionario = idFuncionario;
		this.idTarefaRota = idTarefaRota;
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public int getIdTarefaRota() {
		return idTarefaRota;
	}

	public void setIdTarefaRota(int idTarefaRota) {
		this.idTarefaRota = idTarefaRota;
	}

	@Override
    public String toString() {
        return "Time Rota {" +
                "id='" + this.getId() + "\'" +
                "funcionario_id='" + idFuncionario + "\'" +
                "tarefa_rota_id='" + idTarefaRota + "\'" +
                '}';
    }
}
