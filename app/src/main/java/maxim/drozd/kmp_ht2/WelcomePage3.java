package maxim.drozd.kmp_ht2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class WelcomePage3 extends AppCompatActivity {

    RadioButton light, dark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = getSharedPreferences(MainActivity.SHARED_PREFERENCES_NAME, MODE_PRIVATE);
        int theme = sp.getInt(MainActivity.THEME_PREFERENCES, R.style.AppTheme);
        setTheme(theme);

        setContentView(R.layout.activity_welcome_page3);

        light = findViewById(R.id.radioButton);
        dark = findViewById(R.id.radioButton2);

        if(theme == R.style.DarkAppTheme)
            dark.setChecked(true);

        light.setOnCheckedChangeListener((group, checked) -> {
            if(checked) {
                sp.edit().putInt(MainActivity.THEME_PREFERENCES, R.style.AppTheme).apply();
            } else {
                sp.edit().putInt(MainActivity.THEME_PREFERENCES, R.style.DarkAppTheme).apply();
            }
            recreate();
        });
    }

    public void onNext(View view)
    {
        Intent intent = new Intent(this, WelcomePage4.class);
        startActivity(intent);
        finish();
    }
}
