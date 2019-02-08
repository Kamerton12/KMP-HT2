package maxim.drozd.kmp_ht2

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class IconHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private val view: View = itemView.findViewById(R.id.view)
    private val text: TextView = itemView.findViewById(R.id.text)

    fun bind(color: Int, position: Int, items: ArrayList<Int>, adapter: RecyclerView.Adapter<IconHolder>) {
        if(items[position] == -1){
            itemView.visibility = View.INVISIBLE
            return
        }
        itemView.visibility = View.VISIBLE
        itemView.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                if(v != null) {
                    //startActivity(v.context, Intent(v.context, ListActivity::class.java), null)
                    Snackbar.make(v, "pp", Snackbar.LENGTH_LONG).setAction(R.string.Delete){
                        if("notmoe".equals("notmove")){
                            v.visibility = View.INVISIBLE
                            items[position] = -1
                        }else{
                            items.removeAt(position)
                            adapter.notifyDataSetChanged()
                        }
                    }.show()
                    //TODO("Сделать разные виды удаления")
                }
                return true
            }

        })

        view.setBackgroundColor(color)
        val data = Integer.toString((color - 0xFF000000).toInt(), 16)
        text.text = "#$data".toUpperCase()
    }
}