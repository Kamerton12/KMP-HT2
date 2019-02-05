package maxim.drozd.kmp_ht2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;

public class WelcomePage4 extends AppCompatActivity {

    RadioButton def, dens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = getSharedPreferences(MainActivity.SHARED_PREFERENCES_NAME, MODE_PRIVATE);
        int theme = sp.getInt(MainActivity.THEME_PREFERENCES, R.style.AppTheme);
        setTheme(theme);

        setContentView(R.layout.activity_welcome_page4);

        def = findViewById(R.id.radioButton);
        dens = findViewById(R.id.radioButton2);

        if(!sp.getBoolean(MainActivity.IS_NORMAL_LAYOUT, true)){
            def.setChecked(false);
            dens.setChecked(true);
        }

        def.setOnClickListener((view) -> {
            def.setChecked(true);
            dens.setChecked(false);
        });

        dens.setOnClickListener((view) -> {
            def.setChecked(false);
            dens.setChecked(true);
        });
    }

    public void btnClick(View v) {
        SharedPreferences sp = getSharedPreferences(MainActivity.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(MainActivity.IS_NORMAL_LAYOUT, def.isChecked()).apply();
        Intent intent = new Intent(this, LauncherActivity.class);
        startActivity(intent);
        finish();
    }

}
