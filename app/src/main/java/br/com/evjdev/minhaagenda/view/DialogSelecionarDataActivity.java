package br.com.evjdev.minhaagenda.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import br.com.evjdev.minhaagenda.R;
import br.com.evjdev.minhaagenda.control.DialogSelecionarDataControl;

public class DialogSelecionarDataActivity extends AppCompatActivity {
   private DialogSelecionarDataControl control;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_selecionar_data);

        control = new DialogSelecionarDataControl(this);
    }


}
