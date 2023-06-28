package br.com.frota.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Date;

import br.com.frota.model.ContaLuz;
//import br.com.frota.model.Medicao;
//import br.com.frota.DAO.MedicaoDAO;

public class ContaLuzDAO extends ConexaoDB{

	private static final String SELECT_CONTALUZ_BY_ID = "SELECT r.descricao AS rota, me.descricao AS medidor, "
			+ "po.codigo AS poste, p.nome, p.cpf, p.cnpj, cl.descricao AS classe, tf.descricao AS tipo_fase,"
			+" c.num_cliente, t.taxa, t.data_fim as vencimento, md.consumo, co.mes_referencia as mes,"
			+" co.ano_referencia as ano\n"
	        + "FROM rota r\n"
	        + "JOIN medidor me ON r.id = me.rota_id\n"
	        + "JOIN poste po ON me.poste_id = po.id\n"
	        + "JOIN contrato ct ON me.id = ct.medidor_id\n"
	        + "JOIN cliente c ON ct.cliente_id = c.id\n"
	        + "JOIN pessoal p ON c.pessoal_id = p.id\n"
	        + "JOIN classe cl ON ct.classe_id = cl.id\n"
	        + "JOIN tipo_fase tf ON cl.tipo_fase_id = tf.id\n"
	        + "JOIN medicao md ON me.id = md.medidor_id\n"
	        + "JOIN cobranca co ON md.time_rota_id = co.id\n"
	        + "JOIN tarifa t ON co.tarifa_id = t.id\n"
	        + "WHERE md.id = ?;";

	public ContaLuz selectContaLuz(int idMedicao) {
	    ContaLuz contaLuz = null;
	    try (PreparedStatement preparedStatement = prapararSQL(SELECT_CONTALUZ_BY_ID)) {
	        preparedStatement.setInt(1, idMedicao);
	        ResultSet rs = preparedStatement.executeQuery();

	        if (rs.next()) {
	            // Extrair os dados do ResultSet
	            String rota = rs.getString("rota");
	            String medidor = rs.getString("medidor");
	            String poste = rs.getString("poste");
	            String nome = rs.getString("nome");
	            String cpf = rs.getString("cpf");
	            String cnpj = rs.getString("cnpj");
	            String classe = rs.getString("classe");
	            String tipoFase = rs.getString("tipo_fase");
	            String numCliente = rs.getString("num_cliente");
	            String taxa = rs.getString("taxa");
	            String vencimento = rs.getString("vencimento");
	            String consumo = rs.getString("consumo");
	            String mes = rs.getString("mes");
	            String ano = rs.getString("ano");
	            contaLuz = new ContaLuz(rota, medidor, poste, nome, cpf, cnpj, classe, tipoFase, numCliente, taxa, vencimento, consumo, mes, ano);
	        }
	    } catch (SQLException e) {
	        printSQLException(e);
	    } catch (ClassNotFoundException e) {
	        throw new RuntimeException(e);
	    }
	    return contaLuz;
	}

}