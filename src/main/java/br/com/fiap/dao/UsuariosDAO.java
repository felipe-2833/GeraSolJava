package br.com.fiap.dao;

import br.com.fiap.to.UsuariosTO;

import java.sql.*;
import java.util.ArrayList;

public class UsuariosDAO extends Repository {
    public ArrayList<UsuariosTO> findAll() {
        ArrayList<UsuariosTO> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios ORDER BY id_usuario";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsuariosTO usuario = new UsuariosTO();
                usuario.setIdUsuario(rs.getLong("id_usuario"));
                usuario.setNomeCompleto(rs.getString("nome_completo"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar usuários: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return usuarios;
    }

    public UsuariosTO findById(Long idUsuario) {
        UsuariosTO usuario = null;
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new UsuariosTO();
                usuario.setIdUsuario(rs.getLong("id_usuario"));
                usuario.setNomeCompleto(rs.getString("nome_completo"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar usuário: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return usuario;
    }

    public UsuariosTO save(UsuariosTO usuario) {
        String sql = "INSERT INTO usuarios (nome_completo, email, senha, telefone, data_nascimento) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, usuario.getNomeCompleto());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getTelefone());
            ps.setDate(5, Date.valueOf(usuario.getDataNascimento()));
            if (ps.executeUpdate() > 0){
                return usuario;
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar usuário: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idUsuario);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir usuário: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public UsuariosTO update(UsuariosTO usuario) {
        String sql = "UPDATE usuarios SET nome_completo = ?, email = ?, senha = ?, telefone = ?, data_nascimento = ? WHERE id_usuario = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getNomeCompleto());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getTelefone());
            ps.setDate(5, Date.valueOf(usuario.getDataNascimento()));
            ps.setLong(6, usuario.getIdUsuario());
            if (ps.executeUpdate() > 0) {
                return usuario;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
