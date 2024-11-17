package br.com.fiap.dao;

import br.com.fiap.to.EstoqueTO;

import java.sql.*;
import java.util.ArrayList;

public class EstoqueDAO extends Repository {
    public ArrayList<EstoqueTO> findAll() {
        ArrayList<EstoqueTO> estoques = new ArrayList<>();
        String sql = "SELECT * FROM estoque ORDER BY id_estoque";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EstoqueTO estoque = new EstoqueTO();
                estoque.setIdEstoque(rs.getLong("id_estoque"));
                estoque.setIdGerador(rs.getLong("id_gerador"));
                estoque.setQuantidadeDisponivel(rs.getInt("quantidade_disponivel"));
                estoque.setQuantidadeReservada(rs.getInt("quantidade_reservada"));
                estoques.add(estoque);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar estoques: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return estoques;
    }

    public EstoqueTO findById(Long idEstoque) {
        EstoqueTO estoque = null;
        String sql = "SELECT * FROM estoque WHERE id_estoque = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idEstoque);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estoque = new EstoqueTO();
                estoque.setIdEstoque(rs.getLong("id_estoque"));
                estoque.setIdGerador(rs.getLong("id_gerador"));
                estoque.setQuantidadeDisponivel(rs.getInt("quantidade_disponivel"));
                estoque.setQuantidadeReservada(rs.getInt("quantidade_reservada"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar estoque: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return estoque;
    }

    public EstoqueTO save(EstoqueTO estoque) {
        String sql = "INSERT INTO estoque (id_gerador, quantidade_disponivel, quantidade_reservada) VALUES (?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, estoque.getIdGerador());
            ps.setInt(2, estoque.getQuantidadeDisponivel());
            ps.setInt(3, estoque.getQuantidadeReservada());
            if (ps.executeUpdate() > 0) {
                return estoque;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar estoque: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long idEstoque) {
        String sql = "DELETE FROM estoque WHERE id_estoque = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idEstoque);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir estoque: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public EstoqueTO update(EstoqueTO estoque) {
        String sql = "UPDATE estoque SET id_gerador = ?, quantidade_disponivel = ?, quantidade_reservada = ? WHERE id_estoque = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, estoque.getIdGerador());
            ps.setInt(2, estoque.getQuantidadeDisponivel());
            ps.setInt(3, estoque.getQuantidadeReservada());
            ps.setLong(4, estoque.getIdEstoque());
            if (ps.executeUpdate() > 0) {
                return estoque;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar estoque: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}