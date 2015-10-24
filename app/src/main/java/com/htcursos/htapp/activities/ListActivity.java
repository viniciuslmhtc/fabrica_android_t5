package com.htcursos.htapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.htcursos.htapp.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by viniciuslm on 24/10/15.
 */
public class ListActivity extends AppCompatActivity {

    @Bind(R.id.list_view)
    ListView listView;

    //INFORMAÇÕES DA LISTA
    private static final String[] NAMES = new String[] {
            "VINICIUS",
            "JOAO",
            "VIRMERSON",
            "CARLOS",
            "DEBORA"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //SETANDO LAYOUT
        setContentView(R.layout.activity_list);
        //INICIALIZANDO BUTTERKNIFE
        ButterKnife.bind(this);
        //CRIANDO ADAPTER
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NAMES);
        //SETANDO ADAPTER
        listView.setAdapter(adapter);
    }

}
