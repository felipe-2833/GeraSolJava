package br.com.fiap.bo;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.to.CategoriaTO;

import java.util.ArrayList;

public class CategoriaBO {
    private CategoriaDAO categoriaDAO = new CategoriaDAO();

    public ArrayList<CategoriaTO> findAll() {
        return categoriaDAO.findAll();
    }

    public CategoriaTO findById(Long id) {
        return categoriaDAO.findById(id);
    }

    public CategoriaTO save(CategoriaTO categoria) {
        return categoriaDAO.save(categoria);
    }

    public boolean delete(Long id) {
        return categoriaDAO.delete(id);
    }

    public CategoriaTO update(CategoriaTO categoria) {
        return categoriaDAO.update(categoria);
    }
}