package maxim.drozd.kmp_ht2

import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.Shape
import android.support.design.shape.ShapePath
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val image: View = itemView.findViewById(R.id.image)
    private val header: TextView = itemView.findViewById(R.id.header)
    private val caption: TextView = itemView.findViewById(R.id.caption)

    fun bind(color: Int, captionText: String){

        val gd = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(color, color))
        gd.shape = GradientDrawable.OVAL
        image.background = gd
            //        image.setBackgroundColor(color)
        header.text = "#" + Integer.toString((color - 0xFF000000).toInt(), 16).toUpperCase()
        caption.text = captionText
    }
}