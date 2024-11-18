package br.com.fiap.dao;

import br.com.fiap.to.TransacoesAluguelTO;

import java.sql.*;
import java.util.ArrayList;

public class TransacoesAluguelDAO extends Repository {
    public ArrayList<TransacoesAluguelTO> findAll() {
        ArrayList<TransacoesAluguelTO> transacoes = new ArrayList<>();
        String sql = "SELECT * FROM transacoes_aluguel ORDER BY id_aluguel";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TransacoesAluguelTO transacao = new TransacoesAluguelTO();
                transacao.setIdAluguel(rs.getLong("id_aluguel"));
                transacao.setIdPedido(rs.getLong("id_pedido"));
                transacao.setIdUsuario(rs.getLong("id_usuario"));
                transacao.setIdGerador(rs.getLong("id_gerador"));
                transacao.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                transacao.setDataFim(rs.getDate("data_fim").toLocalDate());
                transacao.setDiasAluguel(rs.getInt("dias_aluguel"));
                transacao.setValorDiario(rs.getDouble("valor_diario"));
                transacao.setTotalAluguel(rs.getDouble("total_aluguel"));
                transacao.setStatusAluguel(rs.getString("status_aluguel"));
                transacoes.add(transacao);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar transações de aluguel: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return transacoes;
    }

    public TransacoesAluguelTO findById(Long idAluguel) {
        TransacoesAluguelTO transacao = null;
        String sql = "SELECT * FROM transacoes_aluguel WHERE id_aluguel = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idAluguel);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                transacao = new TransacoesAluguelTO();
                transacao.setIdAluguel(rs.getLong("id_aluguel"));
                transacao.setIdPedido(rs.getLong("id_pedido"));
                transacao.setIdUsuario(rs.getLong("id_usuario"));
                transacao.setIdGerador(rs.getLong("id_gerador"));
                transacao.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                transacao.setDataFim(rs.getDate("data_fim").toLocalDate());
                transacao.setDiasAluguel(rs.getInt("dias_aluguel"));
                transacao.setValorDiario(rs.getDouble("valor_diario"));
                transacao.setTotalAluguel(rs.getDouble("total_aluguel"));
                transacao.setStatusAluguel(rs.getString("status_aluguel"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar transação de aluguel: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return transacao;
    }

    public TransacoesAluguelTO save(TransacoesAluguelTO transacao) {
        String sql = "INSERT INTO transacoes_aluguel (id_pedido, id_usuario, id_gerador, data_inicio, data_fim, dias_aluguel, " +
                "valor_diario, total_aluguel, status_aluguel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, transacao.getIdPedido());
            ps.setLong(2, transacao.getIdUsuario());
            ps.setLong(3, transacao.getIdGerador());
            ps.setDate(4, Date.valueOf(transacao.getDataInicio()));
            ps.setDate(5, Date.valueOf(transacao.getDataFim()));
            ps.setInt(6, transacao.getDiasAluguel());
            ps.setDouble(7, transacao.getValorDiario());
            ps.setDouble(8, transacao.getTotalAluguel());
            ps.setString(9, transacao.getStatusAluguel());

            if (ps.executeUpdate() > 0) {
                return transacao;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar transação de aluguel: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long idAluguel) {
        String sql = "DELETE FROM transacoes_aluguel WHERE id_aluguel = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idAluguel);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir transação de aluguel: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public TransacoesAluguelTO update(TransacoesAluguelTO transacao) {
        String sql = "UPDATE transacoes_aluguel SET id_pedido = ?, id_usuario = ?, id_gerador = ?, data_inicio = ?, data_fim = ?, " +
                "dias_aluguel = ?, valor_diario = ?, total_aluguel = ?, status_aluguel = ? WHERE id_aluguel = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, transacao.getIdPedido());
            ps.setLong(2, transacao.getIdUsuario());
            ps.setLong(3, transacao.getIdGerador());
            ps.setDate(4, Date.valueOf(transacao.getDataInicio()));
            ps.setDate(5, Date.valueOf(transacao.getDataFim()));
            ps.setInt(6, transacao.getDiasAluguel());
            ps.setDouble(7, transacao.getValorDiario());
            ps.setDouble(8, transacao.getTotalAluguel());
            ps.setString(9, transacao.getStatusAluguel());
            ps.setLong(10, transacao.getIdAluguel());

            if (ps.executeUpdate() > 0) {
                return transacao;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar transação de aluguel: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
