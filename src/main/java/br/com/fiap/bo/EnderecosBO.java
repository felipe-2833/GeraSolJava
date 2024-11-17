package br.com.fiap.bo;

import br.com.fiap.dao.EnderecosDAO;
import br.com.fiap.to.EnderecoTO;

import java.util.ArrayList;

public class EnderecosBO {
    private EnderecosDAO enderecosDAO = new EnderecosDAO();

    public ArrayList<EnderecoTO> findAll() {
        return enderecosDAO.findAll();
    }

    public EnderecoTO findById(Long id) {
        return enderecosDAO.findById(id);
    }

    public EnderecoTO save(EnderecoTO endereco) {
        return enderecosDAO.save(endereco);
    }

    public boolean delete(Long id) {
        return enderecosDAO.delete(id);
    }

    public EnderecoTO update(EnderecoTO endereco) {
        return enderecosDAO.update(endereco);
    }
}