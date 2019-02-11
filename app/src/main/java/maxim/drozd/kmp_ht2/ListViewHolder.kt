package maxim.drozd.kmp_ht2

import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.Shape
import android.opengl.Visibility
import android.support.design.shape.ShapePath
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val image: View = itemView.findViewById(R.id.image)
    private val header: TextView = itemView.findViewById(R.id.header)
    private val caption: TextView = itemView.findViewById(R.id.caption)

    fun bind(captionText: String, position: Int, adapter:ListAdapter, items: ArrayList<ListAdapter.Field?>){
        val color = items[position]!!.color

        val gd = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(color, color))
        gd.shape = GradientDrawable.OVAL
        image.background = gd
        image.setOnLongClickListener{view ->
            Snackbar.make(view, R.string.Delete, Snackbar.LENGTH_LONG).setAction(R.string.Yes){
                items.removeAt(position)
                Log.i(MainActivity.TAG, "List element deleted")
                adapter.notifyDataSetChanged()
            }.show()
            return@setOnLongClickListener true
        }
            //        image.setBackgroundColor(color)
        header.text = "#" + Integer.toString((color - 0xFF000000).toInt(), 16).toUpperCase()
        caption.text = captionText
    }
}