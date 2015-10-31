package com.htcursos.htapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.htcursos.htapp.R;
import com.htcursos.htapp.adapters.UserListAdapter;
import com.htcursos.htapp.models.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by viniciuslm on 24/10/15.
 */
public class UserListActivity extends AppCompatActivity {

    @Bind(R.id.list_view)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        user1.setName("Vinicius");
        user1.setImage(R.drawable.ic_profile_noavatar);
        user2.setName("Debora");
        user2.setImage(R.drawable.ic_profile_noavatar);
        user3.setName("Carlos");
        user3.setImage(R.drawable.ic_profile_noavatar);
        user4.setName("Virmerson");
        user4.setImage(R.drawable.ic_profile_noavatar);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        final UserListAdapter adapter  = new UserListAdapter(this, users);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(UserListActivity.this, adapter.getItem(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
