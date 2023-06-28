package br.com.frota.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.Cliente;

public class ClienteDAO extends ConexaoDB{
	private static final String INSERT_CLIENTE_SQL = "INSERT INTO cliente (num_documento, num_cliente, pessoal_id) VALUES (?,?,?);";
    private static final String SELECT_CLIENTE_BY_ID = "SELECT * FROM cliente WHERE id = ?";
    private static final String SELECT_ALL_CLIENTE = "SELECT * FROM cliente;";
    private static final String DELETE_CLIENTE_SQL = "DELETE FROM cliente WHERE id = ?;";
    private static final String UPDATE_CLIENTE_SQL = "UPDATE cliente SET num_documento = ?, num_cliente = ?, pessoal_id = ? WHERE id = ?;";
    
    public void insertCliente(Cliente entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_CLIENTE_SQL)) {
            preparedStatement.setString(1, entidade.getNumDocumento());
            preparedStatement.setString(2, entidade.getNumCliente());
            preparedStatement.setInt(3, entidade.getIdPessoal());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente selectCliente(int id) {
    	Cliente entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_CLIENTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String numDocumento = rs.getString("num_documento");
                String numCliente = rs.getString("num_cliente");
                int idPessoal = rs.getInt("pessoal_id");
                entidade = new Cliente(id, numDocumento, numCliente, idPessoal);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Cliente> selectAllBandas() {
        List<Cliente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_CLIENTE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String numDocumento = rs.getString("num_documento");
                String numCliente = rs.getString("num_cliente");
                int idPessoal = rs.getInt("pessoal_id");
                entidades.add(new Cliente(id, numDocumento, numCliente, idPessoal));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteBanda(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_CLIENTE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateBanda(Cliente entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_CLIENTE_SQL)) {
        	statement.setString(1, entidade.getNumDocumento());
        	statement.setString(2, entidade.getNumCliente());
        	statement.setInt(3, entidade.getIdPessoal());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
}