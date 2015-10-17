package com.htcursos.htapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.htcursos.htapp.R;

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
    }


    @OnClick(R.id.btn_go_to_g)
    public void goToActivityG(){
        Intent i = new Intent(FActivity.this, GActivity.class);
        startActivity(i);
    }

}
