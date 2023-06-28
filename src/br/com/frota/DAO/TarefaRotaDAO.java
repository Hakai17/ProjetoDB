package br.com.frota.DAO;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.TarefaRota;

public class TarefaRotaDAO extends ConexaoDB{
    private static final String INSERT_TAREFA_ROTA_SQL = "INSERT INTO tarefa_rota (observacao,"
    		+ "data_inicio, data_fim, rota_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_TAREFA_ROTA_BY_ID = "SELECT * FROM tarefa_rota WHERE id = ?";
    private static final String SELECT_ALL_TAREFA_ROTA = "SELECT * FROM tarefa_rota;";
    private static final String DELETE_TAREFA_ROTA_SQL = "DELETE FROM tarefa_rota WHERE id = ?;";
    private static final String UPDATE_TAREFA_ROTA_SQL = "UPDATE tarefa_rota SET observacao = ?,"
    		+ "data_inicio = ?, data_fim = ?, rota_id = ? WHERE id = ?;";
    
    public void insertTarefaRota(TarefaRota entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_TAREFA_ROTA_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setDate(2, new java.sql.Date(entidade.getDataInicio().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(entidade.getDataFim().getTime()));
            preparedStatement.setInt(4, entidade.getIdRota());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TarefaRota selectTarefaRota(int id) {
    	TarefaRota entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_TAREFA_ROTA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Date dataInicio = rs.getDate("data_inicio");
                Date dataFim = rs.getDate("data_fim");
                int idRota = rs.getInt("rota_id");
                entidade = new TarefaRota(id, observacao, dataInicio, dataFim, idRota);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<TarefaRota> selectAllTarefaRota() {
        List<TarefaRota> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_TAREFA_ROTA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                Date dataInicio = rs.getDate("data_inicio");
                Date dataFim = rs.getDate("data_fim");
                int idRota = rs.getInt("rota_id");
                entidades.add(new TarefaRota(id, observacao, dataInicio, dataFim, idRota));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteTarefaRota(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_TAREFA_ROTA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateTarefaRota(TarefaRota entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_TAREFA_ROTA_SQL)) {
            statement.setString(1, entidade.getObservacao());
            statement.setDate(2, new java.sql.Date(entidade.getDataInicio().getTime()));
            statement.setDate(3, new java.sql.Date(entidade.getDataFim().getTime()));
            statement.setInt(4, entidade.getIdRota());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
