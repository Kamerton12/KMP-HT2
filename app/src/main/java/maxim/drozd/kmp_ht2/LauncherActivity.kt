package maxim.drozd.kmp_ht2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.support.v4.content.res.TypedArrayUtils
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.QuickContactBadge
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_launcher.*
import kotlinx.android.synthetic.main.content_launcher.*

import java.util.ArrayList
import java.util.Arrays

import java.util.Arrays.asList

class LauncherActivity : AppCompatActivity() {


    internal var pi = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sp = getSharedPreferences(MainActivity.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
        val theme = if (R.style.AppTheme == sp.getInt(MainActivity.THEME_PREFERENCES, R.style.AppTheme)) R.style.AppThemeActionBar else R.style.DarkAppThemeActionBar
        setTheme(theme)

        setContentView(R.layout.activity_launcher)

        val span: Int

        val orientation = resources.configuration.orientation
        val isNormalLayout = getSharedPreferences(MainActivity.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE).getBoolean(MainActivity.IS_NORMAL_LAYOUT, true)

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (isNormalLayout)
                span = 6
            else
                span = 7
        } else {
            if (isNormalLayout)
                span = 4
            else
                span = 5
        }

        rec.adapter = Adapter()
        val manager = GridLayoutManager(this, span)
        rec.layoutManager = manager
        val off = resources.getDimensionPixelOffset(R.dimen.half_offset)
        rec.addItemDecoration(CustomDecorator(off))

        fab.setOnClickListener{view ->
            TODO("Реализовать нормальное добавление + хранить компоненты")
            Snackbar.make(view, "Hello", Snackbar.LENGTH_LONG).show()
        }
    }
}
