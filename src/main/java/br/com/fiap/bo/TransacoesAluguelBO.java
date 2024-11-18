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

    public TransacoesAluguelTO save(TransacoesAluguelTO transacao) {
        return transacoesAluguelDAO.save(transacao);
    }

    public boolean delete(Long id) {
        return transacoesAluguelDAO.delete(id);
    }

    public TransacoesAluguelTO update(TransacoesAluguelTO transacao) {
        return transacoesAluguelDAO.update(transacao);
    }
}
