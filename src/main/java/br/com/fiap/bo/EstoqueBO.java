package br.com.fiap.bo;

import br.com.fiap.dao.EstoqueDAO;
import br.com.fiap.to.EstoqueTO;

import java.util.ArrayList;

public class EstoqueBO {
    private EstoqueDAO estoqueDAO = new EstoqueDAO();

    public ArrayList<EstoqueTO> findAll() {
        return estoqueDAO.findAll();
    }

    public EstoqueTO findById(Long id) {
        return estoqueDAO.findById(id);
    }

    public EstoqueTO save(EstoqueTO estoque) {
        return estoqueDAO.save(estoque);
    }

    public boolean delete(Long id) {
        return estoqueDAO.delete(id);
    }

    public EstoqueTO update(EstoqueTO estoque) {
        return estoqueDAO.update(estoque);
    }
}