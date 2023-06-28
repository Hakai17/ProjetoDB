package br.com.frota.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.TimeRota;

public class TimeRotaDAO extends ConexaoDB{
    private static final String INSERT_TIME_ROTA_SQL = "INSERT INTO time_rota (funcionario_id,"
    		+ "tarefa_rota_id) VALUES (?, ?);";
    private static final String SELECT_TIME_ROTA_BY_ID = "SELECT * FROM time_rota WHERE id = ?";
    private static final String SELECT_ALL_TIME_ROTA = "SELECT * FROM time_rota;";
    private static final String DELETE_TIME_ROTA_SQL = "DELETE FROM time_rota WHERE id = ?;";
    private static final String UPDATE_TIME_ROTA_SQL = "UPDATE time_rota SET funcionario_id = ?,"
    		+ "tarefa_rota_id = ? WHERE id = ?;";
    
    public void insertTimeRota(TimeRota entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_TIME_ROTA_SQL)) {
            preparedStatement.setInt(1, entidade.getIdFuncionario());
            preparedStatement.setInt(2, entidade.getIdTarefaRota());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TimeRota selectTimeRota(int id) {
    	TimeRota entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_TIME_ROTA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idFuncionario = rs.getInt("funcionario_id");
                int idTarefaRota = rs.getInt("tarefa_rota_id");
                entidade = new TimeRota(id, idFuncionario, idTarefaRota);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<TimeRota> selectAllTimeRota() {
        List<TimeRota> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_TIME_ROTA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int idFuncionario = rs.getInt("funcionario_id");
                int idTarefaRota = rs.getInt("tarefa_rota_id");
                entidades.add(new TimeRota(id, idFuncionario, idTarefaRota));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteTimeRota(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_TIME_ROTA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateTimeRota(TimeRota entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_TIME_ROTA_SQL)) {
            statement.setInt(1, entidade.getIdFuncionario());
            statement.setInt(2, entidade.getIdTarefaRota());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
