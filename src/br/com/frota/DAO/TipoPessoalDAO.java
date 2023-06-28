package br.com.frota.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.TipoPessoal;

public class TipoPessoalDAO extends ConexaoDB{
    private static final String INSERT_TIPO_PESSOAL_SQL = "INSERT INTO tipo_pessoal (descricao) VALUES (?);";
    private static final String SELECT_TIPO_PESSOAL_BY_ID = "SELECT * FROM tipo_pessoal WHERE id = ?";
    private static final String SELECT_ALL_TIPO_PESSOAL = "SELECT * FROM tipo_pessoal;";
    private static final String DELETE_TIPO_PESSOAL_SQL = "DELETE FROM tipo_pessoal WHERE id = ?;";
    private static final String UPDATE_TIPO_PESSOAL_SQL = "UPDATE tipo_pessoal SET descricao = ? WHERE id = ?;";
    
    public void insertTipoPessoal(TipoPessoal entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_TIPO_PESSOAL_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TipoPessoal selectTipoPessoal(int id) {
    	TipoPessoal entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_TIPO_PESSOAL_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                entidade = new TipoPessoal(id, descricao);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<TipoPessoal> selectAllTipoPessoal() {
        List<TipoPessoal> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_TIPO_PESSOAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                entidades.add(new TipoPessoal(id, descricao));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteTipoPessal(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_TIPO_PESSOAL_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateTipoPessoal(TipoPessoal entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_TIPO_PESSOAL_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
