package br.com.fiap.dao;

import br.com.fiap.to.EnderecoTO;

import java.sql.*;
import java.util.ArrayList;

public class EnderecosDAO extends Repository {
    public ArrayList<EnderecoTO> findAll() {
        ArrayList<EnderecoTO> enderecos = new ArrayList<>();
        String sql = "SELECT * FROM enderecos ORDER BY id_endereco";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EnderecoTO endereco = new EnderecoTO();
                endereco.setIdEndereco(rs.getLong("id_endereco"));
                endereco.setEnderecoIdUser(rs.getLong("endereco_id_user"));
                endereco.setCep(rs.getString("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setNumero(rs.getInt("numero"));
                enderecos.add(endereco);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar endereços: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return enderecos;
    }

    public EnderecoTO findById(Long idEndereco) {
        EnderecoTO endereco = null;
        String sql = "SELECT * FROM enderecos WHERE id_endereco = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idEndereco);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                endereco = new EnderecoTO();
                endereco.setIdEndereco(rs.getLong("id_endereco"));
                endereco.setEnderecoIdUser(rs.getLong("endereco_id_user"));
                endereco.setCep(rs.getString("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setNumero(rs.getInt("numero"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar endereço: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return endereco;
    }

    public EnderecoTO save(EnderecoTO endereco) {
        String sql = "INSERT INTO enderecos (endereco_id_user, cep, rua, cidade, estado, numero) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, endereco.getEnderecoIdUser());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getRua());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getEstado());
            ps.setInt(6, endereco.getNumero());
            if (ps.executeUpdate() > 0) {
                return endereco;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar endereço: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long idEndereco) {
        String sql = "DELETE FROM enderecos WHERE id_endereco = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idEndereco);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir endereço: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public EnderecoTO update(EnderecoTO endereco) {
        String sql = "UPDATE enderecos SET endereco_id_user = ?, cep = ?, rua = ?, cidade = ?, estado = ?, numero = ? WHERE id_endereco = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, endereco.getEnderecoIdUser());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getRua());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getEstado());
            ps.setInt(6, endereco.getNumero());
            ps.setLong(7, endereco.getIdEndereco());
            if (ps.executeUpdate() > 0) {
                return endereco;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar endereço: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}