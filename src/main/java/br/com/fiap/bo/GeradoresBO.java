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

    public GeradoresTO save(GeradoresTO gerador) throws Exception {
        ArrayList<String> ifPortatil = new ArrayList<String>();
        ifPortatil.add("Sim");
        ifPortatil.add("Nao");
        if (!ifPortatil.contains(gerador.getPortatil())){
            throw new Exception("informação portatil inválido. Permitidos: " + ifPortatil);
        }
        return geradoresDAO.save(gerador);
    }

    public boolean delete(Long id) {
        return geradoresDAO.delete(id);
    }

    public GeradoresTO update(GeradoresTO gerador) throws Exception{
        ArrayList<String> ifPortatil = new ArrayList<String>();
        ifPortatil.add("Sim");
        ifPortatil.add("Nao");
        if (!ifPortatil.contains(gerador.getPortatil())){
            throw new Exception("informação portatil inválido. Permitidos: " + ifPortatil);
        }
        return geradoresDAO.update(gerador);
    }
}