package com.example.denis.tecladov3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;

public class Aula02Activity extends AppCompatActivity {
    Realm Consult_realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula02);
        Consult_realm = Realm.getDefaultInstance();
        try{
            final ArrayList<Gerencia> mercadorias = new ArrayList<Gerencia>();
            Gerencia usuarioview =Consult_realm.where(Gerencia.class).equalTo("id","0").findFirst();
            //ArrayAdapter<Mercadoria> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,mercadorias);
            mercadorias.add(usuarioview);

             TextView Result_txtnome = (TextView)findViewById(R.id.mshnota);
             Result_txtnome.setText(usuarioview.getNome().toString());
        }
        catch (Exception e){
            Toast.makeText(this, "Deu Errado", Toast.LENGTH_SHORT).show();

        }

    }
}
