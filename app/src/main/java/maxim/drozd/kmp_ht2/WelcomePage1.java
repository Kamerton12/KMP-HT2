package maxim.drozd.kmp_ht2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomePage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = getSharedPreferences(MainActivity.SHARED_PREFERENCES_NAME, MODE_PRIVATE);
        int theme = sp.getInt(MainActivity.THEME_PREFERENCES, R.style.AppTheme);
        setTheme(theme);

        setContentView(R.layout.activity_welcome_page1);
    }

    public void nextPage(View view) {
        Intent intent = new Intent(this, WelcomePage2.class);
        startActivity(intent);
        finish();
    }
}
