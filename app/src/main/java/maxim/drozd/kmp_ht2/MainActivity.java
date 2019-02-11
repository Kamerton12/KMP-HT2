package maxim.drozd.kmp_ht2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TAGGGGG";
    public static final String SHARED_PREFERENCES_NAME = "maxim.drozd.kmp_ht2.SHP";
    public static final String THEME_PREFERENCES = "maxim.drozd.kmp_ht2.SHP.theme";
    public static final String FIRST_LAUNCH = "maxim.drozd.kmp_ht2.SHP.firstLaunch";
    public static final String IS_NORMAL_LAYOUT = "maxim.drozd.kmp_ht2.SHP.IsNormalLayout";

    ImageView image;
    int themeId;
    static boolean firstSessionLaunch = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = getSharedPreferences(MainActivity.SHARED_PREFERENCES_NAME, MODE_PRIVATE);
        themeId = sp.getInt(MainActivity.THEME_PREFERENCES, R.style.AppTheme);
        setTheme(themeId);

        setContentView(R.layout.activity_main);
        //sp.edit().putBoolean(FIRST_LAUNCH, true).apply();
        boolean firstLaunch = sp.getBoolean(FIRST_LAUNCH, true);

        if(firstSessionLaunch) {
//            Intent intent = new Intent(this, LauncherActivity.class);
            Intent intent = new Intent(this, ListActivity.class);
            startActivity(intent);
        }


        if(firstLaunch && firstSessionLaunch)
        {
            Intent intent2 = new Intent(this, WelcomePage1.class);
            sp.edit().putBoolean(FIRST_LAUNCH, false).apply();
            startActivity(intent2);
        }

        TextView link = findViewById(R.id.textView2);
        String href = "https://github.com/Kamerton12";
        String text = getResources().getString(R.string.Text);
        String textOut = "<a href=\"" + href + "\">" + text + "</a>";
        link.setText(Html.fromHtml(textOut));

        link.setMovementMethod(LinkMovementMethod.getInstance());

        firstSessionLaunch = false;

        image = findViewById(R.id.imageView);
        image.setOnLongClickListener((view)->  {
            Intent intent2 = new Intent(MainActivity.this, WelcomePage1.class);
            startActivity(intent2);
            return true;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(themeId != getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE).getInt(MainActivity.THEME_PREFERENCES, R.style.AppTheme)){
            recreate();
        }
    }
}
