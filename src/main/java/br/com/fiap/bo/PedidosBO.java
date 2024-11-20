package br.com.fiap.bo;

import br.com.fiap.dao.PedidosDAO;
import br.com.fiap.to.ItensPedidoTO;
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

    public PedidosTO save(PedidosTO pedido) throws Exception{
        ArrayList<String> ifStatus = new ArrayList<String>();
        ifStatus.add("Pendente");
        ifStatus.add("Concluido");
        ifStatus.add("Cancelado");
        ArrayList<String> ifTipoTras = new ArrayList<String>();
        ifTipoTras.add("Venda");
        ifTipoTras.add("Aluguel");
        ifTipoTras.add("Ambos");
        ArrayList<String> ifTipoTras2 = new ArrayList<String>();
        ifTipoTras2.add("Venda");
        ifTipoTras2.add("Aluguel");
        boolean status = true;
        for (ItensPedidoTO item : pedido.getItensPedido()){
            if (!ifTipoTras2.contains(item.getTipoTransacao())){
                status = false;
            }
        }
        if (!ifStatus.contains(pedido.getStatus()) || !ifTipoTras.contains(pedido.getTipoTransacao()) || status == false){
            throw new Exception("informação status ou TipoTransação(pedido) ou TipoTransação(itemPedido) inválido. Permitidos: " + ifStatus + " ou " + ifTipoTras + " ou " + ifTipoTras2 );
        }
        return pedidosDAO.save(pedido);
    }

    public boolean delete(Long id) {
        return pedidosDAO.delete(id);
    }

    public PedidosTO update(PedidosTO pedido) throws Exception{
        ArrayList<String> ifStatus = new ArrayList<String>();
        ifStatus.add("Pendente");
        ifStatus.add("Concluido");
        ifStatus.add("Cancelado");
        ArrayList<String> ifTipoTras = new ArrayList<String>();
        ifTipoTras.add("Venda");
        ifTipoTras.add("Aluguel");
        ifTipoTras.add("Ambos");
        if (!ifStatus.contains(pedido.getStatus()) && !ifTipoTras.contains(pedido.getTipoTransacao())){
            throw new Exception("informação status ou TipoTransação inválido. Permitidos: " + ifStatus + " ou " + ifTipoTras );
        }
        return pedidosDAO.update(pedido);
    }
}
