package br.com.evjdev.minhaagenda.dao.helpers;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import br.com.evjdev.minhaagenda.model.Tarefa;

public class MyORMLiteHelper extends OrmLiteSqliteOpenHelper {

    private static final String db_name = "agendaaa";
    private static final int db_version = 15;

    public MyORMLiteHelper(Context context) {
        super(context, db_name, null, db_version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Tarefa.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Tarefa.class, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
