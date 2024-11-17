package br.com.fiap.bo;

import br.com.fiap.dao.MarcasDAO;
import br.com.fiap.to.MarcasTO;

import java.util.ArrayList;

public class MarcasBO {
    private MarcasDAO marcasDAO = new MarcasDAO();

    public ArrayList<MarcasTO> findAll() {
        return marcasDAO.findAll();
    }

    public MarcasTO findById(Long id) {
        return marcasDAO.findById(id);
    }

    public MarcasTO save(MarcasTO marca) {
        return marcasDAO.save(marca);
    }

    public boolean delete(Long id) {
        return marcasDAO.delete(id);
    }

    public MarcasTO update(MarcasTO marca) {
        return marcasDAO.update(marca);
    }
}