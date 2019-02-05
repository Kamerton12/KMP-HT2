package maxim.drozd.kmp_ht2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColorfullAdapter extends ArrayAdapter<String>{

    int resource;

    public ColorfullAdapter(Context context, int resource, List data) {
        super(context, resource, data);
        this.resource = resource;
    }

    @Override
    public View getView(int position,  View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if(convertView == null) {
            v = new CView(getContext());
        }


        int color = 0xFF000000;
        Random r = new Random();
        color += r.nextInt(256) << 16;
        color += r.nextInt(256) << 8;
        color += r.nextInt(256);

        v.setBackgroundColor(color);

        Log.d("AAAAAAAA", v.getHeight() + " " + v.getWidth());


        v.setTag(color);

        return v;
    }


}
