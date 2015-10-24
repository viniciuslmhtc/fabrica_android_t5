package com.htcursos.htapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.htcursos.htapp.R;
import com.htcursos.htapp.models.User;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by viniciuslm on 24/10/15.
 */
public class UserListAdapter extends ArrayAdapter<User> {

    public UserListAdapter(Context context, List<User> objects) {
        super(context, R.layout.item_list_user, objects);
    }

    @Override
    public View getView(int position, View item, ViewGroup parent) {
        final ViewHolder holder;
        if (item == null) {
            item = View
                    .inflate(getContext(), R.layout.item_list_user, null);
            holder = new ViewHolder();
            ButterKnife.bind(holder, item);
            item.setTag(holder);
        } else {
            holder = (ViewHolder) item.getTag();
        }
        final User user = getItem(position);
        if(user != null){
            holder.userImage.setImageResource(user.getImage());
            holder.userName.setText(user.getName());
        }
        return item;
    }


    public class ViewHolder {

        @Bind(R.id.user_image)
        ImageView userImage;
        @Bind(R.id.user_name)
        TextView userName;

    }

}
