package maxim.drozd.kmp_ht2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class LauncherActivity extends AppCompatActivity {

    GridView gv;
    ArrayAdapter<String> adapter;

    int pi = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = getSharedPreferences(MainActivity.SHARED_PREFERENCES_NAME, MODE_PRIVATE);
        int theme = ((R.style.AppTheme == sp.getInt(MainActivity.THEME_PREFERENCES, R.style.AppTheme))?R.style.AppThemeActionBar:R.style.DarkAppThemeActionBar);
        setTheme(theme);

        setContentView(R.layout.activity_launcher);
        gv = findViewById(R.id.gridView);
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 50; i++)
            list.add("1");

        adapter = new ColorfullAdapter(this, R.layout.object, list);

        gv.setAdapter(adapter);

        gv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(LauncherActivity.this, "#" + Integer.toString((int)view.getTag() - 0xFF000000, 16), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        int orientation = getResources().getConfiguration().orientation;
        boolean isNormalLayout = getSharedPreferences(MainActivity.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE).getBoolean(MainActivity.IS_NORMAL_LAYOUT, true);
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if(isNormalLayout)
                gv.setNumColumns(6);
            else
                gv.setNumColumns(7);
        } else {
            if(isNormalLayout)
                gv.setNumColumns(4);
            else
                gv.setNumColumns(5);
        }
    }
}
