package br.com.fiap.bo;

import br.com.fiap.dao.PedidosDAO;
import br.com.fiap.to.PedidosTO;

import java.util.ArrayList;

public class PedidosBO {
    private PedidosDAO pedidosDAO = new PedidosDAO();

    public ArrayList<PedidosTO> findAll() {
        return pedidosDAO.findAll();
    }

    public PedidosTO findById(Long id) {
        return pedidosDAO.findById(id);
    }

    public PedidosTO save(PedidosTO pedido) {
        return pedidosDAO.save(pedido);
    }

    public boolean delete(Long id) {
        return pedidosDAO.delete(id);
    }

    public PedidosTO update(PedidosTO pedido) {
        return pedidosDAO.update(pedido);
    }
}
