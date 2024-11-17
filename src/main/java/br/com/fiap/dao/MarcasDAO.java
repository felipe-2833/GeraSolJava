package br.com.fiap.dao;

import br.com.fiap.to.MarcasTO;

import java.sql.*;
import java.util.ArrayList;

public class MarcasDAO extends Repository {
    public ArrayList<MarcasTO> findAll() {
        ArrayList<MarcasTO> marcas = new ArrayList<>();
        String sql = "SELECT * FROM marcas ORDER BY id_marca";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MarcasTO marca = new MarcasTO();
                marca.setIdMarca(rs.getLong("id_marca"));
                marca.setNomeMarca(rs.getString("nome_marca"));
                marca.setPaisOrigem(rs.getString("pais_origem"));
                marca.setDescricao(rs.getString("descricao"));
                marcas.add(marca);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar marcas: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return marcas;
    }

    public MarcasTO findById(Long idMarca) {
        MarcasTO marca = null;
        String sql = "SELECT * FROM marcas WHERE id_marca = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idMarca);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                marca = new MarcasTO();
                marca.setIdMarca(rs.getLong("id_marca"));
                marca.setNomeMarca(rs.getString("nome_marca"));
                marca.setPaisOrigem(rs.getString("pais_origem"));
                marca.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar marca: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return marca;
    }

    public MarcasTO save(MarcasTO marca) {
        String sql = "INSERT INTO marcas (nome_marca, pais_origem, descricao) VALUES (?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, marca.getNomeMarca());
            ps.setString(2, marca.getPaisOrigem());
            ps.setString(3, marca.getDescricao());
            if (ps.executeUpdate() > 0) {
                return marca;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar marca: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long idMarca) {
        String sql = "DELETE FROM marcas WHERE id_marca = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idMarca);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir marca: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public MarcasTO update(MarcasTO marca) {
        String sql = "UPDATE marcas SET nome_marca = ?, pais_origem = ?, descricao = ? WHERE id_marca = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, marca.getNomeMarca());
            ps.setString(2, marca.getPaisOrigem());
            ps.setString(3, marca.getDescricao());
            ps.setLong(4, marca.getIdMarca());
            if (ps.executeUpdate() > 0) {
                return marca;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar marca: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
