package br.com.fiap.dao;

import br.com.fiap.to.CategoriaTO;

import java.sql.*;
import java.util.ArrayList;

public class CategoriaDAO extends Repository {
    public ArrayList<CategoriaTO> findAll() {
        ArrayList<CategoriaTO> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria ORDER BY id_categoria";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CategoriaTO categoria = new CategoriaTO();
                categoria.setIdCategoria(rs.getLong("id_categoria"));
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar categorias: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return categorias;
    }

    public CategoriaTO findById(Long idCategoria) {
        CategoriaTO categoria = null;
        String sql = "SELECT * FROM categoria WHERE id_categoria = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idCategoria);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                categoria = new CategoriaTO();
                categoria.setIdCategoria(rs.getLong("id_categoria"));
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                categoria.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar categoria: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return categoria;
    }

    public CategoriaTO save(CategoriaTO categoria) {
        String sql = "INSERT INTO categoria (nome_categoria, descricao) VALUES (?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, categoria.getNomeCategoria());
            ps.setString(2, categoria.getDescricao());
            if (ps.executeUpdate() > 0) {
                return categoria;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar categoria: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long idCategoria) {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idCategoria);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir categoria: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public CategoriaTO update(CategoriaTO categoria) {
        String sql = "UPDATE categoria SET nome_categoria = ?, descricao = ? WHERE id_categoria = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, categoria.getNomeCategoria());
            ps.setString(2, categoria.getDescricao());
            ps.setLong(3, categoria.getIdCategoria());
            if (ps.executeUpdate() > 0) {
                return categoria;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar categoria: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}