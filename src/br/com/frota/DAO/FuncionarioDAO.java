package br.com.frota.DAO;

import br.com.frota.model.Funcionario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends ConexaoDB {

    private static final String INSERT_FUNCIONARIO_SQL = "INSERT INTO funcionario (codigo_funcionario, pessoal_id) VALUES (?, ?);";
    private static final String SELECT_FUNCIONARIO_BY_ID = "SELECT * FROM funcionario WHERE id = ?";
    private static final String SELECT_ALL_FUNCIONARIO = "SELECT * FROM funcionario;";
    private static final String DELETE_FUNCIONARIO_SQL = "DELETE FROM funcionario WHERE id = ?;";
    private static final String UPDATE_FUNCIONARIO_SQL = "UPDATE funcionario SET codigo_funcionario = ?, pessoal_id = ? WHERE id = ?;";

    public void insertFuncionario(Funcionario entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_FUNCIONARIO_SQL)) {
            preparedStatement.setString(1, entidade.getCodigoFuncionario());
            preparedStatement.setInt(1, entidade.getIdPessoal());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Funcionario selectFuncionario(int id) {
        Funcionario entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_FUNCIONARIO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String codigoFuncionario = rs.getString("codigo_funcionario");
                int idPessoal = rs.getInt("pessoal_id");
                entidade = new Funcionario(id, codigoFuncionario, idPessoal);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Funcionario> selectAllFuncionario() {
        List<Funcionario> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_FUNCIONARIO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String codigoFuncionario = rs.getString("codigo_funcionario");
                int idPessoal = rs.getInt("pessoal_id");
                entidades.add(new Funcionario(id, codigoFuncionario, idPessoal));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteFuncinario(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_FUNCIONARIO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateFuncionario(Funcionario entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_FUNCIONARIO_SQL)) {
            statement.setString(1, entidade.getCodigoFuncionario());
            statement.setInt(1, entidade.getIdPessoal());
            statement.setInt(2, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
