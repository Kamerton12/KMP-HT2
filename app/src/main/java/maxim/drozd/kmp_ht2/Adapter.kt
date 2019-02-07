package maxim.drozd.kmp_ht2

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.*

class Adapter: RecyclerView.Adapter<IconHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconHolder {
        return IconHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_object, parent, false))
    }

    override fun getItemCount(): Int = 1000

    override fun onBindViewHolder(holder: IconHolder, position: Int) {
        val r = Random()
        holder.bind(Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256)))
    }

}