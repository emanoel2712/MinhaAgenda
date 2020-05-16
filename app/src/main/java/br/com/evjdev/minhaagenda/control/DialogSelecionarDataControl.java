package br.com.evjdev.minhaagenda.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.CalendarView;

import androidx.annotation.NonNull;

import br.com.evjdev.minhaagenda.R;
import br.com.evjdev.minhaagenda.uteis.Constantes;
import br.com.evjdev.minhaagenda.model.Tarefa;
import br.com.evjdev.minhaagenda.view.DialogTarefaActivity;

public class DialogSelecionarDataControl {
    private Activity activity;
    private CalendarView calendarView;
    private Tarefa tarefa;


    public DialogSelecionarDataControl(Activity activity) {
        this.activity = activity;

        tarefa = new Tarefa();

        initComponents();
    }


    private void initComponents() {
        calendarView = activity.findViewById(R.id.calendarView);
        configCalendar();

    }


    private void configCalendar() {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + month + "/" + year;
                Intent it = new Intent(activity, DialogTarefaActivity.class);
                it.putExtra(Constantes.PARAM_DATA_SELECIONADA, date);
                activity.startActivityForResult(it, Constantes.REQUEST_DATA_SELECIONADA);
                activity.finish();

                System.out.println(date);
//
//                Intent it = new Intent(activity, DialogTarefaActivity.class);
//                it.putExtra("data", date);
//                activity.startActivityForResult(it, 0);
//                activity.finish();


//
//                Intent it = new Intent(activity, DialogTarefaActivity.class);
//                it.putExtra("data_dd", "date_seila");
//                activity.startActivityForResult(it, 0);
////                activity.finish();
//
//                System.out.println("Data Selecionada: " + date);

            }
        });
    }





}
