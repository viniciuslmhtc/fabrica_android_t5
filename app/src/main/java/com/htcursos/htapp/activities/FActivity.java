package com.htcursos.htapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.htcursos.htapp.R;
import com.htcursos.htapp.models.User;
import com.htcursos.htapp.utils.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by viniciuslm on 17/10/15.
 */
public class FActivity extends AppCompatActivity {

    @Bind(R.id.edit_text)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f);
        ButterKnife.bind(this);
        if(getIntent().getExtras().containsKey(Constants.EXTRA_FOR_F)){
            User user = (User) getIntent().getSerializableExtra(Constants.EXTRA_FOR_F);
            editText.setText(user.getLogin() +":"+ user.getPassword());
        }
    }


    @OnClick(R.id.btn_go_to_g)
    public void goToActivityG(){
        Intent i = new Intent(FActivity.this, GActivity.class);
        i.putExtra(Constants.EXTRA_FOR_G ,editText.getText().toString());
        startActivity(i);
    }

}
