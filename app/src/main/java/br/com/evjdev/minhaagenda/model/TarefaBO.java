package br.com.evjdev.minhaagenda.model;

public class TarefaBO {

    public static boolean validaNome(Tarefa tarefa) {
        return tarefa.getNome() != null && !tarefa.getNome().isEmpty();

    }

    public static boolean validaDesc(Tarefa tarefa) {
        return tarefa.getDesc() != null && !tarefa.getDesc().isEmpty();

    }
}
