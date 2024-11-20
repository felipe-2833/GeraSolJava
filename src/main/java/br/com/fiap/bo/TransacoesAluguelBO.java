package br.com.fiap.bo;

import br.com.fiap.dao.TransacoesAluguelDAO;
import br.com.fiap.to.TransacoesAluguelTO;

import java.util.ArrayList;

public class TransacoesAluguelBO {
    private TransacoesAluguelDAO transacoesAluguelDAO = new TransacoesAluguelDAO();

    public ArrayList<TransacoesAluguelTO> findAll() {
        return transacoesAluguelDAO.findAll();
    }

    public TransacoesAluguelTO findById(Long id) {
        return transacoesAluguelDAO.findById(id);
    }

    public TransacoesAluguelTO save(TransacoesAluguelTO transacao) throws Exception{
        ArrayList<String> ifStatus = new ArrayList<String>();
        ifStatus.add("Ativo");
        ifStatus.add("Concluido");
        ifStatus.add("Cancelado");
        if (!ifStatus.contains(transacao.getStatusAluguel())){
            throw new Exception("informação statusAluguel inválido. Permitidos: " + ifStatus);
        }
        return transacoesAluguelDAO.save(transacao);
    }

    public boolean delete(Long id) {
        return transacoesAluguelDAO.delete(id);
    }

    public TransacoesAluguelTO update(TransacoesAluguelTO transacao) throws Exception{
        ArrayList<String> ifStatus = new ArrayList<String>();
        ifStatus.add("Ativo");
        ifStatus.add("Concluido");
        ifStatus.add("Cancelado");
        if (!ifStatus.contains(transacao.getStatusAluguel())){
            throw new Exception("informação statusAluguel inválido. Permitidos: " + ifStatus);
        }
        return transacoesAluguelDAO.update(transacao);
    }
}
