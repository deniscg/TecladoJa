package com.example.denis.tecladov3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class Aula02Activity extends AppCompatActivity {
    Realm Consult_realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula02);
        //-------------------------------------
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Histórico");     //Titulo para ser exibido na sua Action Bar em frente à seta
        //-------------------------------------
        Consult_realm = Realm.getDefaultInstance();
        try{
            final ArrayList<Gerencia> mercadorias = new ArrayList<Gerencia>();
            RealmResults<Gerencia> usuarioview = Consult_realm.where(Gerencia.class).findAll();
            //Gerencia usuarioview =Consult_realm.where(Gerencia.class).equalTo("id","0").findFirst();
            //ArrayAdapter<Mercadoria> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,mercadorias);
           // mercadorias.add(usuarioview);

             TextView Result_txtnome = (TextView)findViewById(R.id.mshnota);
             Result_txtnome.setText(usuarioview.get(1).getNome().toString());
        }
        catch (Exception e){
            Toast.makeText(this, "Deu Errado", Toast.LENGTH_SHORT).show();

        }

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                //setContentView(R.layout.activity_curso);
                startActivity(new Intent(this, CursoActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                return true;
            // break;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
