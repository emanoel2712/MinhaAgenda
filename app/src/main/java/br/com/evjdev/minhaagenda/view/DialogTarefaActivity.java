package br.com.evjdev.minhaagenda.view;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.text.TimeZoneFormat;
import android.location.Location;
import android.os.Bundle;
import android.util.TimeFormatException;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import java.io.Serializable;
import java.sql.Time;
import java.text.DateFormat;
import java.util.Calendar;

import br.com.evjdev.minhaagenda.R;
import br.com.evjdev.minhaagenda.control.DialogTarefaControl;
import br.com.evjdev.minhaagenda.ui.datepicker.DatePickerFragment;
import br.com.evjdev.minhaagenda.ui.timepicker.TimerPickerFragment;
import br.com.evjdev.minhaagenda.uteis.Constantes;

public class DialogTarefaActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    public static String dataString;
    public static String horaString;
    private DialogTarefaControl control;
    private Button btData;
    private TextView tvDataSelecionada;
    private TextView tvHorarioSelecionado;
    private Button btHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_tarefa);

        btData = findViewById(R.id.btData);
        btHora = findViewById(R.id.btHora);
        tvDataSelecionada = findViewById(R.id.tvDataSelecionada);
        tvHorarioSelecionado = findViewById(R.id.tvHorarioSelecionado);

        control = new DialogTarefaControl(this);
        clickBtData();
        clickBtHora();
    }

    private void clickBtHora() {
        btHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timerPicker = new TimerPickerFragment();
                timerPicker.show(getSupportFragmentManager(), "time picker");

            }
        });
    }

    private void clickBtData() {
        btData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");

            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar c = Calendar.getInstance();

        //seta o ano, mes e dia após o usuário clicar no ok
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        dataString = DateFormat.getDateInstance().format(c.getTime());

        tvDataSelecionada.setText("Data Selecionada: " + "\n" + dataString);

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);

        horaString = DateFormat.getTimeInstance().format(c.getTime());
//        horaString = DateFormat.getInstance().format(c.getTime());

        tvHorarioSelecionado.setText("Horario Selecionado: " + "\n" + horaString);

    }
}
