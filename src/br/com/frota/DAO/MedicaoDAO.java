package br.com.frota.DAO;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.Medicao;

public class MedicaoDAO extends ConexaoDB{
	private static final String INSERT_MEDICAO_SQL = "INSERT INTO medicao (mes,"
			+ "ano, data_medicao, consumo, medidor_id, time_rota_id ) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_MEDICAO_BY_ID = "SELECT * FROM medicao WHERE id = ?";
    private static final String SELECT_ALL_MEDICAO = "SELECT * FROM medicao;";
    private static final String DELETE_MEDICAO_SQL = "DELETE FROM medicao WHERE id = ?;";
    //private static final String UPDATE_MEDICAO_SQL = "UPDATE medicao SET mes = ?,"
    		//+ "pneu_id = ?, ordem = ?, banda = ? WHERE id = ?;";
    
    public void insertPneuBanda(Medicao entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_MEDICAO_SQL)) {
            preparedStatement.setString(1, entidade.getMes());
            preparedStatement.setString(2, entidade.getAno());
            preparedStatement.setDate(3, new java.sql.Date(entidade.getDataMedicao().getTime()));
            preparedStatement.setString(4, entidade.getConsumo());
            preparedStatement.setInt(5, entidade.getIdMedidor());
            preparedStatement.setInt(6, entidade.getIdTimeRota());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Medicao selectMedicao(int id) {
    	Medicao entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_MEDICAO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	String mes = rs.getString("mes");
            	String ano = rs.getString("mes");
            	Date dataMedicao = rs.getDate("data_medicao");
                String consumo = rs.getString("consumo");
                int idMedidor = rs.getInt("medidor_id");
                int idTimeRota = rs.getInt("time_rota_id");
                entidade = new Medicao(id, mes, ano, dataMedicao, consumo, idMedidor, idTimeRota);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Medicao> selectAllMedicao() {
        List<Medicao> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_MEDICAO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	int id = rs.getInt("id");
            	String mes = rs.getString("mes");
            	String ano = rs.getString("mes");
            	Date dataMedicao = rs.getDate("data_medicao");
                String consumo = rs.getString("consumo");
                int idMedidor = rs.getInt("medidor_id");
                int idTimeRota = rs.getInt("time_rota_id");
                entidades.add(new Medicao(id,mes, ano, dataMedicao, consumo, idMedidor, idTimeRota));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteMedicao(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_MEDICAO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

   // public boolean updatePneuBanda(Medicao entidade) throws SQLException {
        //try (PreparedStatement statement = prapararSQL(UPDATE_MEDICAO_SQL)) {
        //	statement.setString(1, entidade.getObservacao());
        //	statement.setInt(2, entidade.getIdPneu());
        //	statement.setInt(3, entidade.getOrdem());
        //	statement.setInt(4, entidade.getIdBanda());
         //   statement.setInt(5, entidade.getId());

       //     return statement.executeUpdate() > 0;
      //  } catch (ClassNotFoundException e) {
      //      throw new RuntimeException(e);
      //  }
   // }
}
