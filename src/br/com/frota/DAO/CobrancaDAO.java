package br.com.frota.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.Cobranca;

public class CobrancaDAO extends ConexaoDB{
	private static final String INSERT_COBRANCA_SQL = "INSERT INTO cobranca (mes_referencia, ano_referencia, tarifa_id) "
			+ "VALUES (?, ?, ?);";
    private static final String SELECT_COBRANCA_BY_ID = "SELECT * FROM cobranca WHERE id = ?";
    private static final String SELECT_ALL_COBRANCA = "SELECT * FROM cobranca;";
    private static final String DELETE_COBRANCA_SQL = "DELETE FROM cobranca WHERE id = ?;";
    private static final String UPDATE_COBRANCA_SQL = "UPDATE cobranca SET tarifa_id = ? WHERE id = ?";
    
    public void insertCobranca(Cobranca entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_COBRANCA_SQL)) {
            preparedStatement.setString(1, entidade.getMesReferencia());
            preparedStatement.setString(2, entidade.getAnoReferencia());
            preparedStatement.setInt(3, entidade.getIdTarifa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Cobranca selectCobranca(int id) {
    	Cobranca entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_COBRANCA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String mesReferencia = rs.getString("mes_referencia");
                String anoReferencia = rs.getString("ano_referencia");
                int idTarifa = rs.getInt("tarifa_id");
                entidade = new Cobranca(id, mesReferencia, anoReferencia, idTarifa);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Cobranca> selectAllCobranca() {
        List<Cobranca> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_COBRANCA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String mesReferencia = rs.getString("mes_referencia");
                String anoReferencia = rs.getString("ano_referencia");
                int idTarifa = rs.getInt("tarifa_id");
                entidades.add(new Cobranca(id, mesReferencia, anoReferencia, idTarifa));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteCobranca(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_COBRANCA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateCobranca(Cobranca entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_COBRANCA_SQL)) {
        	statement.setInt(1, entidade.getId());
        	statement.setInt(2, entidade.getIdTarifa());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

