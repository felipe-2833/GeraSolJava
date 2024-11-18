package br.com.fiap.dao;

import br.com.fiap.to.ItensPedidoTO;
import br.com.fiap.to.PedidosTO;

import java.sql.*;
import java.util.ArrayList;

public class PedidosDAO extends Repository {
    public ArrayList<PedidosTO> findAll() {
        ArrayList<PedidosTO> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos ORDER BY id_pedido";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidosTO pedido = new PedidosTO();
                pedido.setIdPedido(rs.getLong("id_pedido"));
                pedido.setIdUsuario(rs.getLong("id_usuario"));
                pedido.setDataPedido(rs.getDate("data_pedido").toLocalDate());
                pedido.setStatus(rs.getString("status"));
                pedido.setTotalPedido(rs.getDouble("total_pedido"));
                pedido.setTipoTransacao(rs.getString("tipo_transacao"));
                pedido.setDataEntrega(rs.getDate("data_entrega").toLocalDate());
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar pedidos: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pedidos;
    }

    public PedidosTO findById(Long idPedido) {
        PedidosTO pedido = null;
        String sql = "SELECT * FROM pedidos WHERE id_pedido = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idPedido);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pedido = new PedidosTO();
                pedido.setIdPedido(rs.getLong("id_pedido"));
                pedido.setIdUsuario(rs.getLong("id_usuario"));
                pedido.setDataPedido(rs.getDate("data_pedido").toLocalDate());
                pedido.setStatus(rs.getString("status"));
                pedido.setTotalPedido(rs.getDouble("total_pedido"));
                pedido.setTipoTransacao(rs.getString("tipo_transacao"));
                pedido.setDataEntrega(rs.getDate("data_entrega").toLocalDate());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar pedido: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pedido;
    }

    public PedidosTO save(PedidosTO pedido) {
        String sqlPedido = "INSERT INTO pedidos (id_usuario, data_pedido, status, total_pedido, tipo_transacao, data_entrega) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sqlPedido)) {
            // Salvar o pedido
            ps.setLong(1, pedido.getIdUsuario());
            ps.setDate(2, Date.valueOf(pedido.getDataPedido()));
            ps.setString(3, pedido.getStatus());
            ps.setDouble(4, pedido.getTotalPedido());
            ps.setString(5, pedido.getTipoTransacao());
            ps.setDate(6, Date.valueOf(pedido.getDataEntrega()));

            if (ps.executeUpdate() > 0) {
                String sqlCodPedido = "SELECT id_pedido FROM pedidos order by id_pedido DESC";
                try (PreparedStatement psItem = getConnection().prepareStatement(sqlCodPedido)) {
                    ResultSet rs = psItem.executeQuery();
                    if (rs.next()) {
                        long idPedido = rs.getLong("id_pedido");
                        System.out.println(idPedido);
                        for (ItensPedidoTO item : pedido.getItensPedido()) {
                            String sqlItemPedido = "INSERT INTO itens_pedido (id_pedido, id_gerador, quantidade, valor_unitario, subtotal, tipo_transacao) VALUES (?, ?, ?, ?, ?, ?)";
                            try(PreparedStatement ps2 = getConnection().prepareStatement(sqlItemPedido)){
                                ps2.setLong(1, idPedido);
                                ps2.setLong(2, item.getIdGerador());
                                ps2.setInt(3, item.getQuantidade());
                                ps2.setDouble(4, item.getValorUnitario());
                                ps2.setDouble(5, item.getSubtotal());
                                ps2.setString(6, item.getTipoTransacao());
                                if (ps2.executeUpdate() <= 0) {
                                    return null;
                                }
                            }catch (SQLException e) {
                                System.out.println("Erro ao salvar pedido: " + e.getMessage());
                            }
                        }
                        return pedido;
                    }
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar pedido: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null; // Retorna null em caso de falha
    }

    public boolean delete(Long idPedido) {
        String sql = "DELETE FROM pedidos WHERE id_pedido = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idPedido);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir pedido: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public PedidosTO update(PedidosTO pedido) {
        String sql = "UPDATE pedidos SET id_usuario = ?, data_pedido = ?, status = ?, total_pedido = ?, tipo_transacao = ?, data_entrega = ? WHERE id_pedido = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, pedido.getIdUsuario());
            ps.setDate(2, Date.valueOf(pedido.getDataPedido()));
            ps.setString(3, pedido.getStatus());
            ps.setDouble(4, pedido.getTotalPedido());
            ps.setString(5, pedido.getTipoTransacao());
            ps.setDate(6, Date.valueOf(pedido.getDataEntrega()));
            ps.setLong(7, pedido.getIdPedido());
            if (ps.executeUpdate() > 0) {
                return pedido;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pedido: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
