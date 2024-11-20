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

    public ItensPedidoTO update(ItensPedidoTO item) throws Exception{
        ArrayList<String> ifTipoTras = new ArrayList<String>();
        ifTipoTras.add("Venda");
        ifTipoTras.add("Aluguel");

        if (!ifTipoTras.contains(item.getTipoTransacao())){
            throw new Exception("informação TipoTransação inválido. Permitidos: " + ifTipoTras );
        }
        return itensPedidosDAO.update(item);
    }
}
