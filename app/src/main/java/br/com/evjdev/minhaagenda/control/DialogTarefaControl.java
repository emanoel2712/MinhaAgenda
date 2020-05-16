package br.com.evjdev.minhaagenda.control;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.evjdev.minhaagenda.R;
import br.com.evjdev.minhaagenda.dao.TarefaDAO;
import br.com.evjdev.minhaagenda.model.Tarefa;
import br.com.evjdev.minhaagenda.model.TarefaBO;
import br.com.evjdev.minhaagenda.uteis.Constantes;
import br.com.evjdev.minhaagenda.view.DialogSelecionarDataActivity;
import br.com.evjdev.minhaagenda.view.DialogTarefaActivity;
import br.com.evjdev.minhaagenda.view.MainActivity;

public class DialogTarefaControl {


    private Activity activity;
    private EditText editNome;
    private EditText editDescricao;
    private TextView tvDataHoraSelecionada;
    private Button btSalvar;
    private TarefaDAO tarefaDao;
    private List<Tarefa> listTarefa;

    public DialogTarefaControl(Activity activity) {
        this.activity = activity;
        tarefaDao = new TarefaDAO(activity);

        initComponents();

    }


    private void initComponents() {
        editNome = activity.findViewById(R.id.editNomeTarefa);
        editDescricao = activity.findViewById(R.id.editDescTarefa);
        tvDataHoraSelecionada = activity.findViewById(R.id.tvDataSelecionada);
        btSalvar = activity.findViewById(R.id.btSalvar);

        salvarAction();

    }


    private Tarefa getDadosForm() {
        Tarefa t = new Tarefa();
        t.setNome(editNome.getText().toString());
        t.setDesc(editDescricao.getText().toString());
        t.setData(DialogTarefaActivity.dataString);
        t.setHora(DialogTarefaActivity.horaString);
        return t;
    }


    private void salvarAction() {
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listTarefa = new ArrayList<>();

                Tarefa tarefa = getDadosForm();
                try {
                    Dao.CreateOrUpdateStatus res = tarefaDao.getDao().createOrUpdate(tarefa);
                    System.out.println(tarefa);

                    if (res.isCreated()) {
                        listTarefa.add(tarefa);
                        Toast.makeText(activity, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
                    }


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }


//                Bundle extras = activity.getIntent().getExtras();
//                String paramRecebidoPelaActivity1 = extras.getString(Constantes.PARAM_DATA_SELECIONADA);


            }

        });

    }


//pegat dataSelecionada
//    String date = getIntent().getStringExtra(Constantes.PARAM_DATA_SELECIONADA);

//    TextView textViewDataSelecionada = findViewById(R.id.textDataSelecionada);
//        String date = getIntent().getStringExtra("date");

//        if (date != null) {
//            textViewDataSelecionada.setText(date);


//    public void clickEditData() {
//        Intent it = new Intent(activity, DialogSelecionarDataActivity.class);
//        it.putExtra(Constantes.PARAM_DATA_SELECIONADA, Constantes.REQUEST_DATA_SELECIONADA);
//        activity.startActivity(it);
//        activity.finish();
//
//
//    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == Constantes.REQUEST_DATA_SELECIONADA) {
            String date = data.getStringExtra(Constantes.PARAM_DATA_SELECIONADA);
            String hora = data.getStringExtra(Constantes.PARAM_DATA_SELECIONADA);

//                editData.setText(data);
            tvDataHoraSelecionada.setText("Data e Hora Selecionada: " + "\nData: " + date + "\nHora:" + hora);


//            tarefa.setData(data.toString());
//            tarefa.setData(date);
//            tarefa.setHora(hora);


            System.out.println("Data retornada activity" + date);

        }
    }
}
