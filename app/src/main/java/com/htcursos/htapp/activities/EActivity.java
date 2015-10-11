package com.htcursos.htapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.htcursos.htapp.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by viniciuslm on 10/10/15.
 */
public class EActivity extends AppCompatActivity {

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.my_text)
    EditText text;
    @Bind(R.id.btn_ok)
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Definindo arquivo de layout
        setContentView(R.layout.activity_e);
        //Inicializando butterknife
        ButterKnife.bind(this);
        //FORMA NATIVA
//        TextView title = (TextView) findViewById(R.id.title);
//        EditText text = (EditText) findViewById(R.id.my_text);
//        Button btnOk = (Button) findViewById(R.id.btn_ok);


        //METODO NATIVO ONCLICKLISTENER
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText(text.getText());
                text.setText("");
            }
        });
//        btnOk.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                title.setText("TESTE");
//                return true;
//            }
//        });
    }



    //METODO ONLONGLICK COM BUTTERKNIFE
//    @OnLongClick(R.id.btn_ok)
//    public boolean changeText(){
//        title.setText("TESTE");
//        return true;
//    }


}


















