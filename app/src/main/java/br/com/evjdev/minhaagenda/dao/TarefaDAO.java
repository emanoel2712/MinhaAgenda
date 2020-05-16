package br.com.evjdev.minhaagenda.dao;

import android.content.Context;

import br.com.evjdev.minhaagenda.dao.helpers.DaoHelper;
import br.com.evjdev.minhaagenda.model.Tarefa;

public class TarefaDAO extends DaoHelper<Tarefa> {

    public TarefaDAO(Context c) {
        super(c, Tarefa.class);
    }
}
