package com.htcursos.htapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.htcursos.htapp.R;
import com.htcursos.htapp.models.User;
import com.htcursos.htapp.utils.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @OnClick(R.id.btn_ok)
    public void login(){
        User user = new User();
        user.setLogin(login.getText().toString());
        user.setPassword(password.getText().toString());
        if(user.getLogin().equals("htcursos") && user.getPassword().equals("123")){
            startActivity(new Intent(BActivity.this, FActivity.class)
                    .putExtra(Constants.EXTRA_FOR_F, user)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
        }else{
            resultText.setText("Login ou senha incorreto");
            resultText.setVisibility(View.VISIBLE);
        }
    }

}
