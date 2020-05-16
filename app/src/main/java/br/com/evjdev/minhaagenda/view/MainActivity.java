package br.com.evjdev.minhaagenda.view;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import br.com.evjdev.minhaagenda.R;
import br.com.evjdev.minhaagenda.control.MainControl;

public class MainActivity extends AppCompatActivity {
    private MainControl mainControl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainControl = new MainControl(this);
    }


}
