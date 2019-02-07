package maxim.drozd.kmp_ht2

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.View

class LinearDecorator(context: Context?, orientation: Int, val offset: Int) : DividerItemDecoration(context, orientation){
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.top += offset
        outRect.bottom += offset
    }
}