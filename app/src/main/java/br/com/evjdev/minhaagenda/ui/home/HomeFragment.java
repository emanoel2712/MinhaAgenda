package br.com.evjdev.minhaagenda.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.evjdev.minhaagenda.R;
import br.com.evjdev.minhaagenda.control.TarefaAdapter;
import br.com.evjdev.minhaagenda.dao.TarefaDAO;
import br.com.evjdev.minhaagenda.model.Tarefa;
import br.com.evjdev.minhaagenda.uteis.Constantes;
import br.com.evjdev.minhaagenda.view.DialogTarefaActivity;

public class HomeFragment extends Fragment {

    private View recyclerView;
    private RecyclerView.Adapter adapter;
    private View root;
    private TarefaDAO tarefaDAO;
    private Button button;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);

        initComponents();

        return root;
    }


    private void initComponents() {
        button = root.findViewById(R.id.btAddTarefa);

        recyclerView = root.findViewById(R.id.recyclerViewTarefas);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);


        clickAddTarefa();
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        try {
            tarefaDAO = new TarefaDAO(getContext());
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new TarefaAdapter(getContext(), tarefaDAO.getDao().queryForAll()));
            System.out.println(tarefaDAO.getDao().queryForAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void configRecyclerView(RecyclerView recyclerView) {
        try {
            tarefaDAO = new TarefaDAO(getContext());


            recyclerView.setAdapter((RecyclerView.Adapter) tarefaDAO.getDao().queryForAll());
//            atualizaRecyclerView(recyclerView);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //
    private void atualizaRecyclerView(RecyclerView recyclerView) {
        recyclerView.getAdapter().notifyDataSetChanged();
    }


    private void clickAddTarefa() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), DialogTarefaActivity.class);
                startActivity(it);

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        setupRecyclerView((RecyclerView) recyclerView);
    }
}





