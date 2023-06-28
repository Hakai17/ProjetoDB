package br.com.frota.DAO;

import br.com.frota.model.Contrato;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContratoDAO extends ConexaoDB {

    private static final String INSERT_CONTRATO_SQL = "INSERT INTO contrato (descricao, data_inicio, data_criacao,"
    		+ " medidor_id, classe_id, cliente_id )"
    		+ "VALUES (?, ?, NOW(), ?, ?, ?);";
    private static final String SELECT_CONTRATO_BY_ID = "SELECT * FROM contrato WHERE id = ?";
    private static final String SELECT_ALL_CONTRATO = "SELECT * FROM contrato;";
    private static final String DELETE_CONTRATO_SQL = "DELETE FROM contrato WHERE id = ?;";
    private static final String UPDATE_CONTRATO_SQL = "UPDATE contrato SET descricao = ?, medidor_id = ?, classe_id = ? WHERE id = ?;";
    // private static final String TOTAL = "SELECT count(1) FROM contrato;";

//    public Integer count() {
//        Integer count = 0;
//        try (PreparedStatement preparedStatement = prapararSQL(TOTAL)) {
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                count = rs.getInt("count");
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        return count;
//    }

    public void insertContrato(Contrato entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_CONTRATO_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setDate(2, new java.sql.Date(entidade.getDataInicio().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(entidade.getDataCriacao().getTime()));
            preparedStatement.setInt(4, entidade.getIdMedidor());
            preparedStatement.setInt(5, entidade.getIdClasse());
            preparedStatement.setInt(6, entidade.getIdCliente());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Contrato selectContrato(int id) {
        Contrato entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_CONTRATO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Date dataInicio = rs.getDate("data_inicio");
                Date dataCriacao = rs.getDate("data_criacao");
                int idMedidor = rs.getInt("medidor_id");
                int idClasse = rs.getInt("classe_id");
                int idCliente = rs.getInt("cliente_id");
                entidade = new Contrato(id, descricao, dataInicio, dataCriacao, idMedidor, idClasse, idCliente);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Contrato> selectAllContrato() {
        List<Contrato> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_CONTRATO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Date dataInicio = rs.getDate("data_inicio");
                Date dataCriacao = rs.getDate("data_criacao");
                int idMedidor = rs.getInt("medidor_id");
                int idClasse = rs.getInt("classe_id");
                int idCliente = rs.getInt("cliente_id");
                entidades.add(new Contrato(id, descricao, dataInicio, dataCriacao, idMedidor, idClasse, idCliente));
        }} catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteContrato(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_CONTRATO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateContrato(Contrato entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_CONTRATO_SQL)) {
        	statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getIdMedidor());
            statement.setInt(3, entidade.getIdClasse());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
