package br.com.evjdev.minhaagenda.control;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.evjdev.minhaagenda.R;
import br.com.evjdev.minhaagenda.dao.TarefaDAO;
import br.com.evjdev.minhaagenda.model.Tarefa;
import br.com.evjdev.minhaagenda.uteis.Constantes;
import br.com.evjdev.minhaagenda.view.DialogTarefaActivity;

public class HomeControl {
    private Fragment fragment;
    private View recyclerView;
    private TarefaDAO tarefaDAO;

//    private Button button;

    public HomeControl(Fragment fragment) {
        this.fragment = fragment;
        initComponents();
//        clickAddTarefa();
    }

    private void initComponents() {


    }

}
