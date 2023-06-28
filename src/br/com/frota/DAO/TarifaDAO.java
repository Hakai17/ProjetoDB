package br.com.frota.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.Tarifa;

public class TarifaDAO extends ConexaoDB{
    private static final String INSERT_TARIFA_SQL = "INSERT INTO tarifa (taxa,"
    		+ "lei, data_inicio, data_fim, aliquota_icms, classe_id) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_TARIFA_BY_ID = "SELECT * FROM tarifa WHERE id = ?";
    private static final String SELECT_ALL_TARIFA = "SELECT * FROM tarifa;";
    private static final String DELETE_TARIFA_SQL = "DELETE FROM tarifa WHERE id = ?;";
    private static final String UPDATE_TARIFA_SQL = "UPDATE tarifa SET taxa = ?, lei = ?, data_inicio = ?,"
    		+ "data_fim = ?, aliquota_icms = ?, classe_id = ?  WHERE id = ?;";
    
    public void insertTarifa(Tarifa entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_TARIFA_SQL)) {
            preparedStatement.setString(1, entidade.getTaxa());
            preparedStatement.setString(2, entidade.getLei());
            preparedStatement.setString(3, entidade.getDataInicio());
            preparedStatement.setString(4, entidade.getDataFim());
            preparedStatement.setString(5, entidade.getAliquotaIcms());
            preparedStatement.setInt(6, entidade.getIdClasse());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Tarifa selectTarifa(int id) {
    	Tarifa entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_TARIFA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String taxa = rs.getString("taxa");
                String lei = rs.getString("lei");
                String dataInicio = rs.getString("data_inicio");
                String dataFim = rs.getString("data_fim");
                String aliquotaIcms = rs.getString("aliquota_icms");
                int idClasse = rs.getInt("classe_id");
                entidade = new Tarifa(id, taxa, lei, dataInicio, dataFim, aliquotaIcms, idClasse);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Tarifa> selectAllTarifa() {
        List<Tarifa> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_TARIFA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String taxa = rs.getString("taxa");
                String lei = rs.getString("lei");
                String dataInicio = rs.getString("data_inicio");
                String dataFim = rs.getString("data_fim");
                String aliquotaIcms = rs.getString("aliquota_icms");
                int idClasse = rs.getInt("classe_id");
                entidades.add(new Tarifa(id, taxa, lei, dataInicio, dataFim, aliquotaIcms, idClasse));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteTarifa(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_TARIFA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateTarifa(Tarifa entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_TARIFA_SQL)) {
            statement.setString(1, entidade.getTaxa());
            statement.setString(2, entidade.getLei());
            statement.setString(3, entidade.getDataInicio());
            statement.setString(4, entidade.getDataFim());
            statement.setString(5, entidade.getAliquotaIcms());
            statement.setInt(6, entidade.getIdClasse());
            statement.setInt(7, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
