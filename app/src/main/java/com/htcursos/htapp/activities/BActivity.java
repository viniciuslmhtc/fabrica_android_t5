package com.htcursos.htapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.htcursos.htapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by viniciuslm on 10/10/15.
 */
public class BActivity extends AppCompatActivity {

    @Bind(R.id.login)
    EditText login;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.btn_ok)
    Button btnOk;
    @Bind(R.id.text_result)
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ButterKnife.bind(this);
    }

}
