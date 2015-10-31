package com.htcursos.htapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.htcursos.htapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by viniciuslm on 24/10/15.
 */
public class GridAdapter extends ArrayAdapter<Integer> {

    public GridAdapter(Context context, Integer[] objects) {
        super(context, R.layout.item_grid_images, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = View
                    .inflate(getContext(), R.layout.item_grid_images, null);
            convertView.setLayoutParams(new GridView.LayoutParams(200, 200));
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Integer item = getItem(position);
        if(item != null) {
            holder.image.setImageResource(item);
        }
        return convertView;
    }


    class ViewHolder{
        @Bind(R.id.image)
        ImageView image;
    }


}
