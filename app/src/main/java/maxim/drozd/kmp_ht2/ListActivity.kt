package maxim.drozd.kmp_ht2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.content_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        recView.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = ListAdapter()
            val dec = LinearDecorator(this@ListActivity, DividerItemDecoration.VERTICAL, resources.getDimensionPixelOffset(R.dimen.offset))
            addItemDecoration(dec)
        }

        fab.setOnClickListener{
            (recView.adapter as ListAdapter).items.add(0, null)
            Log.i(MainActivity.TAG, "List element added")
            (recView.adapter as ListAdapter).notifyDataSetChanged()
        }
    }
}
