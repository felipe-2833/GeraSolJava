package br.com.fiap.dao;

import br.com.fiap.to.ItensPedidoTO;

import java.sql.*;
import java.util.ArrayList;

public class ItensPedidosDAO extends Repository {

    public ArrayList<ItensPedidoTO> findAll() {
        ArrayList<ItensPedidoTO> itens = new ArrayList<>();
        String sql = "SELECT * FROM itens_pedido ORDER BY id_item";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ItensPedidoTO item = new ItensPedidoTO();
                item.setIdItem(rs.getLong("id_item"));
                item.setIdPedido(rs.getLong("id_pedido"));
                item.setIdGerador(rs.getLong("id_gerador"));
                item.setQuantidade(rs.getInt("quantidade"));
                item.setValorUnitario(rs.getDouble("valor_unitario"));
                item.setSubtotal(rs.getDouble("subtotal"));
                item.setTipoTransacao(rs.getString("tipo_transacao"));
                itens.add(item);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar itens de pedido: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return itens;
    }

    public ItensPedidoTO findById(Long idItem) {
        ItensPedidoTO item = null;
        String sql = "SELECT * FROM itens_pedido WHERE id_item = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idItem);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                item = new ItensPedidoTO();
                item.setIdItem(rs.getLong("id_item"));
                item.setIdPedido(rs.getLong("id_pedido"));
                item.setIdGerador(rs.getLong("id_gerador"));
                item.setQuantidade(rs.getInt("quantidade"));
                item.setValorUnitario(rs.getDouble("valor_unitario"));
                item.setSubtotal(rs.getDouble("subtotal"));
                item.setTipoTransacao(rs.getString("tipo_transacao"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar item de pedido: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return item;
    }

    public boolean delete(Long idItem) {
        String sql = "DELETE FROM itens_pedido WHERE id_item = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idItem);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir item de pedido: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ItensPedidoTO update(ItensPedidoTO item) {
        String sql = "UPDATE itens_pedido SET id_pedido = ?, id_gerador = ?, quantidade = ?, valor_unitario = ?, " +
                "subtotal = ?, tipo_transacao = ? WHERE id_item = ?";
        item.setSubtotal(item.calcularSubtotal(item.getQuantidade(), item.getValorUnitario()));
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, item.getIdPedido());
            ps.setLong(2, item.getIdGerador());
            ps.setInt(3, item.getQuantidade());
            ps.setDouble(4, item.getValorUnitario());
            ps.setDouble(5, item.getSubtotal());
            ps.setString(6, item.getTipoTransacao());
            ps.setLong(7, item.getIdItem());
            if (ps.executeUpdate() > 0) {
                return item;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar item de pedido: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
