package br.com.fiap.bo;

import br.com.fiap.dao.ItensPedidosDAO;
import br.com.fiap.to.ItensPedidoTO;

import java.util.ArrayList;

public class ItensPedidosBO {
    private ItensPedidosDAO itensPedidosDAO = new ItensPedidosDAO();

    public ArrayList<ItensPedidoTO> findAll() {
        return itensPedidosDAO.findAll();
    }

    public ItensPedidoTO findById(Long id) {
        return itensPedidosDAO.findById(id);
    }

    public boolean delete(Long id) {
        return itensPedidosDAO.delete(id);
    }

    public ItensPedidoTO update(ItensPedidoTO item) {
        return itensPedidosDAO.update(item);
    }
}
