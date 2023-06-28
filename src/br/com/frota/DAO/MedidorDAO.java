package br.com.frota.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.Medidor;

public class MedidorDAO extends ConexaoDB {
	
	private static final String INSERT_MEDIDOR_SQL = "INSERT INTO medidor (descricao, rota_id, poste_id"
			+ " VALUES (?, ?, ?);";
    private static final String SELECT_MEDIDOR_BY_ID = "SELECT * FROM medidor WHERE id = ?";
    private static final String SELECT_ALL_MEDIDOR = "SELECT * FROM medidor;";
    private static final String DELETE_MEDIDOR_SQL = "DELETE FROM medidor WHERE id = ?;";
    private static final String UPDATE_MEDIDOR_SQL = "UPDATE medidor SET descricao = ?, poste_id = ?, "
    		+ "rota_id = ? WHERE id = ?;";
    
    public void insertMedidor(Medidor entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_MEDIDOR_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getIdRota());
            preparedStatement.setInt(3, entidade.getIdPoste());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Medidor selectMedidor(int id) {
    	Medidor entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_MEDIDOR_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	String descricao = rs.getString("descricao");
                int idRota = rs.getInt("rota_id");
                int idPoste = rs.getInt("poste_id");
                entidade = new Medidor(id, descricao, idRota, idPoste);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Medidor> selectAllMedidor() {
        List<Medidor> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_MEDIDOR)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                int idRota = rs.getInt("rota_id");
                int idPoste = rs.getInt("poste_id");
                entidades.add(new Medidor(id, descricao, idRota, idPoste));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteMedidor(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_MEDIDOR_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateMedidor(Medidor entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_MEDIDOR_SQL)) {
        	statement.setString(1, entidade.getDescricao());
        	statement.setInt(2, entidade.getIdRota());
        	statement.setInt(3, entidade.getIdPoste());
            statement.setInt(6, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
