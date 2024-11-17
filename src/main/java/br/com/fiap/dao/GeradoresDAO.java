package br.com.fiap.dao;

import br.com.fiap.to.GeradoresTO;

import java.sql.*;
import java.util.ArrayList;

public class GeradoresDAO extends Repository {
    public ArrayList<GeradoresTO> findAll() {
        ArrayList<GeradoresTO> geradores = new ArrayList<>();
        String sql = "SELECT * FROM geradores ORDER BY id_gerador";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GeradoresTO gerador = new GeradoresTO();
                gerador.setIdGerador(rs.getLong("id_gerador"));
                gerador.setIdMarca(rs.getLong("id_marca"));
                gerador.setIdCategoria(rs.getLong("id_categoria"));
                gerador.setModelo(rs.getString("modelo"));
                gerador.setDescricao(rs.getString("descricao"));
                gerador.setPotencia(rs.getDouble("potencia"));
                gerador.setCapacidadeBateria(rs.getDouble("capacidade_bateria"));
                gerador.setPortas(rs.getString("portas"));
                gerador.setTempoCarga(rs.getString("tempo_carga"));
                gerador.setPrecoVenda(rs.getDouble("preco_venda"));
                gerador.setPrecoAluguelDiario(rs.getDouble("preco_aluguel_diario"));
                gerador.setDurabilidade(rs.getString("durabilidade"));
                gerador.setPortatil(rs.getString("portatil"));
                geradores.add(gerador);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar geradores: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return geradores;
    }

    public GeradoresTO findById(Long idGerador) {
        GeradoresTO gerador = null;
        String sql = "SELECT * FROM geradores WHERE id_gerador = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idGerador);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                gerador = new GeradoresTO();
                gerador.setIdGerador(rs.getLong("id_gerador"));
                gerador.setIdMarca(rs.getLong("id_marca"));
                gerador.setIdCategoria(rs.getLong("id_categoria"));
                gerador.setModelo(rs.getString("modelo"));
                gerador.setDescricao(rs.getString("descricao"));
                gerador.setPotencia(rs.getDouble("potencia"));
                gerador.setCapacidadeBateria(rs.getDouble("capacidade_bateria"));
                gerador.setPortas(rs.getString("portas"));
                gerador.setTempoCarga(rs.getString("tempo_carga"));
                gerador.setPrecoVenda(rs.getDouble("preco_venda"));
                gerador.setPrecoAluguelDiario(rs.getDouble("preco_aluguel_diario"));
                gerador.setDurabilidade(rs.getString("durabilidade"));
                gerador.setPortatil(rs.getString("portatil"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar gerador: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return gerador;
    }

    public GeradoresTO save(GeradoresTO gerador) {
        String sql = "INSERT INTO geradores (id_marca, id_categoria, modelo, descricao, potencia, capacidade_bateria, " +
                "portas, tempo_carga, preco_venda, preco_aluguel_diario, durabilidade, portatil) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, gerador.getIdMarca());
            ps.setLong(2, gerador.getIdCategoria());
            ps.setString(3, gerador.getModelo());
            ps.setString(4, gerador.getDescricao());
            ps.setDouble(5, gerador.getPotencia());
            ps.setDouble(6, gerador.getCapacidadeBateria());
            ps.setString(7, gerador.getPortas());
            ps.setString(8, gerador.getTempoCarga());
            ps.setDouble(9, gerador.getPrecoVenda());
            ps.setDouble(10, gerador.getPrecoAluguelDiario());
            ps.setString(11, gerador.getDurabilidade());
            ps.setString(12, gerador.getPortatil());
            if (ps.executeUpdate() > 0) {
                return gerador;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar gerador: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long idGerador) {
        String sql = "DELETE FROM geradores WHERE id_gerador = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idGerador);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir gerador: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public GeradoresTO update(GeradoresTO gerador) {
        String sql = "UPDATE geradores SET id_marca = ?, id_categoria = ?, modelo = ?, descricao = ?, potencia = ?, " +
                "capacidade_bateria = ?, portas = ?, tempo_carga = ?, preco_venda = ?, preco_aluguel_diario = ?, " +
                "durabilidade = ?, portatil = ? WHERE id_gerador = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, gerador.getIdMarca());
            ps.setLong(2, gerador.getIdCategoria());
            ps.setString(3, gerador.getModelo());
            ps.setString(4, gerador.getDescricao());
            ps.setDouble(5, gerador.getPotencia());
            ps.setDouble(6, gerador.getCapacidadeBateria());
            ps.setString(7, gerador.getPortas());
            ps.setString(8, gerador.getTempoCarga());
            ps.setDouble(9, gerador.getPrecoVenda());
            ps.setDouble(10, gerador.getPrecoAluguelDiario());
            ps.setString(11, gerador.getDurabilidade());
            ps.setString(12, gerador.getPortatil());
            ps.setLong(13, gerador.getIdGerador());
            if (ps.executeUpdate() > 0) {
                return gerador;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar gerador: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}