package br.com.frota.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.Pessoal;

public class PessoalDAO extends ConexaoDB{
	private static final String INSERT_PESSOAL_SQL = "INSERT INTO pessoal (id, nome, cpf, cnpj, tipo_pessoal_id ) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_PESSOAL_BY_ID = "SELECT * FROM pessoal WHERE id = ?";
    private static final String SELECT_ALL_PESSOAL = "SELECT * FROM pessoal;";
    private static final String DELETE_PESSOAL_SQL = "DELETE FROM pessoal WHERE id = ?;";
    private static final String UPDATE_PESSOAL_SQL = "UPDATE pessoal SET nome = ?, cnpj = ?, tipo_pessoal_id = ? WHERE id = ?;";
    
    public void insertPessoal(Pessoal entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_PESSOAL_SQL)) {
        	preparedStatement.setInt(1, entidade.getId());
        	preparedStatement.setString(2, entidade.getNome());
            preparedStatement.setString(3, entidade.getCpf());
            preparedStatement.setString(4, entidade.getCnpj());
            preparedStatement.setInt(5, entidade.getTipoPessoal());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Pessoal selectPessoal(int id) {
    	Pessoal entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_PESSOAL_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String cnpj = rs.getString("cnpj");
                int idTipoPessoal = rs.getInt("tipo_pessoal_id");
                entidade = new Pessoal(id, nome, cpf, cnpj, idTipoPessoal);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Pessoal> selectAllPessoal() {
        List<Pessoal> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_PESSOAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String cnpj = rs.getString("cnpj");
                int idTipoPessoal = rs.getInt("tipo_pessoal_id");
                entidades.add(new Pessoal(id, nome, cpf, cnpj, idTipoPessoal));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deletePessoal(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_PESSOAL_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatePessoal(Pessoal entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_PESSOAL_SQL)) {
            statement.setString(1, entidade.getNome());
            statement.setString(2, entidade.getCnpj());
            statement.setInt(3, entidade.getTipoPessoal());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
