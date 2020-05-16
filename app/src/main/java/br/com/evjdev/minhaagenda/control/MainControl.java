package br.com.evjdev.minhaagenda.control;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.evjdev.minhaagenda.R;

public class MainControl {
    private Activity activity;
    private BottomNavigationView bottomNavigationView;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;

    public MainControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        bottomNavigationView = activity.findViewById(R.id.nav_view);
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home,
                 R.id.navigation_notifications).build();

        navController = Navigation.findNavController(activity, R.id.nav_host_fragment);

        setupActionBarControlNavigation();
    }

    private void setupActionBarControlNavigation() {
        NavigationUI.setupActionBarWithNavController((AppCompatActivity) activity, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}
