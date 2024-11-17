package br.com.fiap.bo;

import br.com.fiap.dao.UsuariosDAO;
import br.com.fiap.to.UsuariosTO;

import java.util.ArrayList;

public class UsuariosBO {
    private UsuariosDAO usuariosDAO = new UsuariosDAO();

    public ArrayList<UsuariosTO> findAll() {
        return usuariosDAO.findAll();
    }

    public UsuariosTO findById(Long id) {
        return usuariosDAO.findById(id);
    }

    public UsuariosTO save(UsuariosTO usuario) {
        return usuariosDAO.save(usuario);
    }

    public boolean delete(Long id) {
        return usuariosDAO.delete(id);
    }

    public UsuariosTO update(UsuariosTO usuario) {
        return usuariosDAO.update(usuario);
    }
}
