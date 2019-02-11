package maxim.drozd.kmp_ht2

import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class Adapter: RecyclerView.Adapter<IconHolder>() {

    val items = ArrayList<Int?>()

    init {
        for(i in 0.. 999)
            items.add(null)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconHolder {
        return IconHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_object, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: IconHolder, position: Int) {
        val r = Random()
//        if(position >= items.size)
//            for(i in 0..position - items.size + 1)
        if(items[position] == null)
            items[position] =  Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256))
        holder.bind(position, items, this)
    }
}