package br.com.fiap.bo;

import br.com.fiap.dao.GeradoresDAO;
import br.com.fiap.to.GeradoresTO;

import java.util.ArrayList;

public class GeradoresBO {
    private GeradoresDAO geradoresDAO = new GeradoresDAO();

    public ArrayList<GeradoresTO> findAll() {
        return geradoresDAO.findAll();
    }

    public GeradoresTO findById(Long id) {
        return geradoresDAO.findById(id);
    }

    public GeradoresTO save(GeradoresTO gerador) {
        return geradoresDAO.save(gerador);
    }

    public boolean delete(Long id) {
        return geradoresDAO.delete(id);
    }

    public GeradoresTO update(GeradoresTO gerador) {
        return geradoresDAO.update(gerador);
    }
}