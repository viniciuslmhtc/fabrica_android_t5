package com.htcursos.htapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.htcursos.htapp.R;
import com.htcursos.htapp.utils.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by viniciuslm on 17/10/15.
 */
public class GActivity extends AppCompatActivity {

    @Bind(R.id.text)
    TextView text;
    @Bind(R.id.btn_back)
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g);
        ButterKnife.bind(this);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(getIntent().getExtras().containsKey(Constants.EXTRA_FOR_G)){
            //Qualquer das formas
//           text.setText(getIntent().getExtras().getString(Constants.EXTRA_FOR_G));
            text.setText(getIntent().getStringExtra(Constants.EXTRA_FOR_G));
        }
    }

}
